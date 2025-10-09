 //⚙️ Concepts Covered:
// 1️⃣ Slow & Fast Pointer → to find middle node
// 2️⃣ Reverse Half Linked List → from mid to end
// 3️⃣ Compare → first half and reversed second half

public class LinkedListPalondrome {

    // Node class to represent each element in the linked list
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
    public int size;

    // 🟢 Add node at the beginning
    public static void AddFirst(int data) {
        Node newNode = new Node(data);

        // if list empty → newNode becomes head & tail
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // link new node to current head
        newNode.next = head;

        // move head to new node
        head = newNode;
    }

    // 🟢 Add node at the end
    public static void AddLast(int data) {
        Node newNode = new Node(data);

        // if list empty → newNode becomes head & tail
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // move temp till last node
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // link last node to new node
        temp.next = newNode;
        tail = newNode;
    }

    // 🟢 Print linked list
    public static void printLL() {
        if (head == null) {
            System.out.println("LL IS EMPTY");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // 🟢 Find middle node using slow & fast pointer
    public static Node MidNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // moves 1 step
            fast = fast.next.next;   // moves 2 steps
        }
        return slow; // slow = middle node
    }

    // 🟢 Check if Linked List is Palindrome
    public static boolean LLPalondrome() {
        // 1️⃣ Find middle node
        Node midNode = MidNode(head);

        // 2️⃣ Reverse second half of LL (from mid to end)
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;    // store next
            curr.next = prev;    // reverse link
            prev = curr;         // move prev forward
            curr = next;         // move curr forward
        }

        // 'prev' now points to head of reversed half
        Node right = prev;
        Node left = head;

        // 3️⃣ Compare both halves
        while (right != null) {
            if (left.data != right.data) {
                return false; // mismatch → not palindrome
            }
            left = left.next;
            right = right.next;
        }
        return true; // all matched → palindrome
    }
 

    public static void main(String[] args) {
        LinkedListPalondrome ll = new LinkedListPalondrome();
        ll.AddLast(1);
        ll.AddLast(8);
        ll.AddLast(2);
        ll.AddLast(1);

        printLL();

        // Print mid node value
        int val = MidNode(head).data;
        System.out.println("Mid Node: " + val);

        // Check palindrome
        System.out.println("Is Palindrome: " + LLPalondrome());
    }
}
