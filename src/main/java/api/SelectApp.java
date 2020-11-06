
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectApp {


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



    public void selectAll(){

        String sql = "SELECT DISTINCT year_film,year_ceremony, film FROM movies WHERE film ";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("year_film")+"\t"+ rs.getString("film"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        SelectApp app = new SelectApp();
        app.selectAll();
    }

}
