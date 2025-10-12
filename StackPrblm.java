
import java.util.*;

public class StackPrblm {

    public static void AddBottom(Stack<Integer> stack, int s) {

        // Base case: if stack is empty, push the new element at the bottom
        if (stack.size() == 0) {
            stack.push(s);
            return;
        }

        // v Step 1: Pop the top element and store it temporarily
        int val = stack.pop();

        //  Step 2: Recursively call to reach the bottom of the stack
        AddBottom(stack, s);

        //  Step 3: After adding 's' at bottom, push the stored element back
        stack.push(val);
    }

    public static void printStack(Stack<Character> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
    }

    public static String ReverseStr(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;

        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder strBuilder = new StringBuilder("");

        while (!s.isEmpty()) {
            strBuilder.append(s.pop());
        }

        return strBuilder.toString();
    }

    public static void ReverseStack(Stack<Integer> stack) {

        //  Base case:
        // If the stack is empty, there is nothing to reverse.
        if (stack.isEmpty()) {
            return;
        }

        // Step 1: Pop the top element (small problem broken down)
        int val = stack.pop();

        //  Hypothesis:
        // Assume ReverseStack(stack) will correctly reverse the smaller stack
        ReverseStack(stack);

        //  Induction step:
        // Now insert the popped element (val) at the bottom of the reversed smaller stack
        AddBottom(stack, val);
    }

    public static void StockSpans(int Stocks[], int StocksSpan[]) {
        // Stack stores indexes of previous higher stock prices
        Stack<Integer> stack = new Stack<>();

        // First stock always has span = 1
        StocksSpan[0] = 1;
        stack.push(0); // push index of first stock

        // Loop through rest of the stocks
        for (int i = 1; i < Stocks.length; i++) {
            int currStock = Stocks[i];

            // Pop all smaller or equal stock prices from stack
            while (!stack.isEmpty() && currStock >= Stocks[stack.peek()]) {
                stack.pop();
            }

            // If stack is empty → no previous higher stock → span = i + 1
            if (stack.isEmpty()) {
                StocksSpan[i] = i + 1;
            } // Else → previous higher stock found → span = distance between them
            else {
                StocksSpan[i] = i - stack.peek();
            }

            // Push current stock index into stack
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        int Stocks[] = {100, 80, 60, 100};
        int StocksSpan[] = new int[Stocks.length];
        StockSpans(Stocks, StocksSpan);

        for (int i = 0; i < StocksSpan.length; i++) {
            System.out.print(StocksSpan[i] + " ");
        }

        //  Stack<Integer> s = new Stack<>();
        //     s.push(1);
        //     s.push(2);
        //     s.push(3);
        //     System.out.println("Original Stack: " + s);
        //     ReverseStack(s);
        //     System.out.println("Reversed Stack: " + s);
        //     String str = "abc";
        //     System.out.println("Reversed String: " + ReverseStr(str));
    }
}
