import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class mainGame {
  static class WindowDisposer extends WindowAdapter {
    public void windowClosing(WindowEvent e) { 
      System.out.println("Game Closed!"); 
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    WindowDisposer wd = new WindowDisposer();
    JFrame f = new JFrame();
    f.setLayout(null);

    JButton loadUser = new JButton("Load Game");
    JButton newUser  = new JButton("New User");
    loadUser.setBounds(20 , 20 , 200 , 30);
    newUser.setBounds(240, 20 , 200 , 30);


    loadUser.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog("Profile to Load: ");
        try{
          new loadOldGame(name);
        }
        catch (IOException except) {}
        loadUser.setVisible(false);
        newUser.setVisible(false);
      }
    });

    newUser.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        loadUser.setVisible(false);
        newUser.setVisible(false);
        String name = JOptionPane.showInputDialog("Name: ");
        new Slideshow(name).setVisible(true);    
        f.setVisible(false);
      }
    });

    f.add(loadUser);
    f.add(newUser);
    f.setTitle("No-Brainer Game");
    f.setSize(470,100);
    f.setResizable(false);
    f.setLocation(100, 100);
    f.addWindowListener(wd);
    f.setVisible(true);
  }
}
