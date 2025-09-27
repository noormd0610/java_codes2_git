 public class SortArrUsingRecursion {

    // Utility function to print array elements
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Function to sort array using recursion
    public static void sortRecursionArr(int arr[], int n) {

        // 1. Base case: if only 1 element left, it's already sorted
        if (n == 0) { 
            return;
        }

        // 2. Hypothesis: assume first n-1 elements are sorted
        sortRecursionArr(arr, n - 1);
 
        // 3. Induction step: place nth element at correct position
        if (arr[n] < arr[n - 1]) {
            // swap arr[n] and arr[n-1]
            int temp = arr[n];
            arr[n] = arr[n - 1];
            arr[n - 1] = temp;

            // recheck smaller part after swap (backtracking correction)
            sortRecursionArr(arr, n - 1);
        }
     }

    public static void main(String[] args) {
        int arr[] = {9, 10, 2, 87, 4};

        // Call recursive sort on array
        sortRecursionArr(arr, arr.length - 1);

        // Print sorted array
        printArr(arr);
    }
}





 
//______ Sort Array using Recursion (Notes)_________

// Why used?

// To understand how recursion can replace loops.

// Shows how big problems reduce to smaller input automatically.

// How used?

// Apply HIB method:

// Base: when array size = 1, it’s sorted.

// Hypothesis: assume first n-1 elements get sorted.

// Induction: compare last two, swap if needed, and re-sort smaller part.

// What new thing we learn?

// Recursion not only solves math/choice problems but also simulates iterative sorting.

// Idea of backtracking correction → if swap happens, we re-check smaller part.

// Teaches us recursion can mimic bubble sort/selection sort logic.

//  In short: This problem trains us to use HIB thinking for arrays, shows input reduction, and introduces re-invoking recursion after decisions.