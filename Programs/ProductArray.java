public class ProductArray {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5};
        int result = 1;

        for (int i = 0; i < ar.length; i++) {
            result *= ar[i];
        }

        System.out.println("Result = " + result);
    }
}
