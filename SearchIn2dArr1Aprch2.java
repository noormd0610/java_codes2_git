
public class SearchIn2dArr1Aprch2{
//backside of intuition we think 2d into 1d because arr is sorted that why we treat as 1d arr search, after find mid we have to check in 2d arr for ele on that case wee do this like row=mid/m and col=mid%m
    public static boolean  SearchIn2dArr(int arr[][], int target) {
        int n = arr.length;
        int m = arr[0].length;
        int left = 0;
        int right = n * m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row=mid/m;
            int col=mid%m;
            if(arr[row][col]==target){
                return true;
            }else if(arr[row][col]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[][] = {
            {3, 4, 7, 9},
            {12, 13, 16, 18},
            {20, 21, 23, 29}
        };
        int target = 28;
        System.out.println(SearchIn2dArr(arr, target));
    }
}
