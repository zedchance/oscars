package api;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FetchFromTMDb
{
    private MovieResults results;

    public class MovieResults
    {
        public Results[] results;

        public class Results
        {
            public int id;
            public String title;
            public String release_date;
            public String original_language;
            public String original_title;
            public String backdrop_path;
            public String overview;
            public String poster_path;

        }
    }

    FetchFromTMDb(String title)
    {
        String safeTitle = URLEncoder.encode(title, StandardCharsets.UTF_8);
        Map<String, String> params = Map.of("query", safeTitle, "api_key", APIKeys.TMDB_ID, "language", "en-US");
        initialize(params);
    }

    FetchFromTMDb(String title, int year)
    {
        String safeTitle = URLEncoder.encode(title, StandardCharsets.UTF_8);
        Map<String, String> params = Map.of("query", safeTitle, "api_key", APIKeys.TMDB_ID, "language", "en-US", "year", String.valueOf(year));
        initialize(params);
    }

    public void initialize(Map<String, String> queryParameters)
    {
        try
        {
            ArrayList<String> queryPairs = new ArrayList<>();
            for (Entry<String, String> param : queryParameters.entrySet())
            {
                queryPairs.add(param.getKey() + "=" + param.getValue());
            }
            String paramString = String.join("&", queryPairs);
            String urlString = "https://api.themoviedb.org/3/search/movie?" + paramString;

            URL url = new URL(urlString);

            // Open streams
            InputStream is;
            is = url.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String json = br.lines().collect(Collectors.joining());
            results = new Gson().fromJson(json, MovieResults.class);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public MovieResults getResults()
    {
        return results;
    }
}