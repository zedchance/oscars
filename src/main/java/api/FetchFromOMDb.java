package api;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Logger;

public class FetchFromOMDb
{
    private JsonElement results;
    private String queryTitle;
    private String queryYear;
    private Logger log = Logger.getLogger("api.log");

    /**
     * Constructs an FetchFromOMDb object which consists of
     * an array of the information returned from the OMDb API
     */
    FetchFromOMDb(String title, String year)
    {
        try
        {
            // Encode title and year properly for URL
            queryTitle = Formatter.formatURL(title);
            queryYear = Formatter.formatURL(year);

            // URL concatenation
            String urlString = "http://www.omdbapi.com/?apikey=" + APIKeys.OMDB_ID
                    + "&t=" + queryTitle + "&y=" + queryYear + "&plot=full";
            URL url = new URL(urlString);

            // Open streams
            InputStream is;
            is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            // Parse JSON
            results = new JsonParser().parse(br);
        }
        catch (IOException e)
        {
            log.info(e.getMessage());
        }
    }

    /**
     * This method is a generic getter that will return a string result
     * of the requested object (Title, Year, Genre, Plot, etc.) using the specified
     * field name as a means to access the correct information.
     */
    String getInfo(String accessLabel)
    {
        try
        {
            return results.getAsJsonObject().get(accessLabel).getAsString();
        }
        catch (java.lang.NullPointerException e)
        {
            //Exception disregards if checked object is empty
        }
        return "";
    }

    // Used to get Title after FetchFromOMDb is called.
    String getTitle()
    {
        return getInfo("Title");
    }

    // Used to get Year after FetchFromOMDb is called.
    String getYear()
    {
        return getInfo("Year");
    }

    // Used to get Genre after FetchFromOMDb is called.
    String getGenre()
    {
        return getInfo("Genre");
    }

    // Used to get Plot after FetchFromOMDb is called.
    String getPlot()
    {
        return getInfo("Plot");
    }

    // Used to get Poster Link after FetchFromOMDb is called.
    String getPoster()
    {
        return getInfo("Poster");
    }

    // Used to build IMDb Link after FetchFromOMDb is called.
    String getWebsite()
    {
        return "https://www.imdb.com/title/" + getInfo("imdbID") + "/";
    }

    // Used to get Response after FetchFromOMDb is called.
    String getResponse()
    {
        return getInfo("Response");
    }

    // Used to get Error after FetchFromOMDb is called and Response is false.
    String getError()
    {
        return getInfo("Error");
    }

    /**
     * Checks if the API query was successful or not
     *
     * @return success true or false
     */
    boolean isSuccessful()
    {
        return (getResponse().equals("True"));
    }
}
