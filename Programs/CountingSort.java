import java.util.Scanner;

public class CountingSort {

    public static void countingSort(int[] arr) {
        int n = arr.length;

        // Step 2: Find the maximum element in the array
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Step 3: Create count array of size max+1 and initialize with 0
        int[] count = new int[max + 1];

        // Step 4: Count the occurrence of each element
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Step 5: Update count array to store cumulative sums
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Step 6: Create output array
        int[] output = new int[n];

        // Step 7: Traverse input array in reverse and place elements in output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Step 8: Copy output array back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input number of elements
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        // Input array elements
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Call counting sort
        countingSort(arr);

        // Step 9: Print sorted array
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}
