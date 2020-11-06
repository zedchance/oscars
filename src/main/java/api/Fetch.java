package api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Fetch
{

    public static ArrayList<Movie> all() {
        String csvFile = "src/main/CSVFile/KaggleData_the_oscar_award.csv";
        String data = "";
        String title;
        String year;
        String ceremony;
        ArrayList<Movie> array = new ArrayList<Movie>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); //reads the first line of all the headers because we are not interested in it.
            while ((data = br.readLine()) != null) {
                // use comma as separator
                String[] movie = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (!movie[5].equals("")) // checks to see if title is empty, if so does not add to the movie array
                {
                    title = movie[5];
                    year = movie[0];
                    ceremony = movie[2];
                    array.add(new Movie(year, title, ceremony));
                }

            }
            System.out.println(array);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return array;
    }


    public static void main(String[] args) throws Exception
    {
        all();
    }
}
