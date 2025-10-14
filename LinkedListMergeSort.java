 
public class LinkedListMergeSort {

    public static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static  Node head;
    public static  Node tail;

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


    //merge two sorted ll 
    public static Node merge(Node leftHead, Node rightHead) {
        Node t1 = leftHead;
        Node t2 = rightHead;
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (t1 != null && t2 != null) {
            if (t1.data <= t2.data) {
                temp.next = t1;
                temp = temp.next;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = temp.next;
                t2 = t2.next;
            }
        }

        if (t1 != null) {
            temp.next = t1;
        }
        if (t2 != null) {
            temp.next = t2;
        }

        return dummy.next;
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

    public static Node MergeSortLL(Node head) {

        //1.
        if (head == null || head.next == null) {
            return head;
        }

        //2. mid
        Node MidNode = MidLL(head);
        Node leftHead = head;
        Node RightHead = MidNode.next;
        MidNode.next = null;

        leftHead = MergeSortLL(leftHead);
        RightHead = MergeSortLL(RightHead);
        return merge(leftHead, RightHead);

    }

    public static void main(String[] args) {
        LinkedListMergeSort LL = new LinkedListMergeSort();
        LL.AddLast(3);
        LL.AddLast(8);
        LL.AddLast(7);
        LL.AddLast(4);

        Node mergedHead = MergeSortLL(head);
        printLL(mergedHead);
    }
}
