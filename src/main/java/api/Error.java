package api;

/**
 * Error class
 */
public class Error
{
    private String error;
    private int status_code;

    /**
     * Create error with message and status code
     *
     * @param error       message as String
     * @param status_code status code as int
     */
    public Error(String error, int status_code)
    {
        this.error = error;
        this.status_code = status_code;
    }

    /**
     * Gets the Error's message
     *
     * @return error message as String
     */
    public String getError()
    {
        return error;
    }

    /**
     * Gets the Error's status code
     *
     * @return status code as int
     */
    public int getStatus_code()
    {
        return status_code;
    }
}
