package api;

import java.util.ArrayList;

public class Movie
{
    private String title;
    private String year;
    private String ceremony;
    private ArrayList<Award> awards;
    private String genre;
    private String plot;
    private String poster;
    private String imdbID;
    private String website; // IMDb link built with imbdID

    public Movie(String year, String title, String ceremony)
    {
        this.title = title;
        this.year = year;
        this.ceremony = ceremony;
        this.awards = new ArrayList<Award>();
        this.genre = "";
        this.plot = "";
        this.poster = "";
        this.imdbID = "";
        this.website = "";
    }

    /**
     * Method used for updating a movie object with
     * additional information from OMDb API
     */
    public void updateFields()
    {
        if (this.imdbID.equals(""))
        {
            FetchFromOMDb f = new FetchFromOMDb(title);
            if (f.isSuccessful())
            {
                this.genre = f.getGenre();
                this.plot = f.getPlot();
                this.poster = f.getPoster();
                this.imdbID = f.getID();
                this.website = f.buildLink();
            }
            else
            {
                System.out.println("Error: " + f.getError());
            }
        }
        // else no update required
    }

    @Override
    public String toString()
    {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", ceremony='" + ceremony + '\'' +
                ", awards=" + awards + '\'' +
                ", genre='" + genre + '\'' +
                ", plot='" + plot + '\'' +
                ", poster='" + poster + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", website='" + website +
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
