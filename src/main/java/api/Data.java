package api;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//connect the SQL database file with java
public class Data
{
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:movies.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    //----------------end of the connect method-----------------------
    //select a specific field in the SQL table
    public String printValue(String str){

        String mo = "'"+str+"%'";
        String sql = "SELECT json FROM movies WHERE title Like "+mo;
        String s1="";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            // loop through the result set
            while (rs.next()) {
                s1=rs.getString("json");
            }
        } catch (SQLException e) {
            s1=e.getMessage();
        }
        return  s1;
    }
    //------------end of select a specific field in the SQL table------------------

    public static void main(String[] args) {
    //------testing the search values
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter the movie name: ");

        Data app = new Data();
        System.out.println(app.printValue(myObj.nextLine()));
    }

}
