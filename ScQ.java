
class ProcessNode {
    int processID;
    int burstTime;
    int priority;
    ProcessNode next;

    public ProcessNode(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class CircularLinkedList {
    ProcessNode head;

    public void inE(int processID, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processID, burstTime, priority);
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
            return;
        }
        ProcessNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    public void del(int processID) {
        if (head == null) {
            System.out.println("No processes in the queue!");
            return;
        }
        ProcessNode temp = head, prev = null;
        do {
            if (temp.processID == processID) {
                if (temp == head && temp.next == head) {
                    head = null;
                } else if (temp == head) {
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Process ID " + processID + " has completed execution.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Process ID " + processID + " not found!");
    }

    public void roundRobinScheduling(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule!");
            return;
        }

        ProcessNode temp = head;
        int totalTime = 0;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int processCount = 0;

        System.out.println("\nExecuting Round Robin Scheduling with Time Quantum: " + timeQuantum);
        while (head != null) {
            do {
                if (temp.burstTime > 0) {
                    int executionTime = Math.min(temp.burstTime, timeQuantum);
                    System.out.println("Executing Process ID: " + temp.processID + " for " + executionTime + " units.");
                    temp.burstTime -= executionTime;
                    totalTime += executionTime;

                    if (temp.burstTime == 0) {
                        totalTurnAroundTime += totalTime;
                        totalWaitingTime += totalTime - executionTime;
                        processCount++;
                        del(temp.processID);
                    }
                }
                temp = temp.next;
            } while (temp != head && head != null);
        }

        System.out.println("\nAverage Waiting Time: " + (totalWaitingTime / (double) processCount));
        System.out.println("Average Turnaround Time: " + (totalTurnAroundTime / (double) processCount));
    }

    public void display() {
        if (head == null) {
            System.out.println("No processes in the queue!");
            return;
        }
        ProcessNode temp = head;
        do {
            System.out.println("Process ID: " + temp.processID + " | Burst Time: " + temp.burstTime + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class ScQ {
    public static void main(String[] args) {
        CircularLinkedList scheduler = new CircularLinkedList();

        scheduler.inE(1, 10, 2);
        scheduler.inE(2, 5, 1);
        scheduler.inE(3, 8, 3);
        scheduler.inE(4, 6, 2);
        System.out.println("Processes in queue:");
        scheduler.display();

        scheduler.roundRobinScheduling(4);
    }
}




