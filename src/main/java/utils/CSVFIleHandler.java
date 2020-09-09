package utils;

import com.opencsv.CSVWriter;
import models.Product;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVFIleHandler {

    public static void writeDataToFile(List<Product> data){
        File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\output.csv");
        CSVWriter writer;
        FileWriter outputfile;

        try{
            // create FileWriter object with file as parameter
            outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            writer = new CSVWriter(outputfile);

            List<String[]> outputData = new ArrayList<String[]>();

            //add headers
            outputData.add(new String[]{"Device Details","Price","Ratings"});

            for (Product prod:data) {
                outputData.add(new String[]{prod.getName(), prod.getPrice(), prod.getRating()});
            }

            writer.writeAll(outputData);

            System.out.println("Data Written to file");

            // closing writer connection
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
