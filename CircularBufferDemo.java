import java.util.Arrays;

class CircularBuffer {
    private int[] buffer;
    private int front, rear, size, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void insert(int value) {
        rear = (rear + 1) % capacity;
        buffer[rear] = value;

        if (size < capacity) {
            size++;
        } else {
            front = (front + 1) % capacity;
        }
    }

    public int[] getBufferContents() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = buffer[(front + i) % capacity];
        }
        return result;
    }
}

public class CircularBufferDemo {
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        System.out.println(Arrays.toString(buffer.getBufferContents())); 

        buffer.insert(4);
        System.out.println(Arrays.toString(buffer.getBufferContents())); 
    }
}
