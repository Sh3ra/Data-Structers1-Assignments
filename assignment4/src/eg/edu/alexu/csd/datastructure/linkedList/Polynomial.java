package eg.edu.alexu.csd.datastructure.linkedList;

public class Polynomial extends SinglyLinkedList implements IPolynomialSolver {
	
	static Polynomial A = new Polynomial();
	static Polynomial B = new Polynomial();
	static Polynomial C = new Polynomial();
	static Polynomial R = new Polynomial();
	
	public void setPolynomial(char poly, int[][] terms) {
		
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
		}
		
		String polynomial = new String();
		
		for(int index = 0; index < temp.size(); index++) {
			if(temp.get(index) != (Object)0) {
				if (index == 0)
					polynomial = temp.get(index) + polynomial;
				else if (index == 1)
					polynomial = "X" + polynomial;
				else 
					polynomial = temp.get(index) + "X^" + index + polynomial;
				polynomial = "+" + polynomial;
			}
		}
		if(polynomial.length()>0)
			polynomial = polynomial.substring(1);
		return polynomial;
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
	
	public static void main(String[] args) {
		
	}
}

