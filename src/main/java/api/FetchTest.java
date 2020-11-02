package api;

/**
 * Test class for OMDb_Fetch
 */
public class FetchTest
{
    public static void main(String[] args)
    {
        // OMDb API call test to fetch Title, Year, Genre, Plot, IMDb ID
        System.out.println("\nSearch 1");
        String s = "Knives Out";
        OMDb_Fetch f = new OMDb_Fetch(s);
        if (f.isSuccessful())
        {
            System.out.println("Title: " + s);
            System.out.println("Year: " + f.getYear());
            System.out.println("Genre: " + f.getGenre());
            System.out.println("Plot: " + f.getPlot());
            System.out.println("Poster Link: " + f.getPoster());
            System.out.println("IMDb ID: " + f.getID());
            System.out.println("IMDb Link: " + f.buildLink());
        }
        else
        {
            System.out.println("Error: " + f.getError());
        }

        System.out.println("\nSearch 2");
        String s2 = "adergkmm";
        OMDb_Fetch f2 = new OMDb_Fetch(s2);
        if (f2.isSuccessful())
        {
            System.out.println("Title: " + s2);
            System.out.println("Year: " + f2.getYear());
            System.out.println("Genre: " + f2.getGenre());
            System.out.println("Plot: " + f2.getPlot());
            System.out.println("Poster Link: " + f2.getPoster());
            System.out.println("IMDb ID: " + f2.getID());
            System.out.println("IMDb Link: " + f2.buildLink());
        }
        else
        {
            System.out.println("Error: " + f2.getError());
        }
    }
}