package eg.edu.alexu.csd.datastructure.linkedList;

import java.util.*;

public class Main {

    public static boolean checkValidation(String x)
    {
        if(x.charAt(0)!='(')
            return false;
        for(int i=1;i<x.length();i++)
        {
            if(x.charAt(i)!=' ')
            {

            }
        }

        return true;
    }

    public static void main(String[] args) {

        int s=0;
    	Scanner scan = new Scanner(System.in);
    	do {
            try {
                System.out.println("Please choose an action");
                System.out.println("----------------------");
                System.out.println("1- Set a polynomial variable ");
                System.out.println("2- Print the value of a polynomial variable");
                System.out.println("3- Add two polynomials ");
                System.out.println("4- Subtract two polynomials");
                System.out.println("5- Multiply two polynomials");
                System.out.println("6- Evaluate a polynomial at some point ");
                System.out.println("7- Clear a polynomial variable");
                System.out.println("====================================================================");
                s = scan.nextInt();
                if(s>7||s<1)
                    throw new RuntimeException("invalid input");
            }
            catch (RuntimeException ex)
            {
                System.out.println(ex.getMessage());
            }
        }while (s<1||s>7);
    	switch (s)
        {
            case 1: {
                    char p=0;
                    do {
                        try {
                            System.out.println("Insert the variable name: A, B or C");
                            p = scan.next().charAt(0);
                            if(p!='A'&&p!='B'&&p!='C')
                                throw new RuntimeException("invalid variable");
                        }
                        catch (RuntimeException ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    }while (p!='A'&&p!='B'&&p!='C');
                    String x=null;
                    do {
                        try {
                            System.out.println("Insert the polynomial terms in the form: ");
                            System.out.println("(coeff1, exponent1), (coeff2, exponent2), .. ");
                            x = scan.nextLine();
                            if(!checkValidation(x))
                                throw new RuntimeException("Invalid Input");
                        }
                        catch (RuntimeException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }while (!checkValidation(x));

            }
            }
        }


    }



