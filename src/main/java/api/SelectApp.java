
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class SelectApp {

    /**
     * Connect to the test.db database
     * @return the Connection object
     */
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


    /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter \"a movie name\": ");

        String userName = myObj.nextLine();  // Read user input

        String sql = "SELECT DISTINCT year_film,year_ceremony, film FROM movies WHERE film LIKE '"+userName+"%'";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println("\tthe year of film: "+rs.getInt("year_film"));
                        ///rs.getInt("year_ceremony") + "\t" +
                System.out.println("\tthe film name: "+rs.getString("film"));
                System.out.println("\tthe year of ceremony : "+rs.getInt("year_ceremony"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SelectApp app = new SelectApp();
        app.selectAll();
    }

}
