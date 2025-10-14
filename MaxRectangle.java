
import java.util.Stack;

public class MaxRectangle {

    public static void nextSmall(int nums[], int nextSmall[]) {
        Stack<Integer> s = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            //s-1

            while (!s.isEmpty() && nums[s.peek()] >= nums[i]) {
                s.pop();
            }

            //2 
            if (s.isEmpty()) {
                nextSmall[i] = nums.length;
            } else {
                nextSmall[i] = s.peek();
            }

            //3
            s.push(i);
        }
    }

    public static void prevSmall(int nums[], int prevSmall[]) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i <= nums.length - 1; i++) {
            //s-1

            while (!s.isEmpty() && nums[s.peek()] >= nums[i]) {
                s.pop();
            }

            //2 
            if (s.isEmpty()) {
                prevSmall[i] = -1;
            } else {
                prevSmall[i] = s.peek();
            }
            //3
            s.push(i);
        }
    }

    public static int MaxRectangle(int nums[], int prevSmall[], int nextSmall[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int height = nums[i];
            int width = nextSmall[i] - prevSmall[i] - 1;
            int area = height * width;
            max = Math.max(area, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = {2, 4};
        int prevSmall[] = new int[nums.length];
        int nextSmall[] = new int[nums.length];
        nextSmall(nums, nextSmall);
        prevSmall(nums, prevSmall);
        System.out.println(MaxRectangle(nums, prevSmall, nextSmall));
    }

}
