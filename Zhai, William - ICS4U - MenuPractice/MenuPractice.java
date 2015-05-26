//William Zhai
//Mr. Brooks
//ICS 4U
//This program has a menu bar and changes the display image when an option is selected

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


public class MenuPractice extends JFrame{
  
  public MenuPractice(){
    setTitle("Menu Example");
    setSize(500, 500);
    
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
        
    //add the options onto the menu bar
    foodMenu.add(selectApple);
    foodMenu.add(selectBanana);
    foodMenu.add(selectPie);
    foodMenu.add(selectPi);
    
    
    // Add a listener for apple
    selectApple.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg) {
        try
        {
        BufferedImage apple = ImageIO.read(new File("apple.gif"));//import image
        JLabel appleLabel = new JLabel(new ImageIcon(apple));//set image as a label
        add(appleLabel);
        pack();
        setVisible(true);
        }
        catch(IOException ex){}
      }
    });
    
    // Add a listener for banana
    selectBanana.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg) {
        try
        {
        BufferedImage banana = ImageIO.read(new File("banana.gif"));//import image
        JLabel bananaLabel = new JLabel(new ImageIcon(banana));//set image as a label
        add(bananaLabel);
        pack();
        setVisible(true);
        }
        catch(IOException ex){}
      }
    });
    
    // Add a listener for pie
    selectPie.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg) {
        try
        {
        BufferedImage pie = ImageIO.read(new File("pie.gif"));//import image
        JLabel pieLabel = new JLabel(new ImageIcon(pie));//set image as a label
        add(pieLabel);
        pack();
        setVisible(true);
        }
        catch(IOException ex){}
      }
    });
    
    // Add a listener for pi
    selectPi.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg) {
        try
        {
        BufferedImage pi = ImageIO.read(new File("pi.gif")); //import image
        JLabel piLabel = new JLabel(new ImageIcon(pi));//set image as a label
        add(piLabel);
        pack();
        setVisible(true);
        }
        catch(IOException ex){}
      }
    });           
  }  
  
  public static void main(String[] args) {
    MenuPractice menu = new MenuPractice();
    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menu.setVisible(true);        
  }
}
    