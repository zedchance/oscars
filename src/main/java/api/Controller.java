package api;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Oscars API Controller
 */
@RestController
public class Controller implements ErrorController
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
     * @param title the title of the movie
     * @return a Movie
     */
    @GetMapping("/movie/{title}")
    public Movie movie(@PathVariable("title") String title) throws MovieNotFoundException
    {
        Movie m = FetchFromCSV.certainMovie(title).get(0);
        m.updateFields();
        return m;
    }

    /**
     * An endpoint that returns all movies that won an award
     * in specified category. View all available categories
     * in the wiki.
     *
     * @param category category to search for
     * @param winner optional boolean to specify if award was won or not
     * @return an ArrayList<Movie> of all movies containing award category
     */
    @GetMapping("/category/{category}")
    public ArrayList<Movie> category(@PathVariable("category") String category,
                                     @RequestParam(value = "winner", defaultValue = "none") String winner)
    {
        ArrayList<Movie> all = FetchFromCSV.all();
        ArrayList<Movie> matches = new ArrayList<>();
        for (Movie movie : all)
        {
            for (Award award : movie.getAwards())
            {
                if (award.getCategory().toUpperCase().contains(category.toUpperCase()))
                {
                    if ("true".equalsIgnoreCase(winner) && award.isWinner()) matches.add(movie);
                    else if ("false".equalsIgnoreCase(winner) && !award.isWinner()) matches.add(movie);
                    else if ("none".equals(winner)) matches.add(movie);
                }
            }
        }
        return matches;
    }

    /**
     * Basic /error endpoint
     *
     * @return Error object with "Endpoint not found" message and 404 code
     */
    @GetMapping("/error")
    public Error error()
    {
        return new Error("Endpoint not found", 404);
    }

    /**
     * Handles the MovieNotFoundException thrown when /movie can't find the specific title
     *
     * @param e MovieNotFoundException
     * @return Error object with 404 code
     */
    @ExceptionHandler(MovieNotFoundException.class)
    public Error handleMovieNotFound(MovieNotFoundException e)
    {
        return new Error(e.getMessage(), 404);
    }

    @Override
    public String getErrorPath()
    {
        return "/error";
    }
}
