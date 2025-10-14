
public class DoubleLL {

    public static class Node {

        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void AddFirst(int data) {
        //1. create
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //2
        newNode.next = head;
        //3
        head.prev = newNode;
        //4
        head = newNode;
    }

    public static void AddLastst(int data) {
        //1. create
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //2
        newNode.prev = tail;
        //3
        tail.next = newNode;
        //4
        tail = newNode;
    }

    public static int RemoveFirst() {
//1.
        if (head == null) {
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            head = null;
            size = 0;
            return 0;
        }

        //2
        int val = head.data;
        head = head.next;
//3
        head.prev = null;
        size--;
        return val;
    }

    public static int RemoveLast() {
//1.
        if (head == null) {
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            head = null;
            size = 0;
            return 0;
        }

        //2
        int val = tail.data;
        tail = tail.prev;
        //3
        tail.next = null;
        size--;
        return val;
    }

    public static void PrintLL() {
        Node temp = head;
        System.out.print("null ");
        while (temp != null) {
            System.out.print(temp.data + " <--> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void ReverseLL() {
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;

            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;

    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.AddFirst(1);
        dll.AddFirst(2);
        dll.AddFirst(3);
        dll.AddFirst(4);
        dll.AddFirst(5);

        dll.PrintLL();
        dll.ReverseLL();
        System.out.println();
        dll.PrintLL();
    }

}
