import org.junit.Test;
import static org.junit.Assert.*;

public class Testing {
  
  
    @Test
     public static void main(String[] args) {

        int result = add(3, 5);

        assertEquals(8, result);

    }
  
    @Test
    public static int add (int a, int b){
      return (a+b);
    }
  
}