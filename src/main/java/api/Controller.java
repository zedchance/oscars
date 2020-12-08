package api;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;

/**
 * Oscars API Controller
 */
@RestController
public class Controller implements ErrorController
{
    /**
     * Global list of all movies contained in CSV file,
     * read into memory once so it can be reused.
     */
    private static final List<Movie> ALL_MOVIES = FetchFromCSV.all();

    /**
     * SecureRandom object for the /random endpoint
     */
    private SecureRandom r = new SecureRandom();

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
     * @throws InvalidRangeException when range is invalid
     */
    @GetMapping(value = {"/all", "/all/{year1}", "/all/{year1}/{year2}"})
    public List<Movie> all(@PathVariable(required = false) String year1,
                           @PathVariable(required = false) String year2)
    {
        ArrayList<Movie> yearOfAward = new ArrayList<>();
        ValueRange range = ValueRange.of(1927, 2020);

        if (year1 == null && year2 == null)
        {
            return ALL_MOVIES;
        }

        if (year1 != null && year2 == null)
        {
            long year1Long;
            try
            {
                year1Long = Long.parseLong(year1);
            }
            catch (Exception e)
            {
                throw new InvalidRangeException();
            }
            if (!range.isValidIntValue(year1Long))
            {
                throw new InvalidRangeException();
            }
            for (Movie movie : ALL_MOVIES)
            {
                if (movie.getYear().contains(year1))
                {
                    yearOfAward.add(movie);
                }
            }
            return yearOfAward;
        }

        if (year1 != null)
        {
            long year1Long;
            long year2Long;
            try
            {
                year1Long = Long.parseLong(year1);
                year2Long = Long.parseLong(year2);
            }
            catch (Exception e)
            {
                throw new InvalidRangeException();
            }
            if (!range.isValidIntValue(year1Long) || !range.isValidIntValue(year2Long))
            {
                throw new InvalidRangeException();
            }
            if (year1Long > year2Long)
            {
                throw new InvalidRangeException();
            }
            ValueRange movieRange = ValueRange.of(year1Long, year2Long);

            for (Movie movie : ALL_MOVIES)
            {
                if (movieRange.isValidIntValue(Long.parseLong(movie.getYear())))
                {
                    yearOfAward.add(movie);
                }
            }
            return yearOfAward;
        }
        return yearOfAward;
    }

    /**
     * An endpoint that returns a specific movie. If two movies share the same title,
     * the oldest is returned. To get a specific movie of a certain year, add the
     * year parameter, i.e. /movie/titanic?year=1997
     *
     * @param title the title of the movie
     * @return a Movie
     * @throws MovieNotFoundException when movie isn't found
     */
    @GetMapping("/movie/{title}")
    public Movie movie(@PathVariable("title") String title,
                       @RequestParam(value = "year", defaultValue = "none") String year)
    {
        ArrayList<Movie> matchList = new ArrayList<>();
        Movie m = null;
        String startsWithTitle = "\\b(?i)(" + title + ")\\b"; // regex for matching search at start of title
        String containsTitle = ".*(?i)" + title + ".*"; // regex for matching search anywhere in title

        // Adds all exact matches to matchList
        for (Movie movie : ALL_MOVIES)
        {
            if (movie.getTitle().matches(startsWithTitle))
            {
                matchList.add(movie);
            }
        }

        // Adds all movies that contain the title searched to the end of matchList
        for (Movie movie : ALL_MOVIES)
        {
            if (movie.getTitle().matches(containsTitle) && !matchList.contains(movie))
            {
                matchList.add(movie);
            }
        }

        // When year is specified, searches matchList for title with matching year, returning first match
        if (!"none".equals(year))
        {
            for (Movie movie : matchList)
            {
                if (movie.getYear().equalsIgnoreCase(year))
                {
                    m = movie;
                    break;
                }
            }
        }
        else // returns first entry in matchList when year is not specified
        {
            if (!matchList.isEmpty())
            {
                m = matchList.get(0);
            }
        }

        if (m == null)
        {
            throw new MovieNotFoundException();
        }

        m.updateFields();
        return m;
    }

    /**
     * An endpoint that returns a random Oscar-nominated movie.
     *
     * @return a random Movie
     */
    @GetMapping("/random")
    public Movie random()
    {
        Movie m = ALL_MOVIES.get(r.nextInt(ALL_MOVIES.size()));
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
     * @return a List<Movie> of all movies containing award category
     * @throws CategoryNotFoundException when category isn't found
     */
    @GetMapping("/category/{category}")
    public List<Movie> category(@PathVariable("category") String category,
                                @RequestParam(value = "winner", defaultValue = "none") String winner)
    {
        ArrayList<Movie> matches = new ArrayList<>();
        for (Movie movie : ALL_MOVIES)
        {
            for (Award award : movie.getAwards())
            {
                if (award.getCategory().toUpperCase().contains(category.toUpperCase()))
                {
                    // Adds matching winners if requested
                    if ("true".equalsIgnoreCase(winner) && award.isWinner())
                    {
                        matches.add(movie);
                        break;
                    }
                    // Adds matching non-winners if requested
                    else if ("false".equalsIgnoreCase(winner) && !award.isWinner())
                    {
                        matches.add(movie);
                        break;
                    }
                    // Adds all movies with matching category
                    else if ("none".equals(winner))
                    {
                        matches.add(movie);
                        break;
                    }
                }
            }
        }
        if (matches.isEmpty())
        {
            throw new CategoryNotFoundException();
        }
        return matches;
    }

    @GetMapping("/winner")
    public List<Movie> winner()
    {
        ArrayList<Movie> won = new ArrayList<>();

        for (Movie movie : ALL_MOVIES)
        {
            for (Award award : movie.getAwards())
            {
                if (award.isWinner())
                {
                    won.add(movie);
                    break;
                }
            }
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
