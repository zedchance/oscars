package api;

/**
 * Error class
 */
public class Error
{
    private String err;
    private int statusCode;

    /**
     * Create error with message and status code
     *
     * @param e       message as String
     * @param sc status code as int
     */
    public Error(String e, int sc)
    {
        this.err = e;
        this.statusCode = sc;
    }

    /**
     * Gets the Error's message
     *
     * @return error message as String
     */
    public String getError()
    {
        return err;
    }

    /**
     * Gets the Error's status code
     *
     * @return status code as int
     */
    public int getStatusCode()
    {
        return statusCode;
    }
}
