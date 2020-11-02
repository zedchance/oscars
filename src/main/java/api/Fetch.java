package api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fetch
{

    private String csvFile = "src/main/CSVFile/KaggleData_the_oscar_award.csv";
    private String data = "";
    private List<String> newData = new ArrayList<>();
    private List<String> line;


    public String parseData() {

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((data = br.readLine()) != null) {
                // use comma as separator
                String[] movie = data.split(",");
                for(String token:movie)
                {
                    System.out.print(token + " | ");
                }
                System.out.println(" ");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return csvFile;
    }


    public List<String> newLine(int element)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((data = br.readLine()) != null) {
                // use comma as separator
                String[] movie = data.split(",");
                //System.out.print(token + " | ");
                newData.add(data);
            }
            line = Collections.singletonList(newData.get(element));

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static void main(String[] args) throws Exception
    {
        Fetch movie = new Fetch();

        System.out.println((movie.newLine(7)));
    }
}
