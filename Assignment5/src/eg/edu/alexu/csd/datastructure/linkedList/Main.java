package eg.edu.alexu.csd.datastructure.linkedList;

public class Main {

    public static void main(String[] args) {
        ExpressionEvaluater tester=new ExpressionEvaluater();
        //sheel space men awel term
        System.out.println(tester.infixToPostfix( "-2 * ( -x - y) "));
        System.out.println(tester.infixToPostfix( "(2-x)+y "));
    }

}
