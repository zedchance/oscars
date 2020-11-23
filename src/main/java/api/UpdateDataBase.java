package api;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

//**********************  works with the OMDB fetch only   ***************
public class UpdateDataBase
{
    private final String str_input;
    private String str_json="";
    private String str_title="";
    private String str_year="";
    private final ArrayList<String> s1= new ArrayList<>();

    public UpdateDataBase(String str_input)
    {
        this.str_input=str_input;
    }
    //connect to the table
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

    //put movie objects to arraylist
    public void selectTitle(String sql)
    {
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            // loop through the result set
            while (rs.next())
            {
                s1.add(rs.getString("json"));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    //insert and update the JSON movies object
    public void insert(String sql,String a, String b)
    {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, a);
            pstmt.setString(2, b);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //verify the JSON string
    public void verify()
    {
        for (String s : s1) // to get the right JSON string for update
        {
            String[] ty = s.split("\"");
            String ty_y = ty[7];
            if (str_year.equals(ty_y))
            {
                str_json=s;
            }
        }
        if (str_json.equals("")) //insert to when it couldn't find the title from the database which means it is a new movie title from the OMBD
        {
            //insert if the movies are not in the database
            String sql1 = "INSERT INTO movies (title,json) VALUES (?,?)";
            insert(sql1, str_title, str_input);
        }
        else if (!str_input.equals(str_json) && str_input.length() >= str_json.length()) // not equals add the JSON to the table or the length of the OMDB is ">=" than the database
        {
            String[] y = str_json.split("\"");
            String y_json=y[7];
            if (!str_year.equals(y_json)) // if the year of movie is difference insert the OMDB JSON to the table when both of strings are equal, but the year is difference
            {
                //insert for the movie for it has difference year
                String sql2 = "INSERT INTO movies (title,json) VALUES (?,?)";
                insert(sql2,str_title,str_input);
            }
            else //update the JSON string from the OMDB if the title and year are the same but it has more objects to add like plot,genre.....
            {
                // update the database
                String sql3 = "UPDATE movies SET json = ? "+ "WHERE json = ?";
                insert(sql3,str_input,str_json);
            }
        }
    }
    // running the code for update the database
    public void run()
    {
        String[] c = str_input.split("\"");// split the JSON string from the input to get the movie title and year
        str_title=c[3];
        str_year= c[7];
        if(!str_title.equals("") && !str_title.equals("No title given") && !str_title.equals("Movie not found")) // insert to when the title from the OMDB is not empty or specific words
        {
            String sql = "SELECT json FROM movies WHERE title='" + str_title + "'"; //enter the tile to the sql commend
            selectTitle(sql);
            verify();

        }
    }
    // the testing method -------> "input only the JSON string object from the OMDB only" <----------
    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Json Object: ");
        String s1=myObj.nextLine();

        UpdateDataBase date = new UpdateDataBase(s1);
        date.run();
    }
}
