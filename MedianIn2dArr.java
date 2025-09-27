
public record MedianIn2dArr() {

    public static int MediaInARowWise(int arr[], int n, int m) {
        int left = 0;
        int right = m;
        int mid = left + (right - left) / 2;
        if (m % 2 == 0) {
            int res = arr[mid - 1] + arr[mid];

            return res / 2;
        } else {
            return arr[mid];
        }
    }

    public static int MediaInARowWiseSortedMatrix(int arr[][], int n, int m) {
        int MedianResult = 0;
        for (int i = 0; i < n; i++) {
            MedianResult += MediaInARowWise(arr[i], n, m);
        }

        return MedianResult / n;
    }

    public static void main(String[] args) {
        int arr[][] = {
            {1, 5, 7, 9, 11},
            {2, 3, 4, 5, 10},
            {9, 10, 12, 14, 16}
        };
        int n = arr.length;
        int m = arr[0].length;
        System.out.println(MediaInARowWiseSortedMatrix(arr, n, m));
    }
}
