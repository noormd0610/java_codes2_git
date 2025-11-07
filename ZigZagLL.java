 

public class ZigZagLL {

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

    public void AddFirst(int data) {
        //1.
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //2.
        newNode.next = head;
        //3
        head = newNode;
    }

    public void AddLast(int data) {
        //1.
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //2.
        tail.next = newNode;
        tail = newNode;

    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node MidLL(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node ZigZag(Node head) {

        //1. mid
        Node midNode = MidLL(head);
        Node leftHead = head;
        Node rightHead = midNode.next;
        midNode.next = null;

        //2.reverse 
        Node prev = null;
        Node curr = rightHead;
        Node next;

        while (curr != null) {
            //1
            next = curr.next;
            //2
            curr.next = prev;
            //3
            prev = curr;
            //4
            curr = next;
        }
        rightHead = prev;//right last end

        //3. palindrome seq
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (rightHead != null) {
            //left
            temp.next = leftHead;
            temp = temp.next;
            leftHead = leftHead.next;
            //right
            temp.next = rightHead;
            temp = temp.next;
            rightHead = rightHead.next;
        }

        if (leftHead != null) {
            temp.next = leftHead;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ZigZagLL ll = new ZigZagLL();
        ll.AddLast(1);
        ll.AddLast(2);
        ll.AddLast(3);
        ll.AddLast(4);
        ll.AddLast(5);
       
        printLL(ZigZag(ll.head));
    }
}
