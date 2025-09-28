 public class PermutationWithCaseChange {

    // Recursive function to generate permutations with case change
    public static void PermutationCase(String input, String output) {
        
        // 1. Base case: when no characters are left in input
        if (input.length() == 0) {
            System.out.println(output); // print the completed string
            return;
        }

        // 2. Take the first character from input
        char ch = input.charAt(0);
        input = input.substring(1); // reduce input → smaller problem

        // Prepare two versions of output (choice 1 = lowercase, choice 2 = uppercase)
        String op1 = output;
        String op2 = output;

        // Choice 1 → add lowercase character
        op1 = op1 + ch;
        PermutationCase(input, op1);

        // Choice 2 → add uppercase character
        char uppercase = Character.toUpperCase(ch);
        op2 = op2 + uppercase;
        PermutationCase(input, op2);
    }

    public static void main(String[] args) {
        String input = "abc";   // input string (all lowercase)
        String output = "";     // initially empty output

        // Call the recursive function
        PermutationCase(input, output);
    }
}


//_______________Permutation with Case Change (Notes)__________________

// Why Input–Output method (tree)?
// Each character has 2 choices → keep it lowercase OR convert to uppercase.
// That branching (choice + decision) naturally forms a recursion tree → covers all possibilities.

// How used?
// 1.Base Case: when input is empty → print the built output.
// 2.Recursive Step:
// Include char as lowercase → output + ch.
// Include char as uppercase → output + Character.toUpperCase(ch).

// Learning:
// Problems with binary options per character → perfect for recursion tree.
// Shows how recursion handles formatting/transform problems beyond numbers.