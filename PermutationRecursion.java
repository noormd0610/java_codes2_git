
import java.util.*;

public class PermutationRecursion {

    public static void PermutationRecursion(String inp, String op) {
        //base
        if (inp.length() == 0) {
            System.out.println(op);
            return;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        //choices
        for (int i = 0; i <= inp.length() - 1; i++) {
            char ch = inp.charAt(i);
            //control recursion
            if (!map.containsKey(ch)) {
                map.put(ch, 1);

                String input = inp.substring(0, i) + inp.substring(i + 1);
                String output = op + ch;
                PermutationRecursion(input, output);
            }
        }

    }

    public static void main(String[] args) {
        String inp = "aab";
        String op = "";
        PermutationRecursion(inp, op);
    }
}
