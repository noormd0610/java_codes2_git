
public class QueuesArr {

    public static class QueuesArr {

        static int arr[];
        static int size;
        static int rear;
        static int front;

        public QueuesArr(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        //isEmpty
        public static boolean isEmpty() {
            if (rear == -1) {
                return true;
            }
            return false;
        }

        //add
        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("queue is full");
            }
            rear++;
            arr[rear] = data;
        }

        //remove  (deque)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("queue is empty. nothing to remove");
            }

            int front = arr[0];

            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }

            rear--;
            return front;
        }

        //peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
            }
            return arr[0];
        }

        public static void printQueue() {
            while (!isEmpty()) {
                System.out.print(peek()+ " ");
                remove();
            }
        }
    }

    public static void main(String[] args) {
        QueuesArr q = new QueuesArr(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.printQueue();
    }
}
