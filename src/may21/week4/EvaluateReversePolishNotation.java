package may21.week4;

import java.util.Stack;

public class EvaluateReversePolishNotation
{
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();

        for(String s: tokens) {
            if("+".equals(s)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);
            } else if("-".equals(s)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            } else if("*".equals(s)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a*b);
            } else if("/".equals(s)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();

    }
}
