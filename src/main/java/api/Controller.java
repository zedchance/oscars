package api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Oscars API Controller
 */
@RestController
public class Controller
{
    /**
     * A test endpoint to make sure that the API is running.
     * This endpoint is at /hello
     *
     * @param name an optional parameter, use ?name=
     * @return a Hello greeting
     */
    @GetMapping("/hello")
    public Hello hello(@RequestParam(value = "name", defaultValue = "team3") String name)
    {
        return new Hello(String.format("Hello %s!", name));
    }

    /**
     * An endpoint that returns all 4934 movies
     *
     * @return an ArrayList<Movie> of all the movies
     */
    @GetMapping("/all")
    public ArrayList<Movie> all()
    {
        return FetchFromCSV.all();
    }

    /**
     * An endpoint that returns a specific movie
     *
     * @param title the title of the movie, use ?title=
     * @return a Movie
     */
    @GetMapping("/movie")
    public Movie movie(@RequestParam(value = "title", defaultValue = "null") String title)
    {
        if (title.equals("null"))
        {
            return new Movie("0", "No title given", "0");
        }
        Movie m = FetchFromCSV.certainMovie(title).get(0);
        m.updateFields();
        return m;
    }
}
