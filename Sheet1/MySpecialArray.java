/**
 * MySpecialArray
 */
import java.util.*;
import java.util.Scanner; 
public class MySpecialArray {

    public static void reverse(int[] arr) {
        int temp;
        for(int i=0;i<arr.length/2;i++)
        {
            temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }        
    }
    public static int[] sumEvenOdd(int[] arr)
    {int [] a=new int[2];
       a[0]=0;
       a[1]=0;     
        if(arr==null)
        return a;

        else 
        {
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]%2==0)a[0]+=arr[i];
                else a[1]+=arr[i];
            }
            return a;
        }

    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int [] arr=new int[n];
        
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        reverse(arr);
        for(int i=0;i<5;i++)
        {
            System.out.println(arr[i]);
        }
        int [] sumEvenOddarr=new int [2];
        sumEvenOddarr=sumEvenOdd(arr);
        System.out.println(sumEvenOddarr[0]);
        System.out.println(sumEvenOddarr[1]);

    }
}
