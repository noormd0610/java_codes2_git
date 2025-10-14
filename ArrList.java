
import java.util.*;

public class ArrList {

    public static boolean MonotonicInc(ArrayList<Integer> list) {
        boolean res = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                res = false;
            }
        }
        return res;
    }

    public static boolean MonotonicDec(ArrayList<Integer> list) {
        boolean res = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                res = false;
            }
        }
        return res;
    }

    public static boolean Monotonic(ArrayList<Integer> list) {
        if (list.get(0) <= list.get(1)&& list.get(1) <= list.get(2)) {
            return MonotonicInc(list);
        } else {
            return MonotonicDec(list);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(3);
        list.add(2);
         
        System.out.println(Monotonic(list));
    }
}
