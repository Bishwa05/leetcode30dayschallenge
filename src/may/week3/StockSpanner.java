package may.week3;

import java.util.Stack;

public class StockSpanner {
    private Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }

    public static void main(String arg[]){

        StockSpanner s = new StockSpanner();

        System.out.println(s.next(100));
        System.out.println(s.next(80));
        System.out.println(s.next(60));
        System.out.println(s.next(70));
        System.out.println(s.next(60));
        System.out.println(s.next(75));
        System.out.println(s.next(85));



    }
}
