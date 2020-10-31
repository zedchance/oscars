package api;

/**
 * Test class for OMDb_Fetch
 */
public class FetchTest
{
    public static void main(String[] args)
    {
        // OMDb API call test to fetch Title, Year, Genre, Plot, IMDb ID
        OMDb_Fetch f = new OMDb_Fetch("Knives Out");
        System.out.println("Title: " + f.getInfo("Title", 0));
        System.out.println("Year: " + f.getInfo("Year", 0));
        System.out.println("Genre: " + f.getInfo("Genre", 0));
        System.out.println("Plot: " + f.getInfo("Plot", 0));
        System.out.println("IMDb ID: " + f.getInfo("imdbID", 0));
    }
}