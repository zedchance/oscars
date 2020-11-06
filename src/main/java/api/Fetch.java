package api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Fetch
{

    public static ArrayList<Movie> all(String movieName) {
        String csvFile = "src/main/CSVFile/KaggleData_the_oscar_award.csv";
        String data = "";
        String title;
        String year;
        String ceremony;
        String category;
        String name;
        boolean winner = true;
        ArrayList<Award> awards = new ArrayList<>();
        ArrayList<Movie> movieData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); //reads the first line of all the headers because we are not interested in it.
            while ((data = br.readLine()) != null) {
                // use comma as separator
                String[] movie = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                // checks to see if title is empty, if so, does not add to the movie array
                if (!movie[5].equals("") && movie[5].equalsIgnoreCase(movieName))
                {

                    title = movie[5];
                    year = movie[0];
                    ceremony = movie[2];

                    category = movie[3];
                    name = movie[4];

                    winner = Boolean.parseBoolean(movie[6]);
                    if(winner)
                    {
                        awards.add(new Award(category, name, true));
                    }
                    movieData.add(new Movie(year, title, ceremony, awards));
                }

            }
            System.out.println(movieData);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return movieData;
    }


    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in); //Creates a new scanner

        System.out.println("Movie Name: ");

        String input = scan.nextLine();

        all(input);
    }
}
