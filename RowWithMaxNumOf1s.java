
public class RowWithMaxNumOf1s {

    // Binary Search to find the first occurrence of target (1) in a sorted row
    public static int FirstOccurence(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                right = mid - 1; // move left to find first occurrence
            } else {
                left = mid + 1; // move right if mid < target
            }
        }
        return left; // index of first 1
    }

    // Function to find the row with maximum number of 1s
    public static int RowWithMaxNumOf1s(int arr[][], int target) {
        int rowLen = arr[0].length; // total columns
        int max = Integer.MIN_VALUE; // store max 1s count
        int Idx = -1; // store row index with max 1s

        for (int i = 0; i < arr.length; i++) {
            int count = FirstOccurence(arr[i], target);
            int RowMaxNumsOf1s = (rowLen - count);
            // number of 1s in this row = total columns - firstIndexOf1
            //  same as len=right-left+1 ,but here we taken rowlen. not right var that why wee didnot added 1.thats it
            
            if (RowMaxNumsOf1s > max) {
                Idx = i; // update row index
                max = RowMaxNumsOf1s; // update max 1s
            }
        }
        return Idx; // return row index with max 1s
    }

    public static void main(String[] args) {
        int arr[][] = {
            {0, 0, 1, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1}
        };
        int target = 1;
        System.out.println(RowWithMaxNumOf1s(arr, target));
    }
}
