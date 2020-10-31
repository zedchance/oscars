package api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Fetch
{
    public static void parseData() {
        String csvFile = "src/main/CSVFile/datahubio_oscar_data_csv.csv";
        String data = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((data = br.readLine()) != null) {
                // use comma as separator
                String[] movie = data.split(",");
                for(String token : movie)
                {
                    System.out.print(token + " | ");
                }
                System.out.println(" ");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception
    {
        parseData();
    }
}
