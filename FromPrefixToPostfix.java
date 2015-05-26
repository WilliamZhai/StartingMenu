import java.io.*;
import java.util.*;
//By: William Zhai

public class FromPrefixToPostfix {
  
  public static void main(String[] args) {
        
    Scanner in = new Scanner(System.in);// creates scanner
    
    //initialization
    String[] prefix;
    String[] brackets;
        
    String withBrackets = "";
    String postfix;
    int numFunctions;
    
    String[] finalPostfix;
    
    boolean[] isBracket;
    
    //use a while loop, it will run infinitely unless stoped by specific user input of 0
    while (true){
       String list = in.nextLine(); //takes in the input as a string
       
       if (list.equals("0"))
         break; // if the input is 0, stop the loop
               
       numFunctions = 0; 
       
       prefix = list.split(" "); // splits the string into an array with integers and operators
       boolean[] isInteger = new boolean [prefix.length]; // creates a boolean list corresponding to the prefix list
          
       for (int i=0; i< isInteger.length; i++){
         isInteger[i] = isInt (prefix[i]); // decides whether each unit is an integer or not
         if(isInteger[i] ==false)
           numFunctions++;// countes the number of operators
       }
         
         withBrackets = addBrackets (prefix, isInteger);//add brackets onto the prefix list

         // two arrays containing the brackets
         brackets = withBrackets.split (" "); // splits the whole thing in an array
         isBracket = new boolean [brackets.length]; //creates a boolean list corresponding to the bracketed list
         
         for (int i=0; i< brackets.length; i++){
           isBracket[i] = getBracket (brackets[i]); //decide whether each value is a bracket
         }
   
         postfix = toPostfix (brackets, isBracket, numFunctions);//convert to postfix
         
         finalPostfix = postfix.split(" ");//split into an array
         
         for (int i=0; i<finalPostfix.length; i++){//prints out everything except for the brackets
           if (finalPostfix[i].equals (")") || finalPostfix[i].equals("("))
             continue;
           else
             System.out.print (finalPostfix[i] + " ");
         }
    }
  }
  
  // checks if a string is an integer, returns true or false
  public static boolean isInt(String s)
  {
    try{//check if the string is an int
      int i = Integer.parseInt(s); 
      return true; 
    }
    catch(NumberFormatException er){
      return false; 
    }
  }
  
  // decides weather a string is a bracket
  public static boolean getBracket(String s)
  {
    String a = "(";
    String b = ")";
                
    if (s.equals(a) == true || s.equals(b) == true)// checks if the string is a bracket
      return true;
    else
      return false;
  }
  
  //puts brackets for order of operations
  public static String addBrackets (String[] list, boolean[] isInteger)
  {            
    String withBrackets = "";//initialize the return variable
    
    if (list.length ==1){//if there is no more brackets to be added
      for (int k=0; k<list.length; k++){ // puts everything together into a single string 
        withBrackets = (withBrackets + list[k] + " ");
      }
      return withBrackets;
    }
    
    String[] newList = new String [list.length-2]; // creates new compressed list
    boolean[] newIsInteger = new boolean [isInteger.length-2]; // creates new compressed list
      
    //start from the right find the first non int
    for (int i=(isInteger.length)-1 ; i>= 0; i--){
       
      if (isInteger [i] == false){
         
         for (int j=0; j< i; j++){// copies over everything before it
           newList [j] = list[j];
           newIsInteger[j] = isInteger[j];
         }
         
         newList[i] = ("( " + list[i] + " " + list[i+1] + " " + list[i+2]) +" )"; //add on brackets
         newIsInteger[i] = true; //uses the full bracket as an integer
         
         for (int h=i+1; h<newList.length; h++){// copies over everything after it          
           newList[h] = list[h+2];
           newIsInteger[h] = isInteger[h+2];
         }  
         break;
      }       
     }
     return addBrackets (newList, newIsInteger);
  }
 
  // puts the bracketed list into postfix notation
  public static String toPostfix (String[] list, boolean[] isBracket, int numFunctions){
    String postfix = ""; //initializes the return variable
    int counter = 0;
    int value = list.length;//records the length of the list
    
    for (int i=0; i<list.length; i++){//start counting from left
      if (counter >= numFunctions)
        break;
      
      for (int j=value-1; j>=0; j--){//start counting from right
        if (isBracket[i] == true && isBracket[j] == true){ // checks for a bracket pair
          value=j;// change v
          String tempString = list[i+1]; //records the function
          boolean tempBoolean = isBracket [i+1];
          for (int k=i+1; k<j-1; k++){//from original operator location to right before the after operator location
            list[k] = list[k+1]; //shifts everything left
            isBracket[k] = isBracket[k+1]; //shifts everything left
          }
          list[j-1] = tempString; //records the operator back into the array
          isBracket[j-1] = tempBoolean; // records the operators property
          counter++;
          break;
        }        
      }            
    }    
    
    for (int i=0; i<list.length; i++){
      postfix = postfix + list[i] + " ";// puts the array into a string
    }           
    return postfix;
  }
  
}