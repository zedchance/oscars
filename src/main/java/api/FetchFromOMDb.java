package api;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

public class FetchFromOMDb
{
    private JsonElement results;
    private String query;

    /**
     * Constructs an FetchFromOMDb object which consists of
     * an array of the information returned from the OMDb API
     */
    FetchFromOMDb(String title)
    {
        try
        {
            //Encode location
            query = URLEncoder.encode(title, "UTF-8");

            //URL concatenation
            String urlString = "http://www.omdbapi.com/?apikey=" + APIKeys.OMDB_ID
                    + "&t=" + query + "&plot=full";
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
            e.printStackTrace();
        }
    }

    /**
     * This method is a generic getter that will return a string result
     * of the requested object (Title, Year, Genre, Plot, etc.) using the specified
     * field name as a means to access the correct information.
     */
    String getInfo(String accessLabel, int index)
    {
        if (index >= 0 && index <= 2)
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
        else
        {
            return "invalid index";
        }
    }

    // Used to get Title after FetchFromOMDb is called.
    String getTitle()
    {
        return getInfo("Title", 0);
    }

    // Used to get Year after FetchFromOMDb is called.
    String getYear()
    {
        return getInfo("Year", 0);
    }

    // Used to get Genre after FetchFromOMDb is called.
    String getGenre()
    {
        return getInfo("Genre", 0);
    }

    // Used to get Plot after FetchFromOMDb is called.
    String getPlot()
    {
        return getInfo("Plot", 0);
    }

    // Used to get Poster Link after FetchFromOMDb is called.
    String getPoster()
    {
        return getInfo("Poster", 0);
    }

    // Used to get IMDb ID after FetchFromOMDb is called.
    String getID()
    {
        return getInfo("imdbID", 0);
    }

    // Used to build IMDb Link after FetchFromOMDb is called.
    String buildLink()
    {
        return "https://www.imdb.com/title/" + getID() + "/";
    }

    // Used to get Response after FetchFromOMDb is called.
    String getResponse()
    {
        return getInfo("Response", 0);
    }

    // Used to get Error after FetchFromOMDb is called and Response is false.
    String getError()
    {
        return getInfo("Error", 0);
    }

    /**
     * Checks if the API query was successful or not
     *
     * @return success true or false
     */
    boolean isSuccessful()
    {
        //System.out.println(getInfo("Response", 0));
        return (getResponse().equals("True"));
    }
}
