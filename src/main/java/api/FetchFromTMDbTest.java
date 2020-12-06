package api;

public class FetchFromTMDbTest
{
    public static void main(String[] args)
    {
        // TMDb API call test to fetch Title, Year, Genre, Plot, IMDb ID
        System.out.println("\nSearch 1");
        FetchFromTMDb f = new FetchFromTMDb("Joker");
        FetchFromTMDb.MovieResults result = f.getResults();

        if (result.results.length > 0)
        {
            System.out.println("Top Result:");
            printMovie(result.results[0]);
        }

        System.out.println("\nSearch 2");
        FetchFromTMDb h = new FetchFromTMDb("Joker", 2000);
        result = h.getResults();

        if (result.results.length > 0)
        {
            System.out.println("Top Result:");
            printMovie(result.results[0]);
        }

    }

    public static void printMovie(FetchFromTMDb.MovieResults.Results movie)
    {
        System.out.println("=========================================================");
        System.out.println("Title = " + movie.title);
        System.out.println("Overview = " + movie.overview);
        System.out.println("Release Date = " + movie.release_date);
    }
}
