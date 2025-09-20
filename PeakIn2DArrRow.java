
public class PeakIn2DArrRow {

    public static void PrintArr(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("[ " + arr[i] + " " + arr[i + 1] + " ]");
        }
    }

    public static int FindMaxInRow(int arr[][], int m, int row) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < m; i++) {
            if (arr[row][i] > max) {
                max = arr[row][i];
                index = i;
            }

        }
        return index;
    }

    //cols
    public static int[] PeakIn2DArr(int arr[][], int n, int m) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; //mid==row
            int col = FindMaxInRow(arr, m, mid);

            int TopNeighbor = (mid - 1) >= 0 ? arr[mid - 1][col] : -1;
            int BottomNeighbor = (mid + 1) < n ? arr[mid + 1][col] : -1;

            if (arr[mid][col] > TopNeighbor && arr[mid][col] > BottomNeighbor) {
                return new int[]{mid, col};
            } else if (TopNeighbor > arr[mid][col]) {
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
