
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

    //for opeartions we make methods instead of writing code in main method
    public static void AddFirstNode(int data) {
        //1.create node
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        }
        //2. new node next put head connection
        newNode.next = head;
        //3.move head to news node
        head = newNode;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.AddFirstNode(1);
        ll.AddFirstNode(2);

    }
}
