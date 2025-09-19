 
//Two Pointers (Merge Process without Extra Array) Median of Two Sorted Arrays --> striver
public class MedianOfTwoSortedArrayAprch2 {

    public static double MedianOfTwoSortedArrays(int arr1[], int arr2[]) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1 + n2;
        int idx1 = n / 2 - 1;
        int idx2 = n / 2;
        int idx1Ele = -1;
        int idx2Ele = -1;
        int count = 0;
        //left arr1 pointer
        int i = 0;
        //right arr2 pointer
        int j = 0;

        while (i < n1 && j < n2) {

            if (arr1[i] < arr2[j]) {
                if (count == idx1) {
                    idx1Ele = arr1[i];
                }
                if (count == idx2) {
                    idx2Ele = arr1[i];
                }
                count++;
                i++;
            } else {
                if (count == idx1) {
                    idx1Ele = arr2[j];
                }
                if (count == idx2) {
                    idx2Ele = arr2[j];
                }
                count++;
                j++;
            }
        }
        //remaing left arr1 ele
        while (i < n1) {
            if (count == idx1) {
                idx1Ele = arr1[i];
            }
            if (count == idx2) {
                idx2Ele = arr1[i];
            }
            count++;
            i++;
        }
        //right arr2 remaining ele 
        while (j < n2) {
            if (count == idx1) {
                idx1Ele = arr2[j];
            }
            if (count == idx2) {
                idx2Ele = arr2[j];
            }
            count++;
            j++;
        }
        if (n % 2 == 0) {
            //even 
            System.out.println("idx1=" + idx1Ele);
            System.out.println("idx2=" + idx2Ele);

            return  (idx1Ele + idx2Ele)/2.0;
        } else {
            return idx2Ele;
        }
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2};
        int arr2[] = {3, 4, 5, 6};

        System.out.println(MedianOfTwoSortedArrays(arr1, arr2));
    }
}
