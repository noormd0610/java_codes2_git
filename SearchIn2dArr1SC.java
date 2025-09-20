
public class SearchIn2dArr1SC {
//STAIR CASE METHOD
    public static boolean SearchIn2dArr(int arr[][], int target) {
        int n = arr.length;//row
        int m = arr[0].length;//cols
        //bootom star col
        // int row = n - 1;
        // int col = 0;
        // while (row >= 0 && col < m) {

        //     if(arr[row][col]==target) return true;
        //     else if(arr[row][col]>target) row--;
        //     else col++;
        // }
        // return false;
//top end col
        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {

            if (arr[row][col] == target) {
                return true;
            } else if (arr[row][col] > target) {
                col--;
            } else {
                row++;
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
        int target = 18;
        System.out.println(SearchIn2dArr(arr, target));
    }
}
