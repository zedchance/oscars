package api;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

public class OMDb_Fetch
{
    private JsonElement results;
    private String query;

    /**
     * Constructs a OMDb_Fetch object which consists of
     * an array of the information returned from the OMDb API
     */
    OMDb_Fetch(String title)
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
     * ??? as a means to access the index
     */
    String getInfo(String accessLabel, int index)
    {
        if (index >= 0 && index <= 6) {
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

    // Used to get ID after OMDb_Fetch is called.
    String getID()
    {
        return getInfo("imdbID", 0);
    }

    // Used to build IMDb Link after OMDb_Fetch is called.
    String buildLink()
    {
        return "https://www.imdb.com/title/" + getID() + "/";
    }

    // Used to get Year after OMDb_Fetch is called.
    String getYear()
    {
        return getInfo("Year", 0);
    }

    // Used to get Genre after OMDb_Fetch is called.
    String getGenre()
    {
        return getInfo("Genre", 0);
    }

    // Used to get Plot after OMDb_Fetch is called.
    String getPlot()
    {
        return getInfo("Plot", 0);
    }

    // Used to get Poster Link after OMDb_Fetch is called.
    String getPoster()
    {
        return getInfo("Poster", 0);
    }
}