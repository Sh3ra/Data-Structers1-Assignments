package eg.edu.alexu.csd.datastructure.linkedList;

import com.sun.imageio.spi.RAFImageInputStreamSpi;

import static java.lang.Math.abs;

public class ExpressionEvaluater implements IExpressionEvaluater {
    @Override
    public String infixToPostfix(String expression) {
        try{
            if(expression.length()<3)
            {
                throw new RuntimeException ("Invalid expression");
            }
            int par_count=0;
            for(int i=0;i<expression.length();i++)
            {
                if(expression.charAt(i)=='(')par_count++;
                else if(expression.charAt(i)==')'&&par_count==0)
                {
                    throw new RuntimeException("Invalid expression");
                }
                else if(expression.charAt(i)==')'&&par_count>0)par_count--;
            }
            int numb=0,op=0;
            for(int i=0;i<expression.length();i++)
            {
                if((expression.charAt(i)>47&&expression.charAt(i)<58))
                {
                    numb++;
                    if(i>0)
                    {
                        if(expression.charAt(i-1)>47&&expression.charAt(i-1)<58)
                            numb--;
                    }
                }
                else if(expression.charAt(i)=='+'||expression.charAt(i)=='-'||expression.charAt(i)=='*'||expression.charAt(i)=='/')
                {
                    op++;
                }
            }
            int negative_term=numb-op-1;

            if(abs(negative_term)!=0)
            {
                int neg=0;
                for(int i=0;i<expression.length();i++)
                {
                    if(expression.charAt(i)=='-')neg++;
                }
                if(neg<abs(negative_term))
                {
                    throw new RuntimeException("Invalid Expression");
                }
            }
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
            System.exit(0);
        }
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
                    while (index2<expression.length()&&((expression.charAt(index2)>47&&expression.charAt(index2)<58)||(expression.charAt(index2)>96&&expression.charAt(index2)<123))) {
                        out = out + expression.charAt(index2);
                        index2++;
                    }
                    i=index2-1;

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
                            out = out + expression.charAt(i);
                    }
                    }
                }
                else {
                    if(!out.isEmpty())
                    if(out.charAt(out.length()-1)!=' ')
                        out=out+' ';
                    int index=i;
                    while (index<expression.length()&&((expression.charAt(index)>47&&expression.charAt(index)<58)||(expression.charAt(index)>96&&expression.charAt(index)<123))) {
                        out = out + expression.charAt(index);
                        index++;
                    }
                    i=index-1;

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
        try{
        int numb=0,op=0;
        for(int i=0;i<expression.length();i++)
        {
            if((expression.charAt(i)>47&&expression.charAt(i)<58))
            {
                numb++;
                if(i>0)
                {
                    if(expression.charAt(i-1)>47&&expression.charAt(i-1)<58)
                        numb--;
                }
            }
            else if(expression.charAt(i)=='+'||expression.charAt(i)=='-'||expression.charAt(i)=='*'||expression.charAt(i)=='/')
            {
                op++;
            }
        }
        int negative_term=numb-op-1;
        negative_term*=-1;
        if(negative_term!=0)
        {
            int neg=0;
            for(int i=0;i<expression.length();i++)
            {
                if(expression.charAt(i)=='-')neg++;
            }
            if(neg<negative_term)
            {
                throw new RuntimeException("Invalid Expression");
            }
        }
    }catch (RuntimeException ex){
        System.out.println(ex.getMessage());
        System.exit(0);
    }

        float result;
        Stack stacky=new Stack();
        int negative_terms=0,numb=0,op=0;
        for(int i=0;i<expression.length();i++)
        {
            if((expression.charAt(i)>47&&expression.charAt(i)<58))
            {
                numb++;
                if(i>0)
                {
                    if(expression.charAt(i-1)>47&&expression.charAt(i-1)<58)
                        numb--;
                }
            }
            else if(expression.charAt(i)=='+'||expression.charAt(i)=='-'||expression.charAt(i)=='*'||expression.charAt(i)=='/')
            {
                op++;
            }
        }
        negative_terms=numb-op-1;
        negative_terms*=-1;
        for(int i=0;i<expression.length();i++)
        {
            if(expression.charAt(i)=='-')
            {
                if(negative_terms==0)
                {
                    float v1,v2;
                    String temp=""+stacky.pop();
                    v1=Float.parseFloat(temp);
                    temp=""+stacky.pop();
                    v2=Float.parseFloat(temp);
                    result= v2-v1;
                    stacky.push(result);
                }
                else {
                    float v1;
                    String temp=""+stacky.pop();
                    v1=Float.parseFloat(temp)*-1;
                    stacky.push(v1);
                    negative_terms--;
                }
            }
         else if((expression.charAt(i)>47&&expression.charAt(i)<58)||(expression.charAt(i)>96&&expression.charAt(i)<123))
            {
                String temp="";
                int index=i;
                while (expression.charAt(index)>47&&expression.charAt(index)<58&&index<expression.length()){
                    temp=temp+expression.charAt(index);
                    index++;}
                i=index-1;
                stacky.push(temp);
            }
            else if(expression.charAt(i)=='+'||expression.charAt(i)=='*'||expression.charAt(i)=='/')
            {
                float v1,v2;
                String temp=""+stacky.pop();
                v1=Float.parseFloat(temp);
                temp=""+stacky.pop();
                v2=Float.parseFloat(temp);
                switch (expression.charAt(i))
                {
                    case '+':{
                        result=v1+v2;
                        stacky.push(result);
                    }break;
                    case '*':{
                        result=v1*v2;
                        stacky.push(result);
                    }break;
                    case '/':{
                        result= v2/v1;
                        stacky.push(result);
                    }
                }
            }
        }
        result=(float)stacky.pop();
        return (int)result;
    }
}
