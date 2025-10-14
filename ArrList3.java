
import java.util.*;

public class ArrList3 {

    public static int Occurency(ArrayList<Integer> list, int key) {

        HashMap<Integer, Integer> map = new HashMap<>(); //num:occ
        for (int i = 0; i < list.size() - 1; i++) {

            if (list.get(i) == key) {
                int num = list.get(i + 1);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

        }

        //check most
        int keey = 0;
        int value = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > value) {
                value = entry.getValue();
                keey=entry.getKey();
            }

        }
        return keey;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
       
        list.add(9);
        list.add(1);
        list.add(9);
        list.add(1);
        list.add(9);
        list.add(2);
        list.add(9);
        list.add(3);
        System.out.println(Occurency(list, 9));
    }
}
