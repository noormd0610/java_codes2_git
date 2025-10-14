
import java.util.*;

public class ArrList2 {

    public static ArrayList<Integer> lonely(ArrayList<Integer> list) {
        ArrayList<Integer> Res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            list.remove(i);

            if (!(list.contains(temp - 1) || list.contains(temp + 1)) && !list.contains(temp)) {
                Res.add(temp);
            }
            list.add(i,temp);
        }
        return Res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(3);

        System.out.println(lonely(list));
    }
}
