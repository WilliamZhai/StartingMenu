//William Zhai
//Mr. Brooks
//ICS 4U
//This program will take two user input of integer value, and return the sum or difference 
//depending on the user's request.

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JTextField; 
import javax.swing.JLabel; 
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Dimension;

import java.awt.image.BufferedImage;
  
public class SimpleAddition extends JFrame // implements ActionListener 
{
       
  public SimpleAddition(){
  }
     
  private static void createAndShowGUI() {
    JFrame frame = new JFrame("ButtonDemo"); // creates a frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel jp = new JPanel(null);
    jp.setPreferredSize(new Dimension(800,400));// changed it to preferredSize.
    frame.getContentPane().add( jp );// adding to content pane will work here. Please read the comment bellow.
 
    JButton b1 = new JButton("Button1", null);
    b1.setActionCommand("disable");
    b1.setText("Add");
    b1.setBounds (600,100,100,80);
    
    JButton b2 = new JButton("Button2", null);
    b2.setActionCommand("disable");
    b2.setText("Subtract");
    b2.setBounds (600,200,100,80);

    //hard coding of labels and text fields
    JLabel label1 = new JLabel();
    label1.setText ("Enter a number1");
    label1.setBounds  (100, 100, 200,30);
    
    JLabel label2 = new JLabel();
    label2.setText ("Enter a number2");
    label2.setBounds  (300, 100, 200,30);
    
    JTextField field1 = new JTextField();   
    field1.setText("");
    field1.setBounds  (100, 200, 150,30);

    JTextField field2 = new JTextField();    
    field2.setText("");
    field2.setBounds (300, 200, 150,30);
    
    JLabel answer = new JLabel();
    answer.setText ("answer");
    answer.setBounds  (600, 300, 200,30);
       
    //add object onto the panel
    jp.add (b1);
    jp.add (b2);
    jp.add (label1);
    jp.add (label2);    
    jp.add (field2);
    jp.add (field1);
    jp.add (answer);
    
    //Display the window.
    frame.pack();    
    jp.setVisible (true);
    frame.setVisible(true);
    
    b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
              int num1 = 0;
              int num2 = 0;
              
              String s1 = field1.getText();
              num1 = Integer.parseInt (s1); // change from string to int
              
              String s2 = field2.getText();
              num2 = Integer.parseInt (s2); // change from string to int
                          
              int sum = num1 + num2;

              answer.setText("Answer: " + num1 + " + " + num2 + " = " + sum);
                
              field1.setText("");//reset the input fields
              field2.setText("");
              
              sum = 0;// reset sum
            }
        });
    
     b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
              int num1 = 0;
              int num2 = 0;
              
              String s1 = field1.getText();
              num1 = Integer.parseInt (s1); // change from string to int
              
              String s2 = field2.getText();
              num2 = Integer.parseInt (s2); // change from string to int
                          
              int difference = num1 - num2;

              answer.setText("Answer: " + num1 + " - " + num2 + " = " + difference);
                
              field1.setText("");//reset the input fields
              field2.setText("");
              
              difference = 0;// reset difference
            }
        });
  }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });        
  }
}    

    