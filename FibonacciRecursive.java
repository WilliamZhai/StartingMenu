import java.io.*;
import java.util.*;

public class FibonacciRecursive {

  public static void main(String[] args) {
        
    Scanner in = new Scanner(System.in);
    
    int num;
    num = in.nextInt();
    
    int fib;
    fib = fibonacci (num);
    
    System.out.println (fib);
      
    
    }
  
  public static int fibonacci (int num){
    int fib;
    if (num==1)
      return 0;
    else if (num ==2)
      return 1;  
    else
      return fibonacci(num-1) + fibonacci (num-2);
  }
}