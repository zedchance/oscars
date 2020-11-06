package api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Movies
{
    String[] movie;
    String database;
    String year;
    String category;
    ArrayList<String> array = new ArrayList<>();

    public void fetch() {
        String csvFile = "src/main/CSVFile/KaggleData_the_oscar_award.csv";
        String data = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

                while ((data = br.readLine()) != null)
                {
                    // use comma as separator
                    movie = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                    //System.out.println(movie[0] + " | " + movie[3] + " | " + movie[5] );
                    database = movie[5];
                    year = movie[0];
                    category = movie[3];


                    array.add(year + " | " + database + " | " + category);


                }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }


    public String getYear()
    {
        return year;
    }

    public String getCategory()
    {
        return category;
    }

    public String getTitle()
    {
        return database;
    }

    public ArrayList<String> get()
    {
        return array;
    }


    public static void main(String[] args) throws Exception
    {
        /*
        Scanner in = new Scanner(System.in);
        System.out.println("Enter in Keyword");

        String keyword = in.next();


         */
        Movies movie = new Movies();
        movie.fetch();

        System.out.println(movie.get());

        System.out.println((movie.getTitle()));
        System.out.println((movie.getYear()));
        System.out.println((movie.getCategory()));
    }
}