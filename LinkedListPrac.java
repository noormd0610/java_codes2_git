
public class LinkedListPrac {

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

    //add first node
    public static void AddFirstNode(int data) {
        //1.create
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //2.newnode next =head
        newNode.next = head;
        //3. move head pointing
        head = newNode;

    }

//add last node
    public static void AddLastNode(int data) {
        //1.create
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //2.newnode next =head
        tail.next = newNode;
        //3. move head pointing
        tail = newNode;

    }

    //add middle node in ll
    public static void AddMiddleNode(int Idx, int data) {

        if (head == null) {
            AddFirstNode(data);
            return;
        }
        //find prev
        Node prev = head;
        int i = 0;
        while (i != Idx - 1) {
            prev = prev.next;
            i++;
        }

        //1.create node
        Node newNode = new Node(data);
        size++;
        //2. new node next =prev.next
        newNode.next = prev.next;
        //3.prev.next=newNode;
        prev.next = newNode;
    }

    //'print Ll'
    public static void printLL() {
        if (head == null) {
            System.out.println("ll is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    //remove first node
    public static int removeFirstNode() {

        if (head == null) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        size--;
        int val = head.data;
        Node temp = head;
        head = head.next;
        temp.next = null;
        return val;
    }

    public static int removeLastNode() {
        if (head == null) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = tail.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;

        int i = 0;
        while (i != size - 2) {
            prev = prev.next;
            i++;
        }

        int val = tail.data;
        prev.next = null;
        size--;
        tail = prev;
        return val;
    }

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
        LinkedListPrac ll = new LinkedListPrac();
        ll.AddFirstNode(1);
        ll.AddFirstNode(2);
        // ll.AddLastNode(4);
        // ll.AddLastNode(3);
        // ll.AddLastNode(24);
        // ll.AddLastNode(44);
        //ll.RemoveNthNodeFromEnd();
        // printLL();
        // System.out.println();
        // printLL();

    }
}
