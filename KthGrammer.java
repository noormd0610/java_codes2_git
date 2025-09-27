 public class KthGrammer {

    // Function to find Kth symbol in Nth row
    public static int GrammerPrint(int n, int k) {

        // 1. Base case: first row or first column is always 0
        if (n == 1 || k == 1) {
            return 0;
        }

        // 2. Find middle of current row
        int mid = (int) Math.pow(2, n - 1) / 2;

        // 3. If k is in first half, it's same as the previous row
        if (k <= mid) {
            return GrammerPrint(n - 1, k);
        } else {
            // 4. If k is in second half, get value from previous row and invert it
            int val = GrammerPrint(n - 1, k - mid);

            // invert 0 → 1 or 1 → 0
            val = (val == 1) ? 0 : 1;
            return val;
        }
    }

    public static void main(String[] args) {
        System.out.println("Answer = " + GrammerPrint(4, 6));
    }
}



// Step 1: Row Lengths

// Row 1: 1 element → [0]

// Row 2: 2 elements → [0, 1]

// Row 3: 4 elements → [0, 1, 1, 0]

// Row 4: 8 elements → [0, 1, 1, 0, 1, 0, 0, 1]
  
// _________ Kth Symbol in Grammar ___________

// Problem Idea

// Each row length = 2^(n-1)

// First half = same as previous row

// Second half = complement of previous row

// Recursive Approach (HIB)

// Base Condition: n=1 or k=1 → return 0

// Hypothesis: assume (n-1) row gives correct value for smaller index

// Induction:

// If k ≤ mid → return value from previous row (GrammerPrint(n-1, k))

// If k > mid → return inverted value from previous row (1 - GrammerPrint(n-1, k-mid))

// Observation / Learning

// Divide & conquer on row halves

// No need to generate the whole row → efficient

// Shows recursion can work on index-level decisions


// ___ Quick Rule___
// mid = 2^(n-1)/2
// if k <= mid → GrammerPrint(n-1, k)
// else → 1 - GrammerPrint(n-1, k-mid)