 // Program to merge two sorted linked lists into a single sorted linked list
public class mergeTwoSortedLList {

    // Node class to represent each element in the linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head; // points to the first node
    public Node tail; // points to the last node
    public int size;  // keeps track of number of nodes

    // Function to add a new node at the end of the list
    public void AddLast(int data) {
        Node newNode = new Node(data); // Step 1: create a new node
        size++;

        // Step 2: if list is empty, both head and tail point to new node
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Step 3: connect the old tail to the new node
        tail.next = newNode;

        // Step 4: make the new node the new tail
        tail = newNode;
    }

    // Function to print a linked list
    public void printLL(Node head) {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " "); // print current node data
            temp = temp.next; // move to next node
        }
        System.out.println();
    }

    // Function to merge two sorted linked lists
    public Node mergeTwoSortedLinkedList(Node head1, Node head2) {
        Node t1 = head1;                // pointer for first list
        Node t2 = head2;                // pointer for second list
        Node dummy = new Node(-1);      // dummy node to start merged list
        Node temp = dummy;              // temp pointer to build the new list

        // Step 1: compare both lists until one becomes null
        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {    // pick smaller element
                temp.next = t1;         // attach t1 node to result
                t1 = t1.next;           // move pointer in list1
            } else {
                temp.next = t2;         // attach t2 node to result
                t2 = t2.next;           // move pointer in list2
            }
            temp = temp.next;           // move temp forward
        }

        // Step 2: attach remaining nodes (if any)
        if (t1 != null) temp.next = t1; // if list1 still has elements
        if (t2 != null) temp.next = t2; // if list2 still has elements

        // Step 3: return the merged list (skipping dummy node)
        return dummy.next;
    }

    public static void main(String[] args) {
        // Step 1: create first sorted linked list
        mergeTwoSortedLList list1 = new mergeTwoSortedLList();
        list1.AddLast(1);
        list1.AddLast(3);
        list1.AddLast(5);
        list1.AddLast(7);
        list1.AddLast(9);

        // Step 2: create second sorted linked list
        mergeTwoSortedLList list2 = new mergeTwoSortedLList();
        list2.AddLast(2);
        list2.AddLast(4);
        list2.AddLast(6);
        list2.AddLast(8);
        list2.AddLast(10);

        // Step 3: call merge function and print merged result
        mergeTwoSortedLList merge = new mergeTwoSortedLList();
        Node mergedHead = merge.mergeTwoSortedLinkedList(list1.head, list2.head);
        merge.printLL(mergedHead);
    }
}



//______ Summary Notes — Steps to Solve “Merge Two Sorted Linked Lists_____

// Step 1:
// Create two linked lists (list1 and list2), both already sorted in ascending order.

// Step 2:
// Take two pointers:
// t1 → pointing to list1.head
// t2 → pointing to list2.head

// Step 3:
// Create a dummy node to start building the merged list.
// Use another pointer temp which helps to attach nodes one by one.

// Step 4:
// Compare t1.data and t2.data:
// If t1.data < t2.data, attach t1 to temp.next and move t1 to the next node.
// Else, attach t2 to temp.next and move t2 to the next node.
// Then move temp forward to the new node you just added.

// Step 5:
// When one list ends (becomes null), attach the remaining nodes of the other list directly.

// Step 6:
// Return dummy.next (the real head of the merged list).
// Finally, print the merged list using a print function.