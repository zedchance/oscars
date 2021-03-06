package api;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Formatter
{
    private Formatter()
    {
        throw new IllegalStateException("Utility class");
    }

    static String formatTitle(String s)
    {
        s = s.replace(";", "");
        s = s.replace("\"", "");
        return s;
    }

    static String formatName(String s)
    {
        s = s.replace("\"", "");
        return s;
    }

    static String formatURL(String s)
    {
        s = URLEncoder.encode(s, StandardCharsets.UTF_8);
        return s;
    }
}
