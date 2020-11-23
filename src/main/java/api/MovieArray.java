package api;

import java.sql.*;
import java.util.ArrayList;

public class MovieArray
{
    private final ArrayList<String> s2 = new ArrayList<>();
    //connect method with the table database
    private Connection connect()
    {
        // SQLite connection string
        String url = "jdbc:sqlite:movies.sqlite";
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    //----------------end of the connect method-----------------------
    //put movie objects to arraylist
    public ArrayList<String> allMovies()
    {

        String sql = "SELECT title FROM movies"; // SQL commend for select the movies titles into arraylist

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            // loop through the result set
            while (rs.next())
            {
                s2.add(rs.getString("title"));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return s2;
    }
    //-----------end of  the arraylist printing objects------------------
    // testing method
    public static void main(String[] args) {

        MovieArray app = new MovieArray();
        ArrayList<String> arr= app.allMovies();
    //print all the movies title
        for (String s : arr)
        {
            System.out.println(s);
        }
    }
}