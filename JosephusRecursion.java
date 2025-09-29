 import java.util.*;

public class JosephusRecursion {

    public static void JosephusRecursion(List<Integer> ArrList, int k, int currIdx, int n) {
        // base case → only one person left (the survivor)
        if (ArrList.size() == 1) {
            System.out.println(ArrList.get(0));  // print the survivor
            return;
        }

        // find the index of the person to eliminate
        currIdx = (currIdx + k) % n;

        // remove that person from the list
        ArrList.remove(currIdx);

        // recursive call on the reduced circle
        JosephusRecursion(ArrList, k, currIdx, ArrList.size());
    }

    public static void main(String[] args) {
        int n = 5;  // total people in the circle
        int k = 3;  // every k-th person will be killed

        // create the list of people (1 to n)
        List<Integer> ArrList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ArrList.add(i);
        }

        // start recursion: k-1 because we count from index 0
        JosephusRecursion(ArrList, k - 1, 0, ArrList.size());
    }
}


// Problem Statement (Josephus Problem)

// A gang is hiding in a cave.
// Enemies will find and kill them anyway, so they decide to kill each other in turns until only 1 survivor remains, who will then commit suicide.
// Rule: starting from the first member, kill every k-th person, then continue counting from the next member.
// Repeat until only one person is left.
// Recursive Idea (Input–Output style)

// Input Parameters:
// ArrList → list of alive members.
// k → step count (kill k-th person).
// currIdx → current position.
// n → number of alive members.

// Base Case:
// If only 1 member remains → print survivor.

// Recursive Step:
// Find the index of the k-th person:
// currIdx = (currIdx + k) % n;


// Remove that member.
// Call recursion again with updated list and size.

// Example (n=5, k=3)
// Gang members: [1, 2, 3, 4, 5]
// Start from 1 → kill 3 → [1, 2, 4, 5]
// Next start from 4 → kill 1 → [2, 4, 5]
// Next start from 2 → kill 5 → [2, 4]
// Next start from 2 → kill 2 → [4]

// Survivor = 4.

// 👉 So Josephus Problem = “last survivor after killing every k-th member in a circle”.

//IMPORTANT:
// In this Josephus Problem:
// We are not exploring multiple branches (like subsets/powersets).
// At each step → only one fixed choice (kill the k-th person, continue).
// So recursion here is linear recursion (single chain), not a branching recursion tree.
// 👉 That’s why we don’t use HIB or tree here — just keep reducing the list until one survives.