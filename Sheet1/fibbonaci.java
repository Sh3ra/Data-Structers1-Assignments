/**
 * fibbonaci
 */

import java.util.Scanner; 

public class fibbonaci {


    public static void main(String[] args) {
        int f1=0;
        int f2=1;
        int f3=f1+f2;
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        for(int i=1;i<n;i++)
        {            
            f1=f2;
            f2=f3;
            f3=f1+f2;
        }
        System.out.println(f1);
            
    }
}