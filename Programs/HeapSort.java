import java.util.Scanner;

public class HeapSort {

    // Function to heapify a subtree rooted at index i in array of size n
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;      // Initialize largest as root
        int left = 2 * i + 1; // left child index
        int right = 2 * i + 2;// right child index

        // If left child exists and is greater than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child exists and is greater than current largest
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Main function to do heap sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 2: Build max heap (rearrange array)
        // Start from last non-leaf node and heapify each node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 3: Extract elements one by one from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root (largest) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Helper method to print array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main driver method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input number of elements
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        // Input elements
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Perform heap sort
        heapSort(arr);

        // Step 4: Output sorted array
        System.out.println("Sorted array:");
        printArray(arr);

        scanner.close();
    }
}
