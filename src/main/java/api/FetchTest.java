package api;

/**
 * Test class for FetchFromOMDb.java
 */
public class FetchTest
{
    public static void main(String[] args)
    {
        // Test for OMDb API call to fetch various fields for a specific movie
        System.out.println("\nSearch 1 Test");
        String s = "Knives Out";
        FetchFromOMDb f = new FetchFromOMDb(s);
        if (f.isSuccessful())
        {
            System.out.println("Title Searched: " + s);
            System.out.println("Title Found: " + f.getTitle());
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

        // Test for OMDb API call with invalid title
        System.out.println("\nSearch 2 Test (Should return error)");
        String s2 = "adergkmm";
        FetchFromOMDb f2 = new FetchFromOMDb(s2);
        if (f2.isSuccessful())
        {
            System.out.println("Title Searched: " + s2);
            System.out.println("Title Found: " + f2.getTitle());
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
