 public class LetterPermutation {

    // Recursive function to generate all case permutations
    public static void Letter(String output, String input) {

        // Base case: if input is empty → print the built output
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        // Take first character
        char ch = input.charAt(0);
        input = input.substring(1);  // reduce input

        // Always take lowercase version (works for digits too, as they remain same)
        char lowerCase = Character.toLowerCase(ch);
        String op1 = output + lowerCase;
        Letter(op1, input);

        // If it's NOT a digit → also take uppercase version
        if (!Character.isDigit(ch)) {
            char upperCase = Character.toUpperCase(ch);
            String op2 = output + upperCase;
            Letter(op2, input);
        }
    }

    public static void main(String[] args) {
        String input = "a1B2";  // input string with letters + digits
        String output = "";     // start with empty output
        Letter(output, input);  // call recursion
    }
}


// ________Problem: Letter Case Permutation______

// Input string can contain letters (small/capital) and digits.
// For letters → two choices: lowercase OR uppercase.
// For digits → only one choice: keep as it is.
// Goal → Print all possible permutations.

//  Why use (input, output) method?
//  This is a standard recursion pattern (Input–Output method) used for string/array problems:
// Input (remaining work): part of the string we still need to process.
// Output (current work): result we are building step by step.

// At each recursive call → take one character from input, decide its form, and push it into output.

// This makes recursion clean & intuitive:
// input shrinks with each recursive call (smaller problem).
// output grows until base case (solution ready).
// Finally, when input = "", we print output.




// Each node = one recursive call.

// That node has its own copy of parameters (input, output).

// The edges represent decisions/choices (like add lowercase, add uppercase, skip, etc.).

// Leaves (nodes with no children) = base case reached → final answers are printed/returned.

// So yes — 1 recursive call = 1 node in tree.