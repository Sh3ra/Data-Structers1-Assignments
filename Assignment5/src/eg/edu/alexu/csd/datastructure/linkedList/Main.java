package eg.edu.alexu.csd.datastructure.linkedList;

public class Main {

    public static void main(String[] args) {
        ExpressionEvaluater tester=new ExpressionEvaluater();
       System.out.println(tester.infixToPostfix( "-2 * ( -x -- y) "));
       System.out.println(tester.infixToPostfix( "   (-2-x)+y "));
        System.out.println(tester.infixToPostfix( "aa + -ass * (hh / -20)"));
        System.out.println(tester.evaluate( "2 - 4 - 5 +"));

    }

}
