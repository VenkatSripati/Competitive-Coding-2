// Define a Node class for the singly linked list
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertionSortLinkedList {

    // Function to perform insertion sort on the linked list
    public static Node insertionSort(Node head) {
        // Create a dummy node. This helps with edge cases like inserting at the head.
        Node dummy = new Node(0);
        Node current = head;

        // Traverse the original list
        while (current != null) {
            // At each iteration, current points to the node to be inserted
            Node next = current.next; // Save the next node to process later

            // Find the correct position to insert current node in the sorted part
            Node prev = dummy;

            // Move prev forward until we find the right spot (where prev.next.data > current.data)
            while (prev.next != null && prev.next.data < current.data) {
                prev = prev.next;
            }

            // Insert current between prev and prev.next
            current.next = prev.next;
            prev.next = current;

            // Move to the next node to be inserted
            current = next;
        }

        // Return the head of the sorted list, which is next of dummy node
        return dummy.next;
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

    // Main function to test the insertion sort
    public static void main(String[] args) {
        // Create the linked list 4 -> 2 -> 1 -> 3
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.print("Original List: ");
        printList(head);

        // Sort the list
        head = insertionSort(head);

        System.out.print("Sorted List: ");
        printList(head);
    }
}
