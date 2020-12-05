package api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidRangeException extends RuntimeException
{
    public InvalidRangeException() { super("Invalid Range"); }
}
