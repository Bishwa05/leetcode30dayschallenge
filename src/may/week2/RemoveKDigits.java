package may.week2;

import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        int n = num.length();
        Integer min = Integer.MAX_VALUE;
        if( n==k){
            return "0";
        }

        StringBuilder sb = new StringBuilder(num);
        for (int j = 0; j < k; j++) {
            int i = 0;
            while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
                i++;
            }
            sb.delete(i, i + 1);
        }

        //remove leading 0's
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.delete(0, 1);

        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }


    public String removeKdigitsOptimized(String num, int k) {
        int len = num.length();
        //corner case
        if(k==len)
            return "0";

        Stack<Character> stack = new Stack<>();
        int i =0;
        while(i<num.length())
        {
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i))
            {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        while(k>0)
        {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits r = new RemoveKDigits();
        String num ="5337";
        int k =2;
        System.out.println(r.removeKdigitsOptimized(num, k));
    }
}
