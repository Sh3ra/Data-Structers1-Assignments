/**
 * fibbonaci
 */

import java.math.BigInteger;

public class fibbonaci {


public static BigInteger fib(int n)
{
    BigInteger f1=new BigInteger("0");
      BigInteger f2=new BigInteger("1");
        BigInteger f3=new BigInteger("0");
        f3=f1.add(f2);
        for(int i=1;i<n;i++)
        {            
            f1=f2;
            f2=f3;
            f3=f1.add(f2);
        }
        return f1;
}
}