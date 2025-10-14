 public class LinkedListIsCycle {

    // Node class representing each element of the linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static Node slow;
    public static Node fast;

    // ✅ Step 1: Detect if a cycle exists using Floyd’s algorithm
    public static boolean IsCycleDetect() {
        slow = head;
        fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // move 1 step
            fast = fast.next.next;    // move 2 steps
            if (slow == fast) {       // meeting point => cycle found
                return true;
            }
        }
        return false;                 // reached null => no cycle
    }

    // ✅ Step 2: Remove the cycle if found
    public static void removeCycleNode() {
        Node prev = null;

        // Check if cycle exists
        if (IsCycleDetect() == true) {
            // Move slow to head, keep fast at meeting point
            slow = head;

            // Move both 1 step each until they meet at cycle start
            while (slow != fast) {
                slow = slow.next;
                prev = fast;          // keep track of node before fast
                fast = fast.next;
            }

            // 🟢 Case 1: Cycle starts at head (prev never set)
            if (prev == null) {
                // move fast till it points to the last node in cycle
                while (fast.next != head) {
                    fast = fast.next;
                }
                fast.next = null;     // break the cycle
            } 
            // 🟢 Case 2: Normal case
            else {
                prev.next = null;     // unlink cycle connection
            }

            System.out.println("✅ Cycle removed successfully");
        } 
        else {
            System.out.println("No cycle found in Linked List");
        }
    }

    // ✅ Print the linked list nodes
    public static void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
    }

    // ✅ Main method to test the code
    public static void main(String[] args) {
        LinkedListIsCycle ll = new LinkedListIsCycle();

        // Create nodes and link them
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Create a cycle: last node points to head
        head.next.next.next.next = head;

        // Remove the cycle and print list
        removeCycleNode();
        printLL();   // Output: 1 --> 2 --> 3 --> 4 -->
    }
}
