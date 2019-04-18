package eg.edu.alexu.csd.datastructure.linkedList;

import java.util.ArrayList;
import java.util.Scanner;

public class Polynomial extends SinglyLinkedList implements IPolynomialSolver {

    private static Polynomial A = new Polynomial();
    private static Polynomial A_ = new Polynomial();
    private static Polynomial B = new Polynomial();
    private static Polynomial B_ = new Polynomial();
    private static Polynomial C = new Polynomial();
    private static Polynomial C_ = new Polynomial();
    private  static Polynomial R = new Polynomial();
    private  static Polynomial R_ = new Polynomial();

    public void setPolynomial(char poly, int[][] terms) {

        switch (poly)
        {
            case 'A':
            {
                A.clearPolynomial('A');
                for(int i=0;i<terms.length;i++)
                {
                    while (A.size()<=terms[i][1])
                    {
                        A.add(0);
                    }
                    A.set(terms[i][1],terms[i][0]);
                }
            }
            break;
            case 'B':
            {
                A.clearPolynomial('B');
                for(int i=0;i<terms.length;i++)
                {
                    while (B.size()<=terms[i][1])
                    {
                        B.add(0);
                    }
                    B.set(terms[i][1],terms[i][0]);
                }
            }
            break;
            case 'C':
            {
                A.clearPolynomial('C');
                for(int i=0;i<terms.length;i++)
                {
                    while (C.size()<=terms[i][1])
                    {
                        C.add(0);
                    }
                    C.set(terms[i][1],terms[i][0]);
                }
            }
            break;
        }
    }

    public String print(char poly) {

        Polynomial temp = new Polynomial();
        switch (poly) {
            case 'A':
                temp.head = A.head;
                break;
            case 'B':
                temp.head = B.head;
                break;
            case 'C':
                temp.head = C.head;
                break;
            case 'R':
                temp.head = R.head;
                break;
        }

        String polynomial = new String();

        for(int index = 0; index < temp.size(); index++) {
            if(temp.get(index) != (Object)0) {
                if (index == 0)
                    polynomial = temp.get(index) + polynomial;
                else if (index == 1)
                    polynomial = (temp.get(index)==(Object)1?"":temp.get(index)) + "x" + polynomial;
                else
                    polynomial = (temp.get(index)==(Object)1?"":temp.get(index)) + "x^" + index + polynomial;
                polynomial = "+" + polynomial;
            }
        }

        if(polynomial.length()>0)
            polynomial = polynomial.substring(1);

        if(polynomial.length() == 0)
            polynomial += 0;

        return polynomial;
    }

    public void clearPolynomial(char poly) {
        switch (poly)
        {
            case 'A':
                A.clear();
                break;
            case 'B':
                B.clear();
                break;
            case 'C':
                C.clear();
                break;
            case 'R':
                R.clear();
                break;
        }
    }

    public float evaluatePolynomial(char poly, float value) {
        float result=0;
        switch (poly)
        {
            case 'A':
            {
                SLNode temp=A.head;
                int index=0;
                while (temp!=null)
                {
                    result=result+((float)temp.val)*(float) java.lang.Math.pow(value,index);
                    temp=temp.next;
                    index++;
                }
            }
            break;
            case 'B':
            {
                SLNode temp=B.head;
                int index=0;
                while (temp!=null)
                {
                    result=result+((float)temp.val)*(float)java.lang.Math.pow(value,index);
                    temp=temp.next;
                    index++;
                }
            }
            break;
            case 'C':
            {
                SLNode temp=C.head;
                int index=0;
                while (temp!=null)
                {
                    result=result+((float)temp.val)*(float)java.lang.Math.pow(value,index);
                    temp=temp.next;
                    index++;
                }
            }
            break;
            case 'R':
            {
                SLNode temp=R.head;
                int index=0;
                while (temp!=null)
                {
                    result=result+((float)temp.val)*(float)java.lang.Math.pow(value,index);
                    temp=temp.next;
                    index++;
                }
            }
            break;
        }
        return result;
    }

