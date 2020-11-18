package api;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
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
     * An endpoint that returns a specific movie. If two movies share the same title,
     * the oldest is returned. To get a specific movie of a certain year, add the
     * year paramter, i.e. /movie/titanic?year=1997
     *
     * @param title the title of the movie
     * @return a Movie
     * @throws MovieNotFoundException
     */
    @GetMapping("/movie/{title}")
    public Movie movie(@PathVariable("title") String title,
                       @RequestParam(value = "year", defaultValue = "none") String year)
            throws MovieNotFoundException
    {
        ArrayList<Movie> list = FetchFromCSV.certainMovie(title);
        Movie m = null;
        if (!"none".equals(year))
        {
            for (Movie movie: list)
            {
                if (movie.getYear().equalsIgnoreCase(year)) m = movie;
            }
        }
        else
        {
            m = list.get(0);
        }
        if (m == null)
        {
            throw new MovieNotFoundException();
        }
        m.updateFields();
        return m;
    }

    /**
     * An endpoint that returns all movies that won an award
     * in specified category. View all available categories
     * in the wiki. To specify if the movie won in that category, add the
     * winner parameter, i.e. /category/music?winner=true
     *
     * @param category category to search for
     * @param winner   optional boolean to specify if award was won or not
     * @return an ArrayList<Movie> of all movies containing award category
     * @throws CategoryNotFoundException
     */
    @GetMapping("/category/{category}")
    public ArrayList<Movie> category(@PathVariable("category") String category,
                                     @RequestParam(value = "winner", defaultValue = "none") String winner)
            throws CategoryNotFoundException
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
        if (matches.size() == 0)
        {
            throw new CategoryNotFoundException();
        }
        return matches;
    }

    @GetMapping("/winner")
    public ArrayList<Movie> winner(@RequestParam(value = "winner", defaultValue = "true") String winner)
    {
        ArrayList<Movie> all = FetchFromCSV.all();
        ArrayList<Movie> won = new ArrayList<>();

        for (Movie movie: all)
        {
            for (Award award : movie.getAwards())
            {
                if (winner.equalsIgnoreCase("true") && award.isWinner()) won.add(movie);
            }
        }
        if (won.size() == 0)
        {
            throw new CategoryNotFoundException();
        }
        return won;
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
     * Generic runtime exception handler. This handles both
     * MovieNotFoundException and CategoryNotFoundException.
     * Since both of these exceptions are thrown when item is not found,
     * status code that is returned is 404.
     *
     * @param e RuntimeException being caught
     * @return Error object with exception message and 404 code
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleException(RuntimeException e)
    {
        return new Error(e.getMessage(), 404);
    }

    @Override
    public String getErrorPath()
    {
        return "/error";
    }
}
