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
    private String error;

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
        this.error = "";
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
                this.error = f.getError();
                System.out.println(this.error);
            }
        }
        // else no update required
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

    /**
     * Get the Movie's genre
     *
     * @return genre as String
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     * Get the Movie's plot
     *
     * @return plot as String
     */
    public String getPlot()
    {
        return plot;
    }

    /**
     * Get the Movie's poster
     *
     * @return poster's jpg as String
     */
    public String getPoster()
    {
        return poster;
    }

    /**
     * Get the Movie's IMDb ID
     *
     * @return IMDb ID as String
     */
    public String getImdbID()
    {
        return imdbID;
    }

    /**
     * Get the Movie's link to IMDb website
     *
     * @return link to IMDb website as String
     */
    public String getWebsite()
    {
        return website;
    }

    /**
     * Get the error field in a Movie object
     *
     * @return error as String
     */
    public String getError()
    {
        return error;
    }

    @Override
    public String toString()
    {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", ceremony='" + ceremony + '\'' +
                ", awards=" + awards +
                ", genre='" + genre + '\'' +
                ", plot='" + plot + '\'' +
                ", poster='" + poster + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", website='" + website + '\'' +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o)
    {
        Movie a = (Movie) o;
        return this.title.equals(a.title) && this.year.equals(a.year);
    }
}
