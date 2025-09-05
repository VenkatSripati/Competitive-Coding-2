import java.util.Arrays;

public class MergeSortedArrays {
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        // Traverse both arrays
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Store remaining elements of arr1
        while (i < n1) {
            result[k++] = arr1[i++];
        }

        // Store remaining elements of arr2
        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        int[] mergedArray = mergeArrays(arr1, arr2);

        System.out.println("Merged Sorted Array: " + Arrays.toString(mergedArray));
    }
}
