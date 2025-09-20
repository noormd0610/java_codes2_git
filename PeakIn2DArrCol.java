
public class PeakIn2DArrCol {
public static void PrintArr(int arr[]){
    for(int  i=0;i<arr.length-1;i++){
        System.out.println("[ "+arr[i]+" "+arr[i+1]+" ]");
    }
}


    public static int FindMaxInCol(int arr[][], int n, int col) {
        int max = Integer.MIN_VALUE;
        int index=0;
        for (int i = 0; i < n; i++) {
            if (arr[i][col] > max) {
                max = arr[i][col];
                index=i;
            }
          
        }
        return index;
    }

    //cols
    public static int[] PeakIn2DArr(int arr[][], int n, int m) {
        int left = 0;
        int right = m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; //mid==col
            int row = FindMaxInCol(arr, n, mid);

            int leftNeighbor = (mid-1) >= 0 ? arr[row][mid - 1] : -1;
            int rightNeighbor = (mid+1) < m  ? arr[row][mid + 1] : -1;

            if (arr[row][mid] > leftNeighbor && arr[row][mid] > rightNeighbor) {
                return new int[]{row, mid};
            } else if (leftNeighbor > arr[row][mid]) {
                right = mid - 1;//moving col
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int arr[][] = {
            {4, 2, 5, 1, 4, 5},
            {2, 9, 3, 2, 3, 2},
            {1, 7, 6, 0, 1, 3},
            {3, 6, 2, 3, 7, 2}
        };
        int n = arr.length;
        int m = arr[0].length;
        PrintArr(PeakIn2DArr(arr, n, m));

    }
}
