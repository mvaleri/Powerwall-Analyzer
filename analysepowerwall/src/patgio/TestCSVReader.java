/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patgio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author PATGI
 */
public class TestCSVReader {

    public static void main(String[] args) {
        Reader in = null;
        try {
            in = new FileReader("src/patgio/bvm_data.csv");
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .build();
            CSVParser parse = csvFormat.parse(in);
            Iterable<CSVRecord> records = parse.getRecords();

            System.out.print("The columns are ");
            for (var name : parse.getHeaderNames()) {
                //use getKey method to get a key from entry
                System.out.print(name + " ");
            }
            
            // it brings in every cell as a string :(
            System.out.println();
            for (CSVRecord record : records) {
                String id = record.get("id");
                String device_name = record.get("DeviceName");
                System.out.format("%s %s\n", id, device_name);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestCSVReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestCSVReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(TestCSVReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
