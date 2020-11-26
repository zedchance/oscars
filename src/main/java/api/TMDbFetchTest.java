package api;

public class TMDbFetchTest
{
    public static void main(String[] args)
    {
        // TMDb API call test to fetch Title, Year, Genre, Plot, IMDb ID
        System.out.println("\nSearch 1");
        TMDb_Fetch f = new TMDb_Fetch("Joker");
        TMDb_Fetch.MovieResults result = f.getResults();

        if(result.results.length > 0)
        {
            System.out.println("Top Result:");
            printMovie(result.results[0]);
        }

        System.out.println("\nSearch 2");
        TMDb_Fetch h = new TMDb_Fetch("Joker", 2000);
        result = h.getResults();

        if(result.results.length > 0)
        {
            System.out.println("Top Result:");
            printMovie(result.results[0]);
        }

    }
    public static void printMovie(TMDb_Fetch.MovieResults.Results movie)
    {
        System.out.println("=========================================================");
        System.out.println("Title = " + movie.title);
        System.out.println("Overview = " + movie.overview);
        System.out.println("Release Date = " + movie.release_date);
    }
}
