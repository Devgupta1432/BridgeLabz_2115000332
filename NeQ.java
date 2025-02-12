class FriendNode {
    int friendID;
    FriendNode next;

    public FriendNode(int friendID) {
        this.friendID = friendID;
        this.next = null;
    }
}

class FriendList {
    FriendNode head;

    public void addFriend(int friendID) {
        if (isFriend(friendID)) {
            System.out.println("Already friends!");
            return;
        }
        FriendNode newNode = new FriendNode(friendID);
        newNode.next = head;
        head = newNode;
    }

    public void removeFriend(int friendID) {
        if (head == null) return;
        if (head.friendID == friendID) {
            head = head.next;
            return;
        }
        FriendNode temp = head;
        while (temp.next != null && temp.next.friendID != friendID) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public boolean isFriend(int friendID) {
        FriendNode temp = head;
        while (temp != null) {
            if (temp.friendID == friendID) return true;
            temp = temp.next;
        }
        return false;
    }

    public void displayFriends() {
        FriendNode temp = head;
        if (temp == null) {
            System.out.println("No friends.");
            return;
        }
        while (temp != null) {
            System.out.print(temp.friendID + " --> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
}

class UserNode {
    int userID;
    String name;
    int age;
    FriendList friends;
    UserNode next;

    public UserNode(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friends = new FriendList();
        this.next = null;
    }
}

class SocialMedia {
    UserNode head;

    public void inB(int userID, String name, int age) {
        UserNode newNode = new UserNode(userID, name, age);
        newNode.next = head;
        head = newNode;
    }

    public void inE(int userID, String name, int age) {
        UserNode newNode = new UserNode(userID, name, age);
        if (head == null) {
            head = newNode;
            return;
        }
        UserNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    public void inS(int userID, String name, int age, int p) {
        if (p == 1) {
            inB(userID, name, age);
            return;
        }
        UserNode newNode = new UserNode(userID, name, age);
        UserNode temp = head;
        for (int i = 1; i < p - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid Position!");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void delB() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        head = head.next;
    }

    public void delE() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        UserNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void delS(int p) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (p == 1) {
            delB();
            return;
        }
        UserNode temp = head;
        for (int i = 1; i < p - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Invalid Position!");
            return;
        }
        temp.next = temp.next.next;
    }

    public UserNode search(int userID, String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userID == userID || temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int userID1, int userID2) {
        UserNode user1 = search(userID1, "");
        UserNode user2 = search(userID2, "");
        if (user1 != null && user2 != null) {
            user1.friends.addFriend(userID2);
            user2.friends.addFriend(userID1);
            System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void removeFriend(int userID1, int userID2) {
        UserNode user1 = search(userID1, "");
        UserNode user2 = search(userID2, "");
        if (user1 != null && user2 != null) {
            user1.friends.removeFriend(userID2);
            user2.friends.removeFriend(userID1);
            System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void displayFriends(int userID) {
        UserNode user = search(userID, "");
        if (user != null) {
            System.out.print("Friends of " + user.name + ": ");
            user.friends.displayFriends();
        } else {
            System.out.println("User not found.");
        }
    }

    public void findMutualFriends(int userID1, int userID2) {
        UserNode user1 = search(userID1, "");
        UserNode user2 = search(userID2, "");
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        System.out.print("Mutual friends: ");
        FriendNode f1 = user1.friends.head;
        boolean found = false;
        while (f1 != null) {
            if (user2.friends.isFriend(f1.friendID)) {
                System.out.print(f1.friendID + " ");
                found = true;
            }
            f1 = f1.next;
        }
        if (!found) System.out.println("None.");
        else System.out.println();
    }

    public void display() {
        UserNode curr = head;
        while (curr != null) {
            System.out.println("User ID: " + curr.userID + ", Name: " + curr.name + ", Age: " + curr.age);
            curr = curr.next;
        }
    }
}

public class NeQ {
    public static void main(String[] args) {
        SocialMedia network = new SocialMedia();

        network.inE(101, "Alice", 25);
        network.inE(102, "Bob", 23);
        network.inE(103, "Charlie", 22);
        System.out.println("Users after inserting at end:");
        network.display();

        network.inB(100, "David", 26);
        System.out.println("After inserting David at beginning:");
        network.display();

        network.inS(105, "Eve", 24, 3);
        System.out.println("After inserting Eve at position 3:");
        network.display();

        network.addFriend(101, 102);
        network.addFriend(101, 103);
        network.addFriend(102, 103);

        network.displayFriends(101);
        network.displayFriends(102);
        network.displayFriends(103);

        network.findMutualFriends(101, 102);

        network.removeFriend(101, 102);
        System.out.println("After removing friend connection:");
        network.displayFriends(101);
        network.displayFriends(102);
    }
}
