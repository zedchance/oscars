package api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AwardTest
{

    @Test
    void getCategory()
    {
        Award a = new Award("WRITING (Original Screenplay)",
                "Written by Rian Johnson", false);
        assertEquals("WRITING (Original Screenplay)", a.getCategory());
    }

    @Test
    void getName()
    {
        Award a = new Award("WRITING (Original Screenplay)",
                "Written by Rian Johnson", false);
        assertEquals("Written by Rian Johnson", a.getName());
    }

    @Test
    void isWinner()
    {
        Award a = new Award("WRITING (Original Screenplay)",
                "Written by Rian Johnson", false);
        assertEquals(false, a.isWinner());
    }

    @Test
    void toString1()
    {
        Award a = new Award("WRITING (Original Screenplay)",
                "Written by Rian Johnson", false);
        assertEquals("Award{" +
                "category='WRITING (Original Screenplay)', " +
                "name='Written by Rian Johnson', winner=false}", a.toString());
    }
}
