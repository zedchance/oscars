package api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
