import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.*;

public class loadOldGame{
  private String currentLine;
  BufferedReader br;

  public loadOldGame(String name) throws IOException {
    try {
      br = new BufferedReader(new FileReader(name + ".csv"));
      while ((currentLine = br.readLine()) != null) { 
        String[] str = currentLine.split(",");
        System.out.println("File Name: " + str[0] + ", Data: " + str[1]); 
      }
      System.exit(0);
    }
    catch(Exception e) {
      new Slideshow(name).setVisible(true);
    }
  }
}
