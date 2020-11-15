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
    public void selectAll(){
        //input to get specific data from the table
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter the movie name: ");

        String mo = "'"+myObj.nextLine()+"%'";
        String sql = "SELECT json FROM movies WHERE title LIKE "+mo;

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("json") +  "\t" );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //the main method to run the test
    public static void main(String[] args) {
        Data app = new Data();
        app.selectAll();
    }

}
