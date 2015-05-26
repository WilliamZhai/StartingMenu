import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class FrameDemo {
  public static void main(String[] args) {
    
    
    //Create and set up the window.
    JFrame frame = new JFrame("FrameDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel emptyLabel = new JLabel("lable");
    emptyLabel.setPreferredSize(new Dimension(500, 500));
    frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
    
    //Display the window.
    frame.pack();
    frame.setVisible(true);
            
  }
        
  private static void createAndShowGUI() {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }  
    });  
  }                                        
                                           
}