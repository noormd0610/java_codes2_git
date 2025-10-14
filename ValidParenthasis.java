
import java.util.*;

public class ValidParenthasis {

    public static boolean ValidParenthasis(String str) {
        Stack<Character> s = new Stack<>();
        if (str.length() % 2 == 0) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '(' || ch == '{' || ch == '[') {
                    s.push(ch);
                } else {
                    if (!s.isEmpty() && ch - 1 == (int) s.peek() || ch - 2 == (int) s.peek()) {
                        s.pop();
                    } else {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        String str = "((})";
        System.out.println(ValidParenthasis(str));
        // System.out.println(']'-2);
    }
}
