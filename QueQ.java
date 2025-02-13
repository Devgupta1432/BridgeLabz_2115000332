
import java.util.Stack;

class QueueStack {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public QueueStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void enqueue(int value) {
        s1.push(value);
        System.out.println(value + " enqueued");
    }

    public int dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

public class QueQ {
    public static void main(String[] args) {
        QueueStack queue = new QueueStack();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front element: " + queue.peek());

        queue.enqueue(4);
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}

