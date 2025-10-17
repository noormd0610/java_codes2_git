
import java.util.*;

public class Interleave {

    // Function to print elements of queue
    public static void printQueue(Queue<Integer> res) {
        while (!res.isEmpty()) {
            System.out.print(res.remove() + " ");
        }
    }

    // Function to interleave first and second halves of queue
    public static void Interleave(Queue<Integer> q) {
        int len = q.size() / 2; // find half length

        Queue<Integer> q1 = new LinkedList<>(); // to store first half

        // Step 1: move first half of elements to q1
        while (q.size() != len) {
            q1.add(q.remove());
        }

        // Step 2: interleave one from q1 and one from q (second half)
        while (!q1.isEmpty()) {
            q.add(q1.remove()); // add from first half
            q.add(q.remove());  // add from second half
        }

        // Step 3: print final interleaved queue
        printQueue(q);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // fill queue with numbers 1 to 10
        for (int i = 1; i <= 10; i++) {
            q.add(i);
        }

        // call interleave function
        Interleave(q);
    }
}

// 🧠 Quick Recap
// Step 1: Split queue into two halves.
// Step 2: Alternate elements from first and second halves.
// Step 3: Print interleaved result.

// 🧠 Intuition (Easy Explanation)
// We are given a queue of even length, e.g.
// 1 2 3 4 5 6 7 8 9 10
// We want to interleave the first and second halves like this →
// 1 6 2 7 3 8 4 9 5 10

// So basically:
// Split queue into two halves.
// Then take one element from first half, then one from second half, and repeat.

// ⚙️ Logic Steps
// Find half length → len = q.size() / 2.
// Move first half elements into another queue (q1).
// After this:
// q1 = [1,2,3,4,5]
// q = [6,7,8,9,10]

// Interleave:
// Remove one from q1, add to main queue.
// Remove one from q, add to main queue.
// Continue until q1 is empty.
// Print queue → gives interleaved order.

// 🧾 Example
// Input:
// 1 2 3 4 5 6 7 8 9 10
// Output:
// 1 6 2 7 3 8 4 9 5 10

// ⏱️ Complexity
// Time: O(n)
// Space: O(n/2) → extra queue
