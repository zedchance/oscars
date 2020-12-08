package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FetchFromCSV
{
    private static Logger log = Logger.getLogger("api.log");

    private FetchFromCSV()
    {
        throw new IllegalStateException("Utility class");
    }

    public static List<Movie> all()
    {
        String csvFile = "/KaggleData_the_oscar_award.csv";
        String data;
        String title;
        String year;
        String ceremony;
        String category;
        String name;
        boolean winner;
        ArrayList<Movie> movieData = new ArrayList<>();

        InputStream in = FetchFromCSV.class.getResourceAsStream(csvFile);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in)))
        {
            data = br.readLine(); // reads the first line of all the headers because we are not interested in it.
            while ((data = br.readLine()) != null)
            {
                // use comma as separator
                String[] movie = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                // checks to see if title is empty, if so, does not add to the movie array
                if (!movie[5].equals(""))
                {
                    // Movie object
                    title = Formatter.formatTitle(movie[5]);
                    year = movie[0];
                    ceremony = movie[2];
                    // Award object
                    category = movie[3];
                    name = Formatter.formatName(movie[4]);
                    winner = Boolean.parseBoolean(movie[6]);

                    Movie one = (new Movie(year, title, ceremony));

                    if (!movieData.contains(one))
                    {
                        movieData.add(one);
                    }

                    movieData.get(movieData.indexOf(one)).addAward(new Award(category, name, winner));
                }
            }
        }
        catch (IOException e)
        {
            log.info(e.getMessage());
        }
        return movieData;
    }
}
