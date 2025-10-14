 // Circular Queue Implementation using Array
public class QueuesCircularArr {

    public static class QueuesArr {

        // Array to store queue elements
        static int arr[];
        // Total capacity of the queue
        static int size;
        // Rear points to the last element
        static int rear;
        // Front points to the first element
        static int front;

        // Constructor
        public QueuesArr(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        // Check if queue is empty
        public static boolean isEmpty() {
            return (rear == -1 && front == -1);
        }

        // Check if queue is full (circular condition)
        public static boolean IsFull() {
            // When next position of rear becomes front → queue is full
            return (rear + 1) % size == front;
        }

        // Enqueue → Add element at rear
        public static void add(int data) {
            if (IsFull()) {
                System.out.println("Queue is full");
                return; // stop adding if full
            }

            // First element condition → initialize front = 0
            if (front == -1) {
                front = 0;
            }

            // Move rear one step forward in circular manner
            rear = (rear + 1) % size;
            // Insert data
            arr[rear] = data;
        }

        // Dequeue → Remove element from front
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Nothing to remove");
                return -1;
            }

            // Store front element to return later
            int res = arr[front];

            // If only one element was present → reset both pointers
            if (front == rear) {
                front = rear = -1;
            } else {
                // Move front one step forward (circularly)
                front = (front + 1) % size;
            }

            // Return the removed element
            return res;
        }

        // Peek → Return the element at front without removing it
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }

        // Print all elements by repeatedly peeking and removing
        public static void printQueue() {
            while (!isEmpty()) {
                System.out.print(peek() + " ");
                remove();
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        QueuesArr Cq = new QueuesArr(5);

        Cq.add(1);
        Cq.add(2);
        Cq.add(3);
        Cq.printQueue();
    }
}
