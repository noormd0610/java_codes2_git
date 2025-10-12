 import java.util.ArrayList;

public class StackArrlist {
    ArrayList<Integer> arrList = new ArrayList<>();

    void push(int data) {
        arrList.add(data);
    }

    int pop() {
        if (IsEmpty()) return Integer.MIN_VALUE;
        return arrList.remove(arrList.size() - 1);
    }

    int peek() {
        if (IsEmpty()) return Integer.MIN_VALUE;
        return arrList.get(arrList.size() - 1);
    }

    boolean IsEmpty() {
        return arrList.isEmpty();
    }

    void printStack() {
        while (!IsEmpty()) {
            System.out.print(peek() + " ");
            pop();
        }
    }

    public static void main(String[] args) {
        StackArr s = new StackArr();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.printStack();  // Output: 5 4 3 2 1
    }
}
