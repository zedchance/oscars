package api;

public class FetchFromTMDbTest
{
    public static void main(String[] args)
    {
        // TMDb API call test to fetch Id, Title, Release Date, Original Language,
        // Original Title, Backdrop Path, Overview, and Poster Path
        FetchFromTMDb h = new FetchFromTMDb("Joker", 2000);
        FetchFromTMDb.MovieResults result = h.getResults();

        if (result.results.length > 0)
        {
            printMovie(result.results[0]);
        }
    }

    public static void printMovie(FetchFromTMDb.MovieResults.Results r)
    {
        System.out.println("Id = " + r.id +
                "\nTitle = " + r.title +
                "\nRelease Date = " + r.release_date +
                "\nOriginal Language = " + r.original_language +
                "\nOriginal Title = " + r.original_title +
                "\nBackdrop Path = " + r.backdrop_path +
                "\nOverview = " + r.overview +
                "\nPoster Path = " + r.poster_path);
    }
}
