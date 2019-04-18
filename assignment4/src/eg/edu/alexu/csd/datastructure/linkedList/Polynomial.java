package eg.edu.alexu.csd.datastructure.linkedList;

import java.util.ArrayList;
import java.util.Scanner;

public class Polynomial extends SinglyLinkedList implements IPolynomialSolver {

	private static Polynomial A=new Polynomial();

	private static Polynomial B=new Polynomial();
	private static Polynomial C=new Polynomial();
	private  static Polynomial R=new Polynomial();
	public void setPolynomial(char poly, int[][] terms) {
		switch (poly)
		{
			case 'A':
			{
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
		
		return null;
	}

	
	public void clearPolynomial(char poly) {

		
	}

	
	public float evaluatePolynomial(char poly, float value) {

		return 0;
	}

	
	public int[][] add(char poly1, char poly2) {
		
		return null;
	}

	
	public int[][] subtract(char poly1, char poly2) {
		
		return null;
	}

	
	public int[][] multiply(char poly1, char poly2) {
		
		return null;
	}

	private static boolean checkValidation(String x)
	{
		if(x.charAt(0)!='(')return false;
		if(x.length()<5)return false;
		int i=0;
		while (i<x.length()){
			int counterComma=0;
			for(;i<x.length();i++)
			{
				if(x.charAt(i)==','&&counterComma==1)
					break;
				if(x.charAt(i)==','&&counterComma==0)counterComma++;
			}
		}
		if(i!=x.length())
		{
			int index=i-1,commas=0;
			if(x.charAt(index)==')')index--;
			while (x.charAt(index)!='(')
			{
				if(x.charAt(index)<'0'&&x.charAt(index)>'9'&&x.charAt(index)!=',')return false;
				if(x.charAt(index)==',')commas++;
				if(commas>1)return false;
				index--;
			}
		}
		else {
			i--;
			int index=i,commas=0;
			if(x.charAt(index)==')')index--;
			if(x.charAt(i)!=')')return false;
			while (x.charAt(index)!='(')
			{
				if((x.charAt(index)<'0'||x.charAt(index)>'9')&&x.charAt(index)!=',')return false;
				if(x.charAt(index)==',')commas++;
				if(commas>1)return false;
				index--;
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
			switch (s) {
				case 1: {
					char p = 0;
					do {
						try {
							System.out.println("Insert the variable name: A, B or C");
							p = scan.next().charAt(0);
							if (p != 'A' && p != 'B' && p != 'C')
								throw new RuntimeException("invalid variable");
						} catch (RuntimeException ex) {
							System.out.println(ex.getMessage());
						}
					} while (p != 'A' && p != 'B' && p != 'C');
					String x = new String();
					int temp_index=0,haha;
					ArrayList<String>y=new ArrayList<>();
					do {
						try {
							System.out.println("Insert the polynomial terms in the form: ");
							System.out.println("(coeff1, exponent1), (coeff2, exponent2), .. ");
							 y.add(temp_index,scan.next());
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
					//A.setPolynomial(p,terms);
					for(int i=0;i<terms.length;i++)
					{
						for(int j=0;j<terms[i].length;j++)
							System.out.println(terms[i][j]+" ");
					}

				}
			}
		}
	}
}

