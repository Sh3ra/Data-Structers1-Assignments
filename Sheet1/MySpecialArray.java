/**
 * MySpecialArray
 */
import java.util.Arrays;
import java.util.Scanner; 
public class MySpecialArray {

    public static void reverse(int[] arr) 
    {
        int temp;
        for(int i=0;i<arr.length/2;i++)
        {
            temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }        
    }
    public static int[] sumEvenOdd(int[] arr)
    {
        int [] a=new int[2];
       a[0]=0;
       a[1]=0;     
        if(arr.length==0)
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
    public static double average(int[] arr) 
    {        
        if(arr.length!=0)
        {
            double avg=0;
            for(int i=0;i<arr.length;i++)
            {
                avg+=arr[i]/(arr.length*1.0);
            }
            return avg;
        }
        return 0;
    }
    public static void moveValue(int[] arr, int val) 
    {
        for(int i=0;i<arr.length;i++)
        {  
            boolean check=false;
            if(i!=0&&arr[i-1]==val)
        {
            for(int j=arr.length-1;j>i;j--)
            {
                if(arr[j]!=val)
                {
                    check=true;
                    break;
                }
            }
            if(check)i--;
        }

         if(arr[i]==val)
         {
             for (int j=i;j<arr.length-1;j++) 
             {
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
             }
         }
     }   
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter array size: ");
        n=sc.nextInt();
        int [] arr=new int[n];
        System.out.println("Enter array elements: ");
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the value to be moved at the end:");
        int val=sc.nextInt();
        sc.close();
        reverse(arr);
        System.out.println("Reversed array: "+Arrays.toString(arr));
        reverse(arr);
        int [] sumEvenOddarr=new int [2];
        sumEvenOddarr=sumEvenOdd(arr);
        System.out.println("Sum of Even: "+sumEvenOddarr[0]);
        System.out.println("Sum of Odd: "+sumEvenOddarr[1]);
        double avg;
        avg=average(arr);
        System.out.println("Average: "+avg);
        moveValue(arr,val);
        System.out.println("Array after moving value: "+Arrays.toString(arr));

    }
}
