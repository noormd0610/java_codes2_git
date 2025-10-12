
import java.util.Stack;

public class NextGreaterthanele {

    public static void nextGreaterNum(int nums[], int nextGreaterNum[]) {
        // Stack stores indexes of elements (not values)
        Stack<Integer> s = new Stack<>();

        // Traverse from right to left
        for (int i = nums.length - 1; i >= 0; i--) {

            //  Step 1: Pop all smaller or equal elements from stack
            while (!s.isEmpty() && nums[s.peek()] <= nums[i]) {
                s.pop();
            }

            //  Step 2: If stack empty → no greater element → -1
            if (s.isEmpty()) {
                nextGreaterNum[i] = -1;
            } // Else → top of stack is next greater element
            else {
                nextGreaterNum[i] = nums[s.peek()];
            }

            //  Step 3: Push current index into stack
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int nums[] = {7, 9, 6, 2, 1, 5};
        int nextGreaterNum[] = new int[nums.length];

        nextGreaterNum(nums, nextGreaterNum);

        for (int i = 0; i < nextGreaterNum.length; i++) {
            System.out.print(nextGreaterNum[i] + " ");
        }
    }
}
