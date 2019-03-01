/**
 * MySpecialArray
 */
import java.util.*;
public class MySpecialArray {

    public static void reverse(Integer[] arr) {
        Collections.reverse(Arrays.asList(arr));        
    }

    public static void main(String[] args) {
        Integer [] arr={1,2,3,4,5};
        reverse(arr);
        for(int i=0;i<5;i++)
        {
            System.out.println(arr[i]);
        }

    }
}