    public int[][] add(char poly1, char poly2) {

        Polynomial temp1 = new Polynomial();
        Polynomial temp2 = new Polynomial();

        switch (poly1) {
            case 'A':
                temp1.head = A.head;
                break;
            case 'B':
                temp1.head = B.head;
                break;
            case 'C':
                temp1.head = C.head;
                break;
        }

        switch (poly2) {
            case 'A':
                temp2.head = A.head;
                break;
            case 'B':
                temp2.head = B.head;
                break;
            case 'C':
                temp2.head = C.head;
                break;
        }

        int size = temp1.size() > temp2.size() ? temp2.size() : temp1.size();

        for(int index = 0; index < size; index++) {
            R.add((int)temp1.get(index) + (int)temp2.get(index));
        }

        if(temp1.size() > temp2.size()) {
            for(int index = size; index < temp1.size(); index++)
                R.add(temp1.get(index));
        }
        else {
            for(int index = size; index < temp2.size(); index++)
                R.add(temp2.get(index));
        }

        size = 0;
        for(int index = 0; index < R.size(); index ++) {
            if(R.get(index) != (Object) 0)
                size++;
        }

        int [][] result = new int [size][2];
        for(int index = 0, i=0; index < R.size(); index ++, i++) {
            if(R.get(index) != (Object) 0) {
                result[size-i-1][0] = index;
                result[size-i-1][1] = (int)R.get(index);
            }
            else i--;
        }
        return result;
    }

    public int[][] subtract(char poly1, char poly2) {

        Polynomial temp1 = new Polynomial();
        Polynomial temp2 = new Polynomial();

        switch (poly1) {
            case 'A':
                temp1.head = A.head;
                break;
            case 'B':
                temp1.head = B.head;
                break;
            case 'C':
                temp1.head = C.head;
                break;
        }

        switch (poly2) {
            case 'A':
                temp2.head = A.head;
                break;
            case 'B':
                temp2.head = B.head;
                break;
            case 'C':
                temp2.head = C.head;
                break;
        }

        int size = temp1.size() > temp2.size() ? temp2.size() : temp1.size();

        for(int index = 0; index < size; index++) {
            R.add((int)temp1.get(index) - (int)temp2.get(index));
        }

        if(temp1.size() > temp2.size()) {
            for(int index = size; index < temp1.size(); index++)
                R.add(temp1.get(index));
        }
        else {
            for(int index = size; index < temp2.size(); index++)
                R.add(-1 * (int)temp2.get(index));
        }

        size = 0;
        for(int index = 0; index < R.size(); index ++) {
            if(R.get(index) != (Object) 0)
                size++;
        }

        int [][] result = new int [size][2];
        for(int index = 0, i=0; index < R.size(); index ++, i++) {
            if(R.get(index) != (Object) 0) {
                result[size-i-1][0] = index;
                result[size-i-1][1] = (int)R.get(index);
            }
            else i--;
        }

        if(size == 0) {
            result = new int [1][2];
            result[0][0] = result[0][1] = 0 ;
        }

        return result;
    }

    public int[][] multiply(char poly1, char poly2) {

        return null;
    }

