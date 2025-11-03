//for opeartions we make methods instead of writing code in main method

public class LinkedList {

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
    public static int size;

    //Add First Node In LL
    public static void AddFirstNode(int data) {
        //1.create node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //2. new node next put head connection
        newNode.next = head;
        //3.move head to news node
        head = newNode;
    }

    //Add Last Node In LL
    public static void AddLastNode(int data) {
        //1.create a new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //2.assign tail.next =newenode
        tail.next = newNode;
        //3.assign tail to newq node
        tail = newNode;
    }

//print LL
// How it works
// Start from head.
// Print each node’s data.
// Move to next until null.
// Stop when list ends.
//In short:
// printList() traverses from head → next → ... → null
// printing all node data in order.
    public static void printLL() {

        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

//AddInTheMiddle =
// How it works
// 1.Traverse until the node just before the desired position.
// 2.Set newNode.next = temp.next.
// 3.Then temp.next = newNode.
//This links the new node between two existing nodes.
    public static void AddInTheMiddle(int Idx, int data) {

        if (Idx == 0) {
            AddFirstNode(data);
            return;
        }
        //find prev node
        Node temp = head;
        int i = 0;
        while (i != Idx - 1) {
            temp = temp.next;
            i++;
        }

        Node newNode = new Node(data);
        size++;
        newNode.next = temp.next;
        temp.next = newNode;
    }

//remove firstnode =
//  Goal: Delete the first node (the head) from the linked list.
//  1.moves the head pointer to the next node.
//   The old first node is no longer referenced — Java’s Garbage Collector automatically removes it.
    public static int removeFirstNode() {
        if (size == 0) {                     // if list empty
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {                // if only one node
            int val = head.data;
            head = tail = null;              // remove only node
            size = 0;
            return val;
        }

        int val = head.data;                 // store value to return
        head = head.next;                    // move head → next node
        size--;                              // reduce size
        return val;                          // return deleted data
    }

//removeNodeLast =
//The for loop stops at second-last node (size - 2).
//Then we do:
// prev.next = null; → cuts the link to last node.
// tail = prev; → makes new tail.
// Old last node loses reference → Garbage Collector deletes it.
    public static int removeNodeLast() {

        if (size == 0) {
            System.out.println("LL Is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            head = tail = null;
            return 0;
        }
        Node prev = head;

        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        size--;
        tail = prev;
        return val;
    }

// How it works =
// Start from head.
// Compare each node’s data with target.
// If match → return index.
// If reached end → return -1 (not found).
    public static int itarativeSearch(int target) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data == target) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

// 4 Steps (Easy to Remember) =
// Store next node → next = curr.next
// Reverse link → curr.next = prev
// Move prev forward → prev = curr
// Move curr forward → curr = next
    public static void reverseLinkedList() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            // 1️⃣ Save next node
            next = curr.next;

            // 2️⃣ Reverse link
            curr.next = prev;

            // 3️⃣ Move prev ahead
            prev = curr;

            // 4️⃣ Move curr ahead
            curr = next;
        }
        head = prev;  // new head is the last node
    }

//🔹 Purpose: Find index of a target element using recursion.
    public static int recursiveSearch(int idx, int target, Node temp) {
        // Base case
        if (temp == null) {
            return -1;          // not found
        }
        if (temp.data == target) {
            return idx;  // found
        }
        // Induction step
        return recursiveSearch(idx + 1, target, temp.next);
    }

//____removeNthNodeFromEnd____
//  Count total nodes (size).
// If n == size, remove the head.
// Otherwise, find the (size - n)th node → that’s the previous node.
// Connect prev.next = prev.next.next to skip the nth node.
// To find  node from start = size - n + 1
// To remove → need previous node → (size - n)
    public static void removeNthNodeFromEnd(int n) {
        // 1️⃣ Find size
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // 2️⃣ If we need to remove head
        if (size == n) {
            head = head.next;
            return;
        }

        // 3️⃣ Find (size - n)th node from start → prev node
        int i = 1;
        int iToFind = size - n;
        Node prev = head;

        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        // 4️⃣ Remove nth node
        prev.next = prev.next.next; // skip the nth node
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // printLL();
        ll.AddFirstNode(1);
        ll.AddFirstNode(2);
        ll.AddLastNode(8);
        ll.AddLastNode(39);
    //ll.removeNthNodeFromEnd(2);
        //print LL
        printLL();


    }
}
