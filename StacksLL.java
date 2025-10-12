 public class StacksLL {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head = null;

        static boolean IsEmpty() {
            return head == null;
        }

        static void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        static int pop() {
            if (IsEmpty()) return Integer.MIN_VALUE;
            int val = head.data;
            head = head.next;
            return val;
        }

        static int peek() {
            if (IsEmpty()) return Integer.MIN_VALUE;
            return head.data;
        }

        static void printStack() {
            while (!IsEmpty()) {
                System.out.print(peek() + " ");
                pop();
            }
        }
    }

    public static void main(String[] args) {
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);
        Stack.push(4);
        Stack.printStack();  // Output: 4 3 2 1
    }
}
