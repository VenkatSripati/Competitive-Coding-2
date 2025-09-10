import java.util.HashSet;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveDuplicatesLinkedList {

    // Function to remove duplicates from linked list
    public static Node removeDuplicates(Node head) {
        // If list is empty or has only one node, no duplicates to remove
        if (head == null || head.next == null) {
            return head;
        }

        HashSet<Integer> set = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            // If current node's data is already in set, it's a duplicate
            if (set.contains(current.data)) {
                // Skip the current node by linking previous node to next node
                prev.next = current.next;
            } else {
                // Not a duplicate, add data to set and move prev pointer
                set.add(current.data);
                prev = current;
            }
            // Move to the next node in all cases
            current = current.next;
        }
        return head;
    }

    // Helper function to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 2 -> 3 -> 4 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(5);

        System.out.print("Original List: ");
        printList(head);

        head = removeDuplicates(head);

        System.out.print("List After Removing Duplicates: ");
        printList(head);
    }
}
