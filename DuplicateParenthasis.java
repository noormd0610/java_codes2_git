
import java.util.Stack;

public class DuplicateParenthasis {

    public static boolean IsDuplicateParenthasis(String str) {
        Stack<Character> stack = new Stack<>();

        //s-1
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            //s-2
            if (ch == ')') { //close
                int count = 0;

                while (!stack.isEmpty() && stack.peek() != '(') {
                    count++;
                    stack.pop();
                }
                //s-3
                if (count > 0) {
                    stack.pop();
                } else {
                    return true;
                }
            } else { //open
                stack.push(ch);
            }

        }
        if (stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "((a+b))";
        System.out.println(IsDuplicateParenthasis(s));

    }
}
