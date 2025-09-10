class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListRemoveElement {

    // Function to remove the first occurrence of 'key' from the list
    public static Node removeElement(Node head, int key) {
        // Edge case: if list is empty, just return null
        if (head == null) {
            return null;
        }

        // Special case: if the element to remove is at the head
        if (head.data == key) {
            return head.next; // just move head to next node
        }

        // Otherwise, traverse the list to find the element
        Node current = head;
        Node prev = null;

        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        // If the element was found, remove it by skipping current node
        if (current != null) {
            prev.next = current.next;
        }

        // If the element was not found, list remains unchanged

        return head;
    }

    // Helper method to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Original List: ");
        printList(head);

        // Remove element 3
        head = removeElement(head, 3);
        System.out.print("Updated List (after removing 3): ");
        printList(head);

        // Remove element 1 (head)
        head = removeElement(head, 1);
        System.out.print("Updated List (after removing 1): ");
        printList(head);

        // Try to remove element 6 (not in list)
        head = removeElement(head, 6);
        System.out.print("Updated List (after attempting to remove 6): ");
        printList(head);
    }
}
