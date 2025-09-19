//Approach 3 – Binary Search (Optimal) Median of Two Sorted Arrays --> striver
public class MedianOfTwoSortedArrayAprch3{

    public static double MedianOfTwoSortedArray(int arr1[], int arr2[]) {

        int n1 = arr1.length;
        int n2 = arr2.length;

        if (n1 > n2) {
             return  MedianOfTwoSortedArray(arr2, arr1);
        }

        int left = 0;
        int right = n1;
        int leftEleReq = (n1 + n2 + 1) / 2;

        while (left <= right) {

            int mid1 = left + (right - left) / 2;
            int mid2 = leftEleReq - mid1;

            int L1 = Integer.MIN_VALUE;
            int L2 = Integer.MIN_VALUE;
            int R1 = Integer.MAX_VALUE;
            int R2 = Integer.MAX_VALUE;

            if (mid1 > 0) {

                L1 = arr1[mid1 - 1];
                 System.out.println("L1= " + L1);
            }
            if (mid1 <n1) {
                R1 = arr1[mid1];
                  System.out.println("R1= " + R1);
            }
            if (mid2 > 0) {
                L2 = arr2[mid2 - 1];
                 System.out.println("L2= " + L2);
            }
            if (mid2 <n2 ) {
                R2 = arr2[mid2];
                System.out.println("R2= " + R2);
            }

            if (L1<R2 && L2 < R1) {
                if ((n1 + n2) % 2 == 0) {
                    //even
                    int val1 = Math.max(L1, L2);
                    int val2 = Math.min(R1, R2);
                    System.out.println(val1+" v1");
                    System.out.println(val2+" v2");

                    return (double) (val1 + val2) / 2;

                } else {
                    //odd
                    return Math.max(L1, L2);
                }
            }
            if (L2 > R1) {
                left = mid1 + 1;
            }
            if (L1 > R2) {
                right = mid1 - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2};
        int arr2[] = {3,4,5,6};
        System.out.println(MedianOfTwoSortedArray(arr1, arr2));
    }
}
