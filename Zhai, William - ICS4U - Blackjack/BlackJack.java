//This program still has many errors such as incorrect sums 
//and limited number of cards that can be dealt

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
//import javax.swing.ImageIcon;
//import javax.swing.JTextField; 
import javax.swing.JLabel; 
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Dimension;

import java.awt.image.BufferedImage;
  
public class BlackJack extends JFrame // implements ActionListener 
{
    
  private static void createAndShowGUI() {      
      //initialization
      int [] cardValue = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,//the values
      0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,}; // the the 0s stand for whether a card is picked
              
      int playerSum = 0;
      int dealerSum = 0;
      
      JFrame frame = new JFrame("Black Jack"); // creates a frame
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JPanel jp = new JPanel(null);
      jp.setPreferredSize(new Dimension(800,400));// changed it to preferredSize.
      frame.getContentPane().add( jp );// adding to content pane will work here. Please read the comment bellow.
      
      // creates and positions buttons, does not add to panel yet
      JButton startButton = new JButton("startButton", null);
      startButton.setActionCommand("disable");
      startButton.setText("Start");
      startButton.setBounds (350,150,100,100);
      
      JButton hitButton = new JButton("hitButton", null);
      hitButton.setActionCommand("hitButton");
      hitButton.setText("Hit");
      hitButton.setBounds (850,100,100,50);
      
      JButton standButton = new JButton("standButton", null);
      standButton.setActionCommand("standButton");
      standButton.setText("Stand");
      standButton.setBounds (850,200,100,50);
      
      JLabel dealerLable = new JLabel();
      dealerLable.setText ("Dealer's Hand:");
      dealerLable.setBounds  (10, 0, 200,30);
    
      JLabel playerLable = new JLabel();
      playerLable.setText ("Your Hand:");
      playerLable.setBounds  (10, 200, 200,30);
           
      //generates the values of the first 4 cards
      int d1 = getNewCard (cardValue);
      cardValue[d1+54] = 1;// indicating this card is already chosen
      int d2 = getNewCard (cardValue);
      cardValue[d2+54] = 1;// indicating this card is already chosen
      int d3 = getNewCard (cardValue);
      cardValue[d3+54] = 1;// indicating this card is already chosen
      int d4 = getNewCard (cardValue);
      cardValue[d4+54] = 1;// indicating this card is already chosen
      
      //creates initial 4 cards, 2 for player, 2 for dealer
      JLabel dealer1 = new JLabel();
      dealer1.setText ("" + cardValue[d1]);
      dealer1.setBounds  (10, 50, 50, 50);
      
      JLabel dealer2 = new JLabel();
      dealer2.setText ("" + cardValue[d2]);
      dealer2.setBounds  (60, 50, 50, 50);
      
      JLabel player1 = new JLabel();
      player1.setText ("" + cardValue[d3]);
      player1.setBounds  (10, 250, 50, 50);
      
      JLabel player2 = new JLabel();
      player2.setText ("" + cardValue[d4]);
      player2.setBounds  (60, 250, 50, 50);
      
      // blocks one of the dealer's cards erase this to see the hiden dealer card
      // also remember to remove the addition of the label in the action listener of the start button
      JLabel block = new JLabel();
      block.setText ("Hidden");
      block.setBounds  (10, 50, 50, 50);
            
      //add object onto the panel
      jp.add (startButton);
      
      //add up the sums of the cards of the player and the dealer
      dealerSum = cardValue[d1] + cardValue[d2];
      playerSum = cardValue[d3] + cardValue[d4];
      
      //creates the labels to display the sums
      JLabel sumDealer = new JLabel();
      sumDealer.setText ("" + dealerSum);
      sumDealer.setBounds  (300, 0, 50, 50);
      
      JLabel sumPlayer = new JLabel();
      sumPlayer.setText ("" + playerSum);
      sumPlayer.setBounds  (300, 200, 50, 50);

      frame.pack();    
      jp.setVisible (true);
      frame.setVisible(true);
      
          
      //functions that will occur if pressed start button
      startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

              //add objects onto panel
              jp.add (hitButton);
              jp.add (standButton);
              jp.add (dealerLable);
              jp.add (playerLable);      
              //jp.add (dealer1); //uncomment this to check the hidden card             
              jp.add (dealer2);
              jp.add (player1);   
              jp.add (player2); 
              jp.add (block);   
                            
              jp.remove (startButton);
              
              jp.setPreferredSize(new Dimension(1000,400));// changed it to preferredSize.
              
              frame.pack();    
              jp.setVisible (true);
              frame.setVisible(true);
            }
        });
      
      //functions that will occur if pressed hit button
      hitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                           
              JLabel card = new JLabel();
              int newCard = getNewCard (cardValue);
              
              cardValue[newCard+54] = 1;// indicating this card is already chosen
              
              card.setText ("" + cardValue[newCard]);// show the new card
              card.setBounds  (110, 250, 50, 50);
                                         
              jp.add (card);
              jp.setPreferredSize(new Dimension(1001,400));// changed it to preferredSize.
              
              frame.pack();    
              jp.setVisible (true);
              frame.setVisible(true);
            }
        });    
      
      //functions that will occur if pressed stand
      standButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
              //add objects onto panel
              jp.add (sumDealer); 
              jp.add (sumPlayer); 
              jp.add (dealer1); 
              jp.remove (block);
              
              jp.setPreferredSize(new Dimension(1002,400));// changed it to preferredSize.
              
              frame.pack();    
              jp.setVisible (true);
              frame.setVisible(true);
            }
        });    
    }
        
    // generates a new card, may use recursion
    public static int getNewCard (int[] cardValue)
    {
      double randomNumber = Math.random() * 51;    // generate a decimal from 0-51
      int i = (int) randomNumber; // converts to integer
    
      if (cardValue[i+54] != 0)
      { // if the card is already used, call the method again
        return getNewCard(cardValue); 
      }
      
      else {
        return i;
      }
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