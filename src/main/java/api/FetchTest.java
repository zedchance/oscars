package api;

/**
 * Test class for OMDb_Fetch
 */
public class FetchTest
{
    public static void main(String[] args)
    {
        // OMDb API call test to fetch Title, Year, Genre, Plot, IMDb ID
        String s = "Knives Out";
        OMDb_Fetch f = new OMDb_Fetch(s);
        System.out.println("Title: " + s);
        System.out.println("Year: " + f.getYear());
        System.out.println("Genre: " + f.getGenre());
        System.out.println("Plot: " + f.getPlot());
        System.out.println("Poster Link: " + f.getPoster());
        System.out.println("IMDb ID: " + f.getID());
        System.out.println("IMDb Link: " + f.buildLink());
    }
}