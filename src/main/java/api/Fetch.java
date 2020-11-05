package api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Fetch
{
    String[] movie;

    public void fetch() {
        String csvFile = "src/main/CSVFile/KaggleData_the_oscar_award.csv";
        String data = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((data = br.readLine()) != null) {
                // use comma as separator
                movie = data.split(",");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    

    public String getYear()
    {
        return movie[0];
    }

    public String getCategory()
    {
        return movie[3];
    }

    public String getTitle()
    {
        return movie[4];
    }



    public static void main(String[] args) throws Exception
    {
        Fetch movie = new Fetch();
        movie.fetch();

        System.out.println((movie.getYear()));
        System.out.println((movie.getCategory()));
        System.out.println((movie.getTitle()));
    }
}


/*
        Scanner scan = new Scanner(System.in); //Creates a new scanner

        System.out.println("Year: ");

        String input = scan.nextLine();

        System.out.println("Nomination: ");

        String output = scan.nextLine();

        for(String i:movie.newLine())
        {
            //System.out.println(exp.get(6));
            if (i.contains(input) && i.contains(output))
            {
                System.out.println(i);
            }
        }
 */