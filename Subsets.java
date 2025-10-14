
import java.util.*;

public class Subsets {

    public static void printArr(List arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public static void Subsets(String output, String input, HashSet<String> set) {
        //base
        if (input.length() == 0) {
            set.add(output);
            System.out.println(output);
            return;
        }

        //tree choices include or exclude
        char ch = input.charAt(0);
        input = input.substring(1);

        String output1 = output;
        Subsets(output1, input, set);//exclude

        String output2 = output + ch;
        Subsets(output2, input, set);//include

    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        String input = "aab";
        String output = " ";
        Subsets(output, input, set);
        List<String> list = new ArrayList<>(set);
        printArr(list);
    }
}
