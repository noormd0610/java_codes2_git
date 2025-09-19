 //same concept here used median of two sorted arr conceept here, in median we syemmtry(split) middle , here we split left part k ele in that we choose max 
//,because kth ele is max of that particular part 

public class KthEle {

    public static int KthEle(int arr1[], int arr2[], int k) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        if (n1 > n2) {
            return KthEle(arr2, arr1, k);
        }

        int left =Math.max(0,k-n2);
        int right = Math.min(k, n1);
        int leftElesReq = k;

        while (left <= right) {
            //mid
            int mid1 = left + (right - left) / 2;
            int mid2 = leftElesReq - mid1;

            int L1 = Integer.MIN_VALUE;
            int L2 = Integer.MIN_VALUE;
            int R1 = Integer.MAX_VALUE;
            int R2 = Integer.MAX_VALUE;

            if (mid1 > 0) {
                L1 = arr1[mid1 - 1];
                  //System.out.println("L1 = "+L1);
            }
            if (mid2 > 0) {
                L2 = arr2[mid2 - 1];
                 // System.out.println("L2 = "+L2);
            }
            if (mid1 < n1) {
                R1 = arr1[mid1];
            }
            if (mid2 < n2) {
                R2 = arr2[mid2];
            }

            if (L1 <=R2 && L2 <= R1) {
                // System.out.println("L1 = "+L1);
                // System.out.println("L2 = "+L2);
                return Math.max(L1, L2);
            }

            if (L1 > R2) {
                right = mid1 - 1;
            }
            if (L2 > R1) {
                left = mid1 + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int k = 8;
        System.out.println(KthEle(arr1, arr2, k));
    }
}
