 import java.util.*;

public class FirstNonRepeatChar {

    public static void FirstNonRepeatChar(String str) {

        // Step 1: frequency array to count occurrences of each character
        int freq[] = new int[26];

        // Step 2: queue to maintain the order of characters
        Queue<Character> q = new LinkedList<>();

        // Step 3: process each character in the stream
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // increase frequency count
            freq[ch - 'a']++;

            // add current character to queue
            q.add(ch);

            // remove all characters from front that are repeated
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            // print first non-repeating character or -1 if none
            if (!q.isEmpty()) {
                System.out.print(q.peek() + " ");
            } else {
                System.out.print("-1" + " ");
            }
        }
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        FirstNonRepeatChar(str);
    }
}


// 🧩 Topic: First Non-Repeating Character in a Stream
// 🧠 Intuition
// We process characters one by one.
// At each step → we need to know which character has appeared only once till now.
// 👉 Use Queue (to maintain order) + freq array (to count repeats).
// ⚙️ Logic Steps
// Create a freq[26] array → counts each character.
// Use a queue to store incoming characters.
// For each new character:
// Increase its frequency.
// Add it to queue.
// Remove all repeated chars from front (while freq>1).
// Front of queue = first non-repeating char.
// If queue empty → print -1.
// 🧾 Complexity
// Time: O(n)
// Space: O(26 + n) → freq + queue
 
// 📘 Summary Line:
// “Use a queue to track order and a frequency array to skip repeated characters — front of queue always gives the first non-repeating one.” ✅
