package api;

import java.util.ArrayList;

public class Movie
{
    private String title;
    private String year;
    private String ceremony;
    private ArrayList<Award> awards;

    public Movie(String year, String title, String ceremony)
    {
        this.title = title;
        this.year = year;
        this.ceremony = ceremony;
        this.awards = new ArrayList<Award>();
    }

    /**
     * Adds an award to the Movie's award array
     *
     * @param a Award to add
     */
    public void addAward(Award a)
    {
        awards.add(a);
    }

    /**
     * Get the Movie's title
     *
     * @return title as String
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Get the Movie's year
     *
     * @return year as String
     */
    public String getYear()
    {
        return year;
    }

    /**
     * Get the Movie's ceremony number
     *
     * @return ceremony number as String
     */
    public String getCeremony()
    {
        return ceremony;
    }

    /**
     * Get the Movie's awards
     *
     * @return awards as ArrayList<Award>
     */
    public ArrayList<Award> getAwards()
    {
        return awards;
    }

    @Override
    public String toString()
    {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", ceremony='" + ceremony + '\'' +
                ", awards=" + awards +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o)
    {
        Movie a = (Movie) o;
        return this.title.equals(a.title) && this.year.equals(a.year);
    }
}
