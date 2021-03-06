/**
 * MySpecialArray
 */
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
    public static void transpose(int[][] arr)
    {
        if(arr.length==0)return;
        if(arr.length==arr[0].length){
        int temp;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length/2;j++)
            {
                temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }

     }
     else {
        int [][] arr1=new int[arr[0].length][arr.length];
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                arr1[j][i]=arr[i][j];
            }
        }
    }
     
    }
    
}
