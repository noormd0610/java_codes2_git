 public class PermutationsWithSpaces {

    // Recursive function to generate all permutations of a string with spaces in between characters
    public static void PermutationsWithSpaces(String output, String input) {
        
        // 1. Base case: when input becomes empty, we have formed a valid permutation
        if (input.length() == 0) {
            System.out.println(output); // print the final output string
            return;
        }

        // Take the first character from input
        char ch = input.charAt(0);
        input = input.substring(1); // reduce input (smaller problem)

        // 2. Choice 1 → Add character without space
        PermutationsWithSpaces(output + ch, input);

        // 3. Choice 2 → Add character with space before it
        String output2 = output + "_" + ch;
        PermutationsWithSpaces(output2, input);

        return; // optional, makes flow clearer
    }

    public static void main(String[] args) {    
        String input = "abc";

        // Initialize output with the first character (to avoid leading space issue)
        String output = "";
        char ch = input.charAt(0);
        output = output + ch;

        // Reduce input (remove the first character already placed in output)
        input = input.substring(1);

        // Start recursion
        PermutationsWithSpaces(output, input);
    }
}




// ___________ Permutation with Spaces (Notes)___________________

// Why used (Tree – Input/Output method)?
// Problem asks for all possible forms (choices at each step → with space / without space).
// That’s a combinatorial problem, so recursion tree (choice + decision) is the natural fit.

// How used?
// Start: put first character in output (no leading space allowed).
// Recursive choices for each next character:
// Append with space → output + "_" + ch
// Append without space → output + ch
// Base case: when input becomes empty → print output.

// Example: Input "ab"
// Start: "a"
// Choices for "b":
//    "ab"
//    "a_b"


// Learning:
// Subset-style branching works for string formatting too.
// Always fix the first element to avoid unwanted space at edges.