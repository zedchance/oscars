package api;

import java.util.ArrayList;

public class Movie
{
    private String title;
    private String year;
    private String ceremony;
    private ArrayList<Award> awards;

    public Movie(String year, String title, String ceremony, ArrayList<Award> awards)
    {
        this.title = title;
        this.year = year;
        this.ceremony = ceremony;
        this.awards = awards;
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
