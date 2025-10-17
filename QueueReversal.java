
import java.util.*;

public class QueueReversal {

// ______ using recursion_______
    public static void QueueReversalUsingRecursion(Queue<Integer> q) {
        //base
        if (q.isEmpty()) {
            return;
        }

        //i
        int val = q.remove();

        //h
        QueueReversalUsingRecursion(q);

        System.out.println(val);
    }

    //using stack
    public static void QueueReversalUsingStack(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        //queue to stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        //print stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            q.add(i);
        }
        //QueueReversalUsingRecursion(q);
        QueueReversalUsingStack(q);
    }
}

// 1️⃣ Using Recursion (QueueReversalUsingRecursion)
// Idea:
// Recursion works like a stack naturally.
// Remove the front element, reverse the rest of the queue, then process the removed element afterwards.

// Step-by-step:
// Remove the first element (val).
// Call the function again on the remaining queue.
// When the recursion reaches the end (queue is empty), start printing elements from last removed to first removed.
// ✅ Result: Queue elements printed in reverse order.

// 2️⃣ Using Stack (QueueReversalUsingStack)
// Idea:
// A stack is Last-In-First-Out (LIFO), perfect for reversing.
// Step-by-step:
// Remove elements from the queue and push them into a stack.
// Pop elements from the stack and print (or put back in queue).
// ✅ Result: Elements come out in reverse because stack reverses the order.
 
