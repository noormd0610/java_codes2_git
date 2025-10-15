
public class QueueLL {

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

    public static boolean IsEmpty() {
        if (head == null && tail == null) {
            return true;
        } else {
            return false;
        }
    }

    public static void enque(int data) {
        //1
        Node newNode = new Node(data);
        //2
        if (IsEmpty()) {
            head = tail = newNode;
        }
        //3
        tail.next = newNode;
        tail = newNode;

    }

    public static void deque() {
        if (IsEmpty()) {
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    public static void printLL() {
        if (IsEmpty()) {
            return;
        }
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data +" ");
            temp = temp.next;
        }

    }

    public static void main(String[] args) {
        QueueLL q = new QueueLL();
        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.enque(4);
        q.enque(5);
        q.deque();
        q.printLL();
    }
}
