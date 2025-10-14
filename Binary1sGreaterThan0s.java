 public class Binary1sGreaterThan0s {

    // Recursive function to generate N-bit binary numbers
    // where 1's >= 0's in every prefix
    public static void Binary1sGreaterThan0s(int Ones, int Zeros, String output, int n) {

        // Base case: no more bits left to place
        if (n == 0) {
            System.out.println(output); // print the valid binary string
            return;
        }

        // Choice 1: always place '1' (safe for prefix rule)
        String op1 = output + "1"; 
        Binary1sGreaterThan0s(Ones + 1, Zeros, op1, n - 1);

        // Choice 2: place '0' only if ones > zeros (prefix still valid)
        if (Ones > Zeros) {
            String op2 = output + "0"; 
            Binary1sGreaterThan0s(Ones, Zeros + 1, op2, n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 2;           // total number of bits
        int Ones = 0;        // number of 1's placed so far
        int Zeros = 0;       // number of 0's placed so far
        String output = "";  // current binary string being built

        Binary1sGreaterThan0s(Ones, Zeros, output, n); // start recursion
    }
}


//_____________ N-bit Binary Numbers with 1’s ≥ 0’s in Every Prefix_________

// Problem Idea (PS)
// Generate all N-bit binary numbers such that in any prefix, the number of 1s is greater than or equal to the number of 0s.
// Prefix rule: for a number like 110, every prefix (1, 11, 110) must satisfy 1s ≥ 0s.

// Why start with 1?
// Putting 0 first violates the prefix rule immediately → invalid.
// So the first bit is always 1.

// Recursive Approach (Input–Output Method)
// Parameters:
// Ones → number of 1s placed so far.
// Zeros → number of 0s placed so far.
// output → binary string being built.
// n → number of bits left to place.

// Base Case:
// n == 0 → all bits placed → print output.

// Recursive Step:
// Place 1 → always allowed → Ones + 1.
// Place 0 → allowed only if Ones > Zeros → ensures prefix condition holds.

// Key Learning
// Observation trick: first bit must be 1 to satisfy prefix rule.
// Each node = one recursive call in recursion tree.
// Output-sensitive recursion → generates only valid strings, skipping invalid paths efficiently.

// Example Test Cases

// Case 1: N = 2
// Output:
// 11
// 10