import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
/**
 * Based on code from https://examples.javacodegeeks.com/core-java/writeread-csv-files-in-java-example/
 * @author ashraf
 * 
 */

public class CSVWrite{

  //Delimiter used in CSV file
  private static final String COMMA_DELIMITER = ",";
  private static final String NEW_LINE_SEPARATOR = "\n";

  //CSV file header
  private static final String FILE_HEADER = "pictureLabel, readingData";
  private static FileWriter fileWriter = null;

  public CSVWrite(String fileName)  {
    try{
      fileWriter = new FileWriter(fileName + ".csv");
      fileWriter.append(FILE_HEADER.toString());
      fileWriter.append(NEW_LINE_SEPARATOR);
      fileWriter.flush();      
    }
    catch (Exception e) {
      System.out.println("Error in CsvFileWriter !!!");
      e.printStackTrace();
    } 
  }
  public void closeCSV() {
    try {
      fileWriter.flush();
      fileWriter.close();
    } 
    catch (IOException e) {
      System.out.println("Error while flushing/closing fileWriter !!!");
      e.printStackTrace();
    }
  }
  
  public void write2CSV(String label, String data) {
    try {
      fileWriter.append(label);
      fileWriter.append(COMMA_DELIMITER);
      fileWriter.append(data);
      fileWriter.append(NEW_LINE_SEPARATOR);
      fileWriter.flush();      
    }
    catch (Exception e) {
      System.out.println("Error in CsvFileWriter !!!");
      e.printStackTrace();
    }
  }
  public static void main(String[] args) { 
    if(args.length == 0) {
      System.exit(0);
    } 
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new CSVWrite(args[0]);
      }
    });
  }


}
