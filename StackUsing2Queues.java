 import java.util.*;

public class StackUsing2Queues {

    public static class Stack {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // push element into stack
        public void add(int data) {
            // add element into non-empty queue
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // pop element from stack (O(n))
        public int remove() {
            int top = -1;

            // case 1: q1 has elements
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove(); // remove element from q1

                    if (q1.isEmpty()) {
                        // last element is the top of stack
                        break;
                    }
                    // move other elements to q2
                    q2.add(top);
                }

            } else { // case 2: q2 has elements
                while (!q2.isEmpty()) {
                    top = q2.remove();

                    if (q2.isEmpty()) {
                        // last element is the top of stack
                        break;
                    }
                    // move other elements to q1
                    q1.add(top);
                }
            }
            return top; // return popped element
        }

        // peek top element without removing it
        public int peek() {
            int top = -1;

            // case 1: q1 has elements
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top); // reinsert element into q2
                }

            } else { // case 2: q2 has elements
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top); // reinsert element into q1
                }
            }
            return top; // top element of stack
        }

        // check if both queues are empty
        public boolean IsEmptyBoth() {
            if (q1.isEmpty() && q2.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
         
    }
}


//  🧠 Stack Using 2 Queues — (Pop O(n) version)
// Push (add) → Just insert into the non-empty queue. → O(1)
// Pop (remove) → Move all elements except the last one to the other queue; last one = top → O(n)
// Peek → Same as pop, but reinsert the last element → O(n)
// Empty check → Both queues empty → true
// 🧾 Idea:
// Use two queues.
// Keep pushing normally, but during pop — shift elements to get the last pushed element.

// ✅ You implemented: Pop O(n) version.
