package api;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for Movie.java
 */
class MovieTest
{
    @Test
    void updateFields1()
    {
        Movie m = new Movie("2019", "Knives Out", "92");
        m.updateFields();
        assertEquals("Movie{title='Knives Out', year='2019', ceremony='92', awards=[], " +
                "genre='Comedy, Crime, Drama, Mystery, Thriller', plot='A detective investigate" +
                "s the death of a patriarch of an eccentric, combative family.', poster='https:" +
                "//m.media-amazon.com/images/M/MV5BMGUwZjliMTAtNzAxZi00MWNiLWE2NzgtZGUxMGQxZjhh" +
                "NDRiXkEyXkFqcGdeQXVyNjU1NzU3MzE@._V1_SX300.jpg', website='" +
                "https://www.imdb.com/title/tt8946378/'}\n", m.toString());
    }

    @Test
    void updateFields2()
    {
        Movie m = new Movie("2019", "adergkmm", "92");
        m.updateFields();
        assertEquals("Movie not found!", m.getError());
    }

    @Test
    void updateFields3()
    {
        Movie m = new Movie("1929", "Street of Chance", "3");
        m.updateFields();
        assertEquals("Movie{title='Street of Chance', year='1930', ceremony='3', awards" +
                "=[], genre='Drama', plot='N/A', poster='https://m.media-amazon.com/images/M/MV" +
                "5BMzVhMDc2MDMtNTkxNC00YjYxLTlmODYtY2JkZWY4NWIwMjk2XkEyXkFqcGdeQXVyMjUxODE0MDY@" +
                "._V1_SX300.jpg', website='https://www.imdb.com/title/tt0021420/'}\n", m.toString());
    }

    @Test
    void addAward()
    {
        Movie m = new Movie("2019", "Knives Out", "92");
        m.addAward(new Award("WRITING (Original Screenplay)", "Written by Rian Jo" +
                "hnson", false));
        assertEquals("Movie{title='Knives Out', year='2019', ceremony='92', awards=[Awa" +
                "rd{category='WRITING (Original Screenplay)', name='Written by Rian Johnson', w" +
                "inner=false}], genre='', plot='', poster='', website=''}\n", m.toString());
    }

    @Test
    void getTitle()
    {
        Movie m = new Movie("2019", "Knives Out", "92");
        assertEquals("Knives Out", m.getTitle());
    }

    @Test
    void getYear()
    {
        Movie m = new Movie("2019", "Knives Out", "92");
        assertEquals("2019", m.getYear());
    }

    @Test
    void getCeremony()
    {
        Movie m = new Movie("2019", "Knives Out", "92");
        assertEquals("92", m.getCeremony());
    }

    @Test
    void getAwards()
    {
        Movie m = new Movie("2019", "Knives Out", "92");
        m.addAward(new Award("WRITING (Original Screenplay)", "Written by Rian Joh" +
                "nson", Boolean.parseBoolean("FALSE")));
        List<Award> a = m.getAwards();
        assertEquals("[Award{category='WRITING (Original Screenplay)', name='Written by " +
                "Rian Johnson', winner=false}]", a.toString());
    }

    @Test
    void getGenre()
    {
        Movie m = new Movie("2019", "Knives Out", "92");
        m.updateFields();
        assertEquals("Comedy, Crime, Drama, Mystery, Thriller", m.getGenre());
    }

    @Test
    void getPlot()
    {
        Movie m = new Movie("2019", "Knives Out", "92");
        m.updateFields();
        assertEquals("A detective investigates the death of a patriarch of an eccentric" +
                ", combative family.", m.getPlot());
    }

    @Test
    void getPoster()
    {
        Movie m = new Movie("2019", "Knives Out", "92");
        m.updateFields();
        assertEquals("https://m.media-amazon.com/images/M/MV5BMGUwZjliMTAtNzAxZi00MWNiL" +
                "WE2NzgtZGUxMGQxZjhhNDRiXkEyXkFqcGdeQXVyNjU1NzU3MzE@._V1_SX300.jpg", m.getPoster());
    }

    @Test
    void getWebsite()
    {
        Movie m = new Movie("2019", "Knives Out", "92");
        m.updateFields();
        assertEquals("https://www.imdb.com/title/tt8946378/", m.getWebsite());
    }

    @Test
    void getError()
    {
        Movie m = new Movie("2019", "adergkmm", "92");
        m.updateFields();
        assertEquals("Movie not found!", m.getError());
    }

    @Test
    void toString1()
    {
        Movie m = new Movie("2019", "Knives Out", "92");
        assertEquals("Movie{title='Knives Out', year='2019', ceremony='92', awards=[]," +
                " genre='', plot='', poster='', website=''}\n", m.toString());
    }

    @Test
    void equals1()
    {
        Movie a = new Movie("2019", "Knives Out", "92");
        Movie b = new Movie("2019", "Knives Out", "92");
        assertEquals(true, a.equals(b));
    }

    @Test
    void equals2()
    {
        Movie a = new Movie("2019", "Knives Out", "92");
        Movie b = new Movie("1776", "Knives Out", "92");
        assertEquals(false, a.equals(b));
    }

    @Test
    void equals3()
    {
        Movie a = new Movie("1776", "Knives Out", "92");
        Movie b = null;
        assertEquals(false, a.equals(b));
    }

    @Test
    void equals4()
    {
        Movie a = new Movie("2019", "Knives Out", "92");
        Award b = new Award("WRITING (Original Screenplay)", "Written by Rian Johnson", false);
        assertEquals(false, a.equals(b));
    }
}
