import java.io.*;
import java.util.*;

public class Fibonacci {

  public static void main(String[] args) {
        
    Scanner in = new Scanner(System.in);
    
    int num;
    num = in.nextInt();
    
    int fib;
    fib = fibonacci (num);
    
    System.out.println (fib);
      
    
    }
  
  public static int fibonacci (int num){
    int[]list = new int [num];
    
    list[0] =0;
    list[1]= 1;
    for (int i=2; i<num; i++){
      list[i] = list[i-1] + list [i-2];
    }
    
    return (list[num-1]);
          
  }
}