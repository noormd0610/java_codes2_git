
import java.util.*;

public class QueueUsing2Stacks {

    public static class Queues {

        // Two stacks to implement queue
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // Check if queue is empty
        public boolean isEmpty() {
            return s1.isEmpty();
        }

        // Add element to queue (enqueue)
        public void add(int data) {

            // If first element, push directly
            if (isEmpty()) {
                s1.push(data);
                return;
            }

            // Step 1: Move all elements from s1 → s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            // Step 2: Push new data to s1
            s1.push(data);

            // Step 3: Move all elements back from s2 → s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // Remove element from queue (dequeue)
        public int remove() {
            if (isEmpty()) {
                System.out.println("no elements");
                return -1;
            }
            return s1.pop();
        }

        // Return front element of queue
        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return s1.peek();
        }

        // Print all elements of queue
        public void printStack() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            while (!isEmpty()) {
                System.out.print(s1.pop() + " ");
            }
        }
    }

    public static void main(String[] args) {
        Queues q = new Queues();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.printStack(); // Output: 1 2 3 4 5 6
    }
}

// Short Summary:

// s1 always keeps the front element on top (queue order).
// To do that, every time we add a new element, we:
// Move all elements from s1 to s2
// Push new data to s1
// Move all back from s2 to s1
// remove() and peek() act directly on s1 (front is on top).
