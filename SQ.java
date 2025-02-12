
class TaskNode {
    int taskID;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskID, String taskName, int priority, String dueDate) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularLinkedList {
    TaskNode head;
    TaskNode current;

    public void inB(int taskID, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskID, taskName, priority, dueDate);
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
            current = newNode;
            return;
        }
        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    public void inE(int taskID, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskID, taskName, priority, dueDate);
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
            current = newNode;
            return;
        }
        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    public void del(int taskID) {
        if (head == null) {
            System.out.println("No tasks available!");
            return;
        }
        TaskNode temp = head, prev = null;
        do {
            if (temp.taskID == taskID) {
                if (temp == head && temp.next == head) {
                    head = null;
                    current = null;
                } else if (temp == head) {
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Task ID " + taskID + " has been removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Task ID " + taskID + " not found!");
    }

    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available!");
            return;
        }
        System.out.println("Current Task: ID: " + current.taskID + " | Name: " + current.taskName + " | Priority: " + current.priority + " | Due Date: " + current.dueDate);
        current = current.next;
    }

    public boolean search(int priority) {
        if (head == null) {
            System.out.println("No tasks available!");
            return false;
        }
        TaskNode temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Task Found: ID: " + temp.taskID + " | Name: " + temp.taskName + " | Priority: " + temp.priority + " | Due Date: " + temp.dueDate);
                return true;
            }
            temp = temp.next;
        } while (temp != head);
        System.out.println("No tasks with priority " + priority + " found.");
        return false;
    }

    public void display() {
        if (head == null) {
            System.out.println("No tasks available!");
            return;
        }
        TaskNode temp = head;
        do {
            System.out.println("Task ID: " + temp.taskID + " | Name: " + temp.taskName + " | Priority: " + temp.priority + " | Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
}

public class SQ {
    public static void main(String[] args) {
        CircularLinkedList scheduler = new CircularLinkedList();

        scheduler.inE(101, "Complete Report", 1, "2024-02-20");
        scheduler.inE(102, "Submit Assignment", 2, "2024-02-22");
        scheduler.inE(103, "Prepare Presentation", 1, "2024-02-25");
        scheduler.inE(104, "Attend Meeting", 3, "2024-02-23");
        System.out.println("Task List:");
        scheduler.display();

        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        scheduler.search(2);
        scheduler.search(5);

        scheduler.del(102);
        System.out.println("After removing task ID 102:");
        scheduler.display();
    }
}


