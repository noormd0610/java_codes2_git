
public class BalanceParenthasis {

    public static void BalanceParenthasis(int open, int close, String output) {

        //base case
        if (open == 0 && close == 0) {
            System.out.println(output);
            return;
        }

        if (open > 0) {
            String op1 = output + "("; //open
            BalanceParenthasis(open - 1, close, op1);
            
        }

        if (close > open) {
            String op2 = output + ")";  //close
            BalanceParenthasis(open, close - 1, op2);
        }

    }

    public static void main(String[] args) {
        int n = 2;
        int open = n;
        int close = n;
        String output = "";
        BalanceParenthasis(open, close, output);
    }
}



//______Balanced Parentheses (Recursion + Input/Output Method)_____

// Problem Idea
// Given n, generate all valid combinations of n pairs of parentheses.
// Example: n = 2 → "(())" , "()()".

// Why Input/Output (Tree) Method?
// In each recursive call, input = remaining counts (open, close), **output = string built so far`.
// The problem is not just smaller (like HIB), but also requires exploring multiple branching choices at each step → naturally fits input/output tree.

// Core Rules
// Base case → when open == 0 && close == 0, we have a complete valid string → print/store it.
// Choice of ( (open bracket) → allowed if open > 0.
// Choice of ) (close bracket) → allowed only if close > open (to maintain balance).
// Sometimes only one choice is valid (e.g., at start we can’t close).

// Extended Input/Output Method
// Input = (open, close) counters (remaining brackets).
// Output = current string being built.
// Each recursive call = one node in tree → either add ( or ) if valid.

// Key Learning
// Observation is critical:
// If we take ) when close == open, string becomes invalid.
// If open > 0, we must always try placing (.
// Recursion tree ensures all valid paths explored.
// Classic use of constraints inside recursion.
// ✅ That’s why this problem is a good extended input/output method application → because rules depend on dynamic counters (open, close) rather than just input characters.