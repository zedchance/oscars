package api;

public class Formatter
{
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

    // This can be deleted later, only here to test with
    public static void main(String[] args)
    {
        String title1 = "The Dove;";
        String title2 = "\"Wanted, a Master\"";
        String name1 = "\"George Marion, Jr.\"";
        String name2 = "Music by Arthur Johnston; Lyrics by Johnny Burke";

        title1 = formatTitle(title1);
        title2 = formatTitle(title2);
        name1 = formatName(name1);
        name1 = formatName(name1);

        System.out.println(title1);
        System.out.println(title2);
        System.out.println(name1);
        System.out.println(name2);
    }
}
