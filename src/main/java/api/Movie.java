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

    public void addAward(Award a)
    {
        awards.add(a);
    }
}
