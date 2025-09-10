import java.util.Scanner;

public class RadixSort {

    // A function to get the maximum value in the array
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max)
                max = num;
        }
        return max;
    }

    // A function to do counting sort based on the digit at exp place
    public static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];  // output array
        int[] count = new int[10];  // count array for digits 0-9

        // Initialize count array as 0
        for (int i = 0; i < 10; i++)
            count[i] = 0;

        // Store count of occurrences of digits at exp place
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Change count[i] so that count[i] contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array from right to left to maintain stability
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the output array back to arr[]
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // Main function to implement radix sort
    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Apply counting sort to sort elements based on digit at exp place
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of elements
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        // Sort the array using Radix Sort
        radixSort(arr);

        // Output the sorted array
        System.out.println("Sorted array:");
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        scanner.close();
    }
}
