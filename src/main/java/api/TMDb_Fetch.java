package api;

import com.google.gson.Gson;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class TMDb_Fetch
{
    private MovieResults results;

    public class MovieResults
    {
        public int page;
        public int total_results;
        public int total_pages;
        public Results[] results;

            public class Results
            {
                public double popularity;
                public int id;
                public boolean video;
                public int vote_count;
                public double vote_average;
                public String title;
                public String release_date;
                public String original_language;
                public String original_title;
                public int[] genre_ids;
                public String backdrop_path;
                public boolean adult;
                public String overview;
                public String poster_path;

            }
    }
    TMDb_Fetch(String title)
    {
        try
        {
            String safeTitle = URLEncoder.encode(title, "UTF-8");
            Map<String, String> params = Map.of("query", safeTitle, "api_key", APIKeys.TMDB_ID, "language", "en-US");
            initialize(params);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    TMDb_Fetch(String title, int year)
    {
        try
        {
            String safeTitle = URLEncoder.encode(title, "UTF-8");
            Map<String, String> params = Map.of("query", safeTitle, "api_key", APIKeys.TMDB_ID, "language", "en-US", "year", String.valueOf(year));
            initialize(params);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void initialize(Map<String, String> queryParameters)
    {
        try
        {
            ArrayList<String> queryPairs = new ArrayList<>();
            for(Entry<String, String> param : queryParameters.entrySet())
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
    public MovieResults getResults() { return results; }
}