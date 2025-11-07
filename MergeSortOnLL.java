
public class MergeSortOnLL {

    // Node class represents each element in the linked list
    public static class Node {

        int data;
        Node next;

        Node(int data) {        // Constructor to initialize node data
            this.data = data;
            this.next = null;
        }
    }

    public Node head;  // Points to the first node
    public Node tail;  // Points to the last node
    public int size;   // Keeps track of list size

    // Function to add a new node at the end of the linked list
    public void AddLastNode(int data) {
        Node newNode = new Node(data); // Step 1: Create new node
        size++;

        if (head == null) {           // Step 2: If list is empty
            head = tail = newNode;
            return;
        }

        tail.next = newNode;          // Step 3: Link new node to end
        tail = newNode;               // Step 4: Update tail pointer
    }

    // Function to print all nodes of linked list
    public void printLL(Node head) {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");  // Print current node data
            temp = temp.next;                   // Move to next node
        }
        System.out.println();
    }

    // Function to find middle node (using slow-fast pointer approach)
    public Node MidNode(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;          // moves 1 step
            fast = fast.next.next;     // moves 2 steps
        }
        return slow; // slow will point to mid node
    }

    // Function to merge two sorted linked lists into a single sorted list
    public Node mergeTwoSortedLinkedList(Node head1, Node head2) {
        Node t1 = head1;
        Node t2 = head2;
        Node dummy = new Node(-1);     // Dummy node for easy merging
        Node temp = dummy;             // Temp pointer to build result

        // Compare nodes and attach smaller ones to merged list
        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                temp.next = t1;        // attach smaller node
                t1 = t1.next;
            } else {
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;          // Move temp forward
        }

        // Attach remaining nodes
        if (t1 != null) {
            temp.next = t1;
        }
        if (t2 != null) {
            temp.next = t2;
        }

        return dummy.next; // Return merged list (excluding dummy)
    }

    // Function to apply Merge Sort on Linked List
    public Node MergeSortOnLL(Node head) {
        // Base Case: single node (already sorted)
        if (head.next == null) {
            return head;
        }

        // Step 1: Divide - Find mid node
        Node midNode = MidNode(head);
        Node leftNode = head;
        Node rightNode = midNode.next;
        midNode.next = null;  // Break the list into two halves

        // Step 2: Recursively sort both halves
        leftNode = MergeSortOnLL(leftNode);
        rightNode = MergeSortOnLL(rightNode);

        // Step 3: Merge the sorted halves
        return mergeTwoSortedLinkedList(leftNode, rightNode);
    }

    // Driver Code
    public static void main(String[] args) {
        MergeSortOnLL list = new MergeSortOnLL();
        list.AddLastNode(8);
        list.AddLastNode(2);
        list.AddLastNode(9);
        list.AddLastNode(7);

        System.out.println("BEFORE SORTED = ");
        list.printLL(list.head);

        Node SortedHead = list.MergeSortOnLL(list.head);

        System.out.println("AFTER SORTED = ");
        list.printLL(SortedHead);
    }
}

// 🔹 1-Line Concept
// Divide → Sort → Merge → Result in ascending order.

// 🔹 Algorithm Type
// Divide and Conquer (recursively splits list into halves).
// Works well with Linked Lists (unlike arrays, no shifting required).

// 🔹 Steps
// Find Mid Node → Split list into 2 halves.
// (Use slow-fast pointer method.)
// Recursive Sort → Sort left and right halves.

// Merge → Combine both sorted halves into one sorted list.
// 🔹 Why Merge Sort suits Linked List
// No random access needed (works with sequential access).

// Efficient merging using pointers (no extra space for rearranging nodes).

// 🔹 Time Complexity
// O(n log n) — for all cases (best, average, worst).
// 🔹 Space Complexity
// O(log n) — for recursion stack.

// 🔹 Base Case
// If only one node (or empty), return as it’s already sorted.

// 🔹 Final Output
// A new sorted linked list (ascending order).
