 public class TowerHonai {

    // Recursive function to move 'n' disks from Source(S) to Destination(D) using Helper(H)
    public static void tower(int n, String S, String H, String D) {

        // 1. Base case: if only 1 disk, move it directly from Source to Destination
        if (n == 1) {
            System.out.println(S + " TO " + D);
            return;
        }

        // 2. Hypothesis: move top n-1 disks from Source to Helper using Destination as temporary
        tower(n - 1, S, D, H);

        // 3. Move the nth (largest) disk from Source to Destination
        System.out.println(S + " TO " + D);

        // 4. Move n-1 disks from Helper to Destination using Source as temporary
        tower(n - 1, H, S, D);
    }

    public static void main(String[] args) {
        int n = 2; // number of disks
        String S = "SOURCE";
        String H = "HELPER";
        String D = "DESTINATION";

        // Call the recursive function
        tower(3, S, H, D);
    }
}


// ____ Tower of Hanoi – Recursion (HIB)_______

// Problem Idea: Move n disks from Source (S) → Destination (D) using Helper (H).

// HIB Approach:

// Base Case: n=1 → move disk directly S → D.

// Hypothesis: assume n-1 disks can be moved correctly.

// Induction / Steps:

// Move n-1 disks S → H (using D as helper)

// Move the largest disk S → D

// Move n-1 disks H → D (using S as helper)

// Key Learning:

// Recursion reduces the problem to smaller input (n-1).

// Only need to think of n-1 disks, last disk movement is obvious.

// Elegant HIB application: solve smaller first → combine for full solution.