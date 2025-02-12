
class TextNode {
    String text;
    TextNode next;
    TextNode prev;

    public TextNode(String text) {
        this.text = text;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    TextNode head;
    TextNode current;
    int maxHistory = 10;
    int size = 0;

    public void inE(String text) {
        TextNode newNode = new TextNode(text);
        if (head == null) {
            head = newNode;
            current = newNode;
            size = 1;
            return;
        }
        if (size == maxHistory) {
            head = head.next;
            head.prev = null;
            size--;
        }
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
        size++;
    }

    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo!");
            return;
        }
        current = current.prev;
        System.out.println("Undo: Current state: " + current.text);
    }

    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo!");
            return;
        }
        current = current.next;
        System.out.println("Redo: Current state: " + current.text);
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.text);
        } else {
            System.out.println("No text available.");
        }
    }

    public void displayForward() {
        TextNode temp = head;
        while (temp != null) {
            System.out.print(temp.text + " <-> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void displayBackward() {
        if (current == null) {
            System.out.println("No text available.");
            return;
        }
        TextNode temp = current;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.text + " <-> ");
            temp = temp.prev;
        }
        System.out.println("Null");
    }
}

public class TeQ {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.inE("Hello");
        editor.inE("Hello World");
        editor.inE("Hello World!");
        editor.inE("Hello World!!");

        System.out.println("Text History:");
        editor.displayForward();

        editor.displayCurrentState();

        editor.undo();
        editor.undo();
        editor.redo();

        System.out.println("Displaying text history in reverse order:");
        editor.displayBackward();
    }
}



