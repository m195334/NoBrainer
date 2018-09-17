import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Dimension;
import java.awt.Toolkit;
public class Slideshow extends JFrame{
  Timer timer;
  int secDisplay = 1; 
  Integer count = 1;
  String[] files = new String[]{"Images/bike1.jpg", "Images/bike2.jpg",
    "Images/bike3.jpg", "Images/blue1.jpg", "Images/blue2.jpg",
    "Images/blue3.jpg", "Images/red1.jpg", "Images/red2.jpg", "Images/red3.jpg"};
  JPanel image;
  BufferedImage img;
  JLabel temp;
  Image scaled;
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int screenHeight = (int)screenSize.getHeight();
  int screenWidth = (int)screenSize.getWidth();

  public Slideshow(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setExtendedState(Frame.MAXIMIZED_BOTH);
    setUndecorated(true);
    setLayout(new FlowLayout());
    img = null;
    image = new JPanel();
    image.setPreferredSize(new Dimension(screenWidth, screenHeight));
    try{
      img = ImageIO.read(Slideshow.class.getResource(files[0]));
      scaled = img.getScaledInstance(screenWidth, screenHeight,Image.SCALE_SMOOTH);
      temp = new JLabel(new ImageIcon(scaled));
      image.add(temp);
      add(image, BorderLayout.CENTER);
      pack();
    } catch (IOException e) { 
    } catch (NullPointerException e) {}
    timer = new Timer();
    for(int x = secDisplay; x <= (files.length * secDisplay); x =  x + secDisplay) {
      timer.schedule(new myTask(), x * 1000);
      System.out.println(x);
    }
  }

  class myTask extends TimerTask {
    @Override
    public void run() {
      if(count > (files.length-1)) {
        timer.cancel();
        System.exit(0);
      }
      try{
        remove(image);
        image.remove(temp);
        img = null;
        img = ImageIO.read(Slideshow.class.getResource(files[count]));
        scaled = img.getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        temp = new JLabel(new ImageIcon(scaled));
        image.add(temp);
        add(image, BorderLayout.CENTER);
        pack();
        count++;
      } catch (IOException e) { 
      } catch (NullPointerException e) {}
    }
  }

  public static void main(String[] args) {  
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Slideshow().setVisible(true);
      }
    });
  }
}
//https://stackoverflow.com/questions/20098124/displaying-an-image-in-a-jframe
