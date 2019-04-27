package eg.edu.alexu.csd.datastructure.linkedList;

public class ExpressionEvaluater implements IExpressionEvaluater {
    @Override
    public String infixToPostfix(String expression) {
        String out = "";
        Stack stacky=new Stack();
        for(int i=0;i<expression.length();i++)
        {
            if(expression.charAt(i)=='-') {
                int index = 0;
                int index2=0;
                if (i > 0) {
                    index = i - 1;
                    while (i != 0 && expression.charAt(index) == ' ')
                        index--;
                }
                if (i == 0) {
                    index2=i+1;
                    while (index2<expression.length()&&expression.charAt(index2)==' ')
                        index2++;
                    out=out+expression.charAt(index2);
                    i=index2;
                    out=out+" -";
                } else if (expression.charAt(index) == '-' || expression.charAt(index) == '*' || expression.charAt(index) == '/' || expression.charAt(index) == '+' || expression.charAt(index) == '(') {
                    index2=i+1;
                    while (index2<expression.length()&&expression.charAt(index2)==' ')
                        index2++;
                    out=out+expression.charAt(index2);
                    i=index2;
                    out=out+" -";
                }
                else {
                    if(stacky.isEmpty())
                    {
                        stacky.push(expression.charAt(i));
                    }
                    else
                    {
                        int peek=0,scanned=0;
                        switch (expression.charAt(i))
                        {
                            case '+':
                            case '-':
                                scanned=1;
                                break;

                            case '*':
                            case '/':
                                scanned=2;
                                break;
                        }
                        switch ((char)stacky.peek())
                        {
                            case '+':
                            case '-':
                                peek=1;
                                break;
                            case '*':
                            case '/':
                                peek=2;
                                break;
                            case '(':
                            case ')':
                                peek=0;
                                break;
                        }
                        while (scanned<=peek&&!stacky.isEmpty())
                        {
                            if(out.charAt(out.length()-1)!=' ')
                                out=out+' ';
                            out=out+(char)stacky.pop();
                            if(!stacky.isEmpty()){
                                switch ((char)stacky.peek())
                                {
                                    case '+':
                                    case '-':
                                        peek=1;
                                        break;
                                    case '*':
                                    case '/':
                                        peek=2;
                                        break;
                                    case '(':
                                    case ')':
                                        peek=0;
                                        break;
                                }
                            }
                        }
                        stacky.push(expression.charAt(i));
                    }

                }
            }
            else if(!(expression.charAt(i)>39&&expression.charAt(i)<44)&&expression.charAt(i)!='-'&&expression.charAt(i)!='/')
            {
                if(expression.charAt(i)==' ')
                {
                    if(!out.isEmpty()){
                    if(out.charAt(out.length()-1)!=' ')
                    {
                        out=out+expression.charAt(i);
                    }}
                }
                else {
                    if(!out.isEmpty())
                    if(out.charAt(out.length()-1)!=' ')
                        out=out+' ';
                    out = out + expression.charAt(i);

                }
            }
            else if(stacky.isEmpty())
            {
                stacky.push(expression.charAt(i));
            }
            else if(expression.charAt(i)=='('||expression.charAt(i)==')')
            {
                if(expression.charAt(i)=='(')
                {
                    stacky.push(expression.charAt(i));
                }
                else
                {
                    while ((char)stacky.peek()!='(')
                    {
                        if(out.charAt(out.length()-1)!=' ')
                            out=out+' ';
                        out=out+(char)stacky.pop();
                    }
                    stacky.pop();
                }
            }
            else
            {
                int peek=0,scanned=0;
                switch (expression.charAt(i))
                {
                    case '+':
                    case '-':
                        scanned=1;
                        break;

                    case '*':
                    case '/':
                        scanned=2;
                        break;
                }
                switch ((char)stacky.peek())
                {
                    case '+':
                    case '-':
                        peek=1;
                        break;
                    case '*':
                    case '/':
                        peek=2;
                        break;
                    case '(':
                    case ')':
                        peek=0;
                        break;
                }
                while (scanned<=peek&&!stacky.isEmpty())
                {
                    if(out.charAt(out.length()-1)!=' ')
                        out=out+' ';
                    out=out+(char)stacky.pop();
                    if(!stacky.isEmpty()){
                    switch ((char)stacky.peek())
                    {
                        case '+':
                        case '-':
                            peek=1;
                            break;
                        case '*':
                        case '/':
                            peek=2;
                            break;
                        case '(':
                        case ')':
                            peek=0;
                            break;
                    }
                    }
                }
                stacky.push(expression.charAt(i));
            }
        }
        while (!stacky.isEmpty()) {
            if(out.charAt(out.length()-1)!=' ')
                out=out+' ';
            out = out + (char) stacky.pop();

        }
        return out;
    }

    @Override
    public int evaluate(String expression) {
        String out;
        float result;
        Stack stacky=new Stack();
        for(int i=0;i<expression.length();i++)
        {

        }
        return 0;
    }
}
