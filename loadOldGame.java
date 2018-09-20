import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class loadOldGame{
  private String currentLine;
  BufferedReader br;
  public loadOldGame(String name) throws IOException {
    br = new BufferedReader(new FileReader(name + ".csv"));
    while ((currentLine = br.readLine()) != null) { 
      String[] str = currentLine.split(",");
      System.out.println("File Name: " + str[0] + ", Data: " + str[1]); 
    }
    System.exit(0);
  }
}
