import java.io.*;
import java.util.*;
//By: William Zhai

public class KeepOnTruckin {
   
  public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);// creates scanner
        
    //initializations
    int minimumDistance;
    int maximumDistance;
    int extraMotels;
    ArrayList<String> numOptions;
  
    String motel;
    String[] originalList;
         
    int[] motelList;
                      
    motel =  "0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000";
          
    originalList = motel.split(", "); // splits the original distances into an array
         
    //taking in input conditions
    minimumDistance = in.nextInt();
    maximumDistance = in.nextInt();
         
    extraMotels = in.nextInt(); // takes in the number of extra motels on the way
    motelList = new int [14 + extraMotels]; // creates the list with all the motels
           
    for (int i=0; i<14; i++){//record the given motel distances
      motelList[i] = Integer.parseInt(originalList[i]); //turns the string into int values for further evaluation
    }
                    
    // takes in the extra motel distances and put them into the array
    for (int i=14; i <motelList.length; i++){
      int temp = in.nextInt();
           
      for (int j=0; j<i ;j++){
        if (temp < motelList[j]){// checks where the new input fit into the array
          for (int k=i; k>j; k--){
            motelList[k] =motelList [k-1]; // shift all values greater than the input to the right
          }
          motelList[j] = temp;
          break;
        }
      }           
    }           
    
    numOptions = findRoute(0, motelList, minimumDistance, maximumDistance);// gets the number of possible routes
    
    System.out.print (numOptions.size());        
  }
  
  // using recursion, find all possible different routes available
  private static ArrayList<String> findRoute(int currentIndex, int [] motels, int min, int max){
    
    ArrayList<String> routes = new ArrayList<String>();// array lists can change in size
    //creates an array list of strings to record all the different possible routes
    
    if(currentIndex == motels.length-1){// if the current position is the end of the trip
      ArrayList<String> finalRoute = new ArrayList<String>();
      finalRoute.add(Integer.toString(currentIndex));
      return finalRoute;
    }
    
    for(int i=currentIndex +1; i< motels.length;i++)
    {
      if(motels[i] - motels[currentIndex] > max) 
        break;
      if(motels[i] - motels[currentIndex] < min) 
        continue;// checks if fit the conditions
      
      ArrayList<String> moreRoutes = findRoute(i, motels, min, max);// finds the next possible routes
      
      routes.addAll(moreRoutes); //collects all the routes into ArrayList routes
    }
    return routes;
  }  
}
        