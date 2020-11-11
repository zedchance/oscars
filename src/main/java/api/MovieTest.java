package api;

/**
 * Test class for Movie.java
 */
public class MovieTest
{
    public static void main(String[] args)
    {
        // Test for updateFields() to ensure movie is properly updated with OMDb data
        System.out.println("\nTest for updateFields()");
        Movie m = new Movie("2019", "Knives Out", "92");
        m.updateFields();
        System.out.println(m.toString());
    }
}
