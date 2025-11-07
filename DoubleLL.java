
public class DoubleLL {

    // Node class for doubly linked list
    public static class Node {

        int data;       // store node value
        Node prev;      // pointer to previous node
        Node next;      // pointer to next node

        Node(int data) { // constructor to create a new node
            this.data = data;
            this.prev = null; // initially no previous node
            this.next = null; // initially no next node
        }
    }

    public static Node head; // points to first node
    public static Node tail; // points to last node
    public static int size;  // tracks number of nodes in the list

    // Add node at the beginning of the list
    public static void AddFirst(int data) {
        Node newNode = new Node(data); // create new node
        size++;                        // increment size

        if (head == null) {            // if list is empty
            head = tail = newNode;     // head & tail both point to new node
            return;
        }

        newNode.next = head;           // link new node's next to current head
        head.prev = newNode;           // link current head's prev to new node
        head = newNode;                // update head to new node
    }

    // Add node at the end of the list
    public static void AddLast(int data) {
        Node newNode = new Node(data); // create new node
        size++;                        // increment size

        if (head == null) {            // if list is empty
            head = tail = newNode;
            return;
        }

        newNode.prev = tail;           // link new node's prev to current tail
        tail.next = newNode;           // link current tail's next to new node
        tail = newNode;                // update tail to new node
    }

    // Remove node from the beginning of the list
    public static int RemoveFirst() {
        if (head == null) {            // empty list
            return Integer.MIN_VALUE;  // indicate failure
        } else if (size == 1) {        // only one node
            head = tail = null;        // list becomes empty
            size = 0;
            return 0;                  // return dummy value
        }

        int val = head.data;           // store value to return
        head = head.next;              // move head forward
        head.prev = null;              // remove backward link
        size--;                        // decrement size
        return val;
    }

    // Remove node from the end of the list
    public static int RemoveLast() {
        if (head == null) {            // empty list
            return Integer.MIN_VALUE;
        } else if (size == 1) {        // only one node
            head = tail = null;        // list becomes empty
            size = 0;
            return 0;
        }

        int val = tail.data;           // store value to return
        tail = tail.prev;              // move tail backward
        tail.next = null;              // remove forward link
        size--;                        // decrement size
        return val;
    }

    // Print doubly linked list in normal order
    public static void PrintLL() {
        Node temp = head;
        System.out.print("null ");     // represent start of list
        while (temp != null) {
            System.out.print(temp.data + " <--> "); // print node
            temp = temp.next;         // move to next node
        }
        System.out.print("null");      // represent end of list
    }

    // Reverse the doubly linked list
    public static void ReverseLL() {
        Node prev = null;              // previous node pointer
        Node curr = head;              // current node pointer
        Node next;

        while (curr != null) {         // traverse entire list
            next = curr.next;          // store next node

            curr.next = prev;          // reverse next pointer
            curr.prev = next;          // reverse prev pointer (key for doubly linked list)

            prev = curr;               // move prev forward
            curr = next;               // move curr forward
        }

        head = prev;                   // update head to new first node
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.AddLast(1);                // add nodes
        dll.AddLast(2);
        dll.AddLast(3);
        dll.AddLast(4);
        dll.AddLast(5);

        System.out.println(" normal");
        dll.PrintLL();                 // print list in normal order
        System.out.println();

        System.out.println("reverse");
        dll.ReverseLL();               // reverse the list
        dll.PrintLL();                 // print reversed list
    }
}

// ___Revision Notes (Quick, Easy to Remember)___

// Doubly Linked List
// Mutable → Can add, remove, update nodes.
// Each node has:
// data → stores value
// next → points to next node
// prev → points to previous node

// Operations
// AddFirst(data) → Insert at head
// AddLast(data) → Insert at tail
// RemoveFirst() → Delete head node
// RemoveLast() → Delete tail node
// PrintLL() → Traverse list forward
// ReverseLL() → Swap next and prev of each node


// Time Complexity
// Add/Remove at ends → O(1)
// Traversal → O(n)

// Space Complexity
// O(1) (no extra memory except pointers)


// _______Reverse Doubly Linked List _______

// Concept
// Reversing a doubly linked list means flipping the order of nodes:
// head becomes tail
// tail becomes head
// All next and prev pointers are swapped

// Steps to Reverse =

// Initialize pointers:
// prev = null → will track previous node
// curr = head → start from first node

// Traverse list:
// Save next node: next = curr.next

// Swap pointers:
// curr.next = prev
// curr.prev = next (important for doubly list)

// Move forward:
// prev = curr
// curr = next

// Update head:
// head = prev → new first node

// Key Points
// Must swap both next and prev for each node.
// Works in-place → no extra memory needed.

// After reversal:
// Previous head points prev = null and becomes tail.
// Previous tail becomes head.

// Time & Space Complexity
// Time: O(n) → traverse all nodes once
// Space: O(1) → in-place reversal, no extra space

// Example
// Original:
// null <-> 1 <-> 2 <-> 3 <-> null

// After reverse:
// null <-> 3 <-> 2 <-> 1 <-> null