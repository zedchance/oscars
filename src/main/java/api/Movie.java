package api;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

public class Movie
{
    private String title;
    private String year;
    private String ceremony;
    private ArrayList<Award> awards;
    private String genre;
    private String plot;
    private String poster;
    private String website; // IMDb link built with imbdID
    private String error;

    public Movie(String year, String title, String ceremony)
    {
        this.title = title;
        this.year = year;
        this.ceremony = ceremony;
        this.awards = new ArrayList<>();
        this.genre = "";
        this.plot = "";
        this.poster = "";
        this.website = "";
        this.error = "false";
    }

    /**
     * Method used for updating a movie object with
     * additional information from OMDb API
     */
    public void updateFields()
    {
        // Checks to see if the OMDb fields have already been filled.
        if (this.website.equals(""))
        {
            FetchFromOMDb f = new FetchFromOMDb(title, year);
            if (f.isSuccessful())
            {
                this.genre = f.getGenre();
                this.plot = f.getPlot();
                this.poster = f.getPoster();
                this.website = f.getWebsite();
            }
            else
            {
                // check the next year in case the csv file had it listed incorrectly
                String nextYear = String.valueOf(Integer.parseInt(year) + 1);
                f = new FetchFromOMDb(title, nextYear);
                if (f.isSuccessful())
                {
                    this.genre = f.getGenre();
                    this.plot = f.getPlot();
                    this.poster = f.getPoster();
                    this.website = f.getWebsite();
                    this.year = nextYear; // update year to match entry found on OMDb
                }
                else
                {
                    this.error = f.getError();
                }
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
    public List<Award> getAwards()
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
                ", website='" + website + '\'' +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null)
        {
            return false;
        }
        if (this.getClass() != o.getClass())
        {
            return false;
        }
        Movie a = (Movie) o;
        return this.title.equals(a.title) && this.year.equals(a.year);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(title, year, ceremony, awards, genre, plot, poster, website, error);
    }
}
