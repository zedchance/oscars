package api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest
{

    @Test
    void updateFields()
    {
    }

    @Test
    void addAward()
    {
    }

    @Test
    void getTitle()
    {
    }

    @Test
    void getYear()
    {
    }

    @Test
    void getCeremony()
    {
    }

    @Test
    void getAwards()
    {
    }

    @Test
    void getPlot()
    {
    }

    @Test
    void getPoster()
    {
    }

    @Test
    void getImdbID()
    {
    }

    @Test
    void getWebsite()
    {
    }

    @Test
    void getGenre()
    {
    }

    @Test
    void toString1()
    {
        Movie m = new Movie("2019", "Knives Out", "92");
        assertEquals("Movie{title='Knives Out', year='2019', ceremony='92', awards=[]', genre='', plot='', poster='', imdbID='', website=''}\n", m.toString());
    }

    @Test
    void equals1()
    {
    }
}