    private static boolean checkValidation(String x)
    {
        if(x.charAt(0)!='(')return false;
        if(x.length()<5)return false;
        int i=0;
        while (i<x.length()) {
            int counterComma = 0;
            for (; i < x.length(); i++) {
                if (x.charAt(i) == ',' && counterComma == 1)
                    break;
                if (x.charAt(i) == ',' && counterComma == 0) counterComma++;
            }

            if (i != x.length()) {
                int index = i - 1, commas = 0;
                if (x.charAt(index) == ')') index--;
                while (x.charAt(index) != '(') {
                    if ((x.charAt(index) < '0' || x.charAt(index) > '9') && x.charAt(index) != ','&&!(x.charAt(index)=='-'&&(x.charAt(index+1)>'0'&&x.charAt(index+1)<'9')))
                        return false;
                    if (x.charAt(index) == ',') commas++;
                    if (commas > 1) return false;
                    index--;
                }
            } else {
                i--;
                int index = i, commas = 0;
                if (x.charAt(index) == ')') index--;
                if (x.charAt(i) != ')') return false;
                while (x.charAt(index) != '(') {
                    if ((x.charAt(index) < '0' || x.charAt(index) > '9') && x.charAt(index) != ','&&!(x.charAt(index)=='-'&&(x.charAt(index+1)>'0'&&x.charAt(index+1)<'9')))
                        return false;
                    if (x.charAt(index) == ',') commas++;
                    if (commas > 1) return false;
                    index--;
                    i++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        while (true) {
            int s = 0;
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
                    if (s > 7 || s < 1)
                        throw new RuntimeException("invalid input");
                } catch (RuntimeException ex) {
                    System.out.println(ex.getMessage());
                }
            } while (s < 1 || s > 7);
            String p = new String();
            switch (s) {
                case 1: {
                    do {
                        try {
                            System.out.println("Insert the variable name: A, B or C");
                            p = scan.next().toUpperCase();
                            String tempooooo=scan.nextLine();
                            if (!p.equals("A") && !p.equals("B") && !p.equals("C") && p.length() != 1)
                                throw new RuntimeException("invalid variable");
                        } catch (RuntimeException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } while (!p.equals("A") && !p.equals("B") && !p.equals("C"));
                    String x = new String();
                    int temp_index=0,haha;
                    ArrayList<String>y=new ArrayList<>();
                    do {
                        try {
                            System.out.println("Insert the polynomial terms in the form: ");
                            System.out.println("(coeff1, exponent1), (coeff2, exponent2), .. ");
                            y.add(temp_index,scan.nextLine());
                            if (!checkValidation(y.get(temp_index)))
                                throw new RuntimeException("Invalid Input");
                        } catch (RuntimeException ex) {
                            System.out.println(ex.getMessage());
                        }
                        haha=temp_index;
                        temp_index++;

                    } while (!checkValidation(y.get(haha)));
                    temp_index--;
                    x=y.get(temp_index);
                    int openCounter=0;
                    for(int i=0;i<x.length();i++)
                        if(x.charAt(i)=='(')openCounter++;
                    int  terms[][]=new int [openCounter][2];
                    int index=0;
                    String temp = new String();
                    for(int i=0;i<x.length();i++)
                    {
                        if(x.charAt(i)!='('&&x.charAt(i)!=')'&&x.charAt(i)!=',')
                        {
                            temp=temp+x.charAt(i);
                        }
                        if(x.charAt(i)==','&&x.charAt(i+1)!=')'&&x.charAt(i+1)!='(')
                        {
                            terms[index][0]=Integer.parseInt(temp);
                            temp="";
                        }
                        else if(x.charAt(i)==')') {
                            terms[index][1] = Integer.parseInt(temp);
                            index++;
                            temp="";
                        }
                    }
                    A.setPolynomial(p.charAt(0),terms);
                    System.out.println("Polynomial " + p.charAt(0) + " is set");
                }
                break;
                case 2: {
                    System.out.println("Insert the variable name: A, B, C or R");
                    p = scan.next().toUpperCase();
                    switch (p.charAt(0)) {
                        case 'A':
                            System.out.println("Value in "+ p.charAt(0) + ": " + A.print('A'));
                            break;
                        case 'B':
                            System.out.println("Value in "+ p.charAt(0) + ": " + A.print('B'));
                            break;
                        case 'C':
                            System.out.println("Value in "+ p.charAt(0) + ": " + A.print('C'));
                            break;
                        case 'R':
                            System.out.println("Value in "+ p.charAt(0) + ": " + A.print('R'));
                            break;
                    }
                }
                case 3:

                case 4:

                case 5:

                case 6:

                case 7:

            }
        }
    }
}

