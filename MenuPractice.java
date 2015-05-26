import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import javax.imageio.*;


public class MenuPractice extends JFrame{
  
  public MenuPractice(){
    setTitle("Menu Example");
    setSize(200, 200);
    
    // Creates a menubar for a JFrame
    JMenuBar menuBar = new JMenuBar();
        
    // Add the menubar to the frame
    setJMenuBar(menuBar);

    JMenu foodMenu = new JMenu("File"); //create a drop down menu
    menuBar.add(foodMenu); //add the food menu onto the menu bar
    
    //create simple menu items, they can be added onto different frop down menus 
    JMenuItem selectApple = new JMenuItem("Apple");
    JMenuItem selectBanana = new JMenuItem("Banana");
    JMenuItem selectPie = new JMenuItem("Pie");
    JMenuItem selectPi = new JMenuItem("Pi");

        
    foodMenu.add(selectApple);
    foodMenu.add(selectBanana);
    foodMenu.add(selectPie);
    foodMenu.add(selectPi);
    
    // Add a listener to the New menu item. actionPerformed() method will
    // invoked, if user triggred this menu item
    selectApple.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        System.out.println("You have clicked on the new action");
      }
    });
    
        
  }
  
  private static void createAndShowGUI() {
    JFrame frame = new JFrame("ButtonDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.pack();    
    //jp.setVisible (true);
    frame.setVisible(true);
    
    //ImageIcon gif;          
    //gif = new ImageIcon( "test.gif" );    
  }
  
  public static void main(String[] args) {
    MenuPractice menu = new MenuPractice();
    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menu.setVisible(true);        
  }
}
    