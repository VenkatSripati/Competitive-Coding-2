import java.util.Scanner;

public class NumberTrianglePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number of rows
        System.out.print("Enter the number of rows for the pattern: ");
        int n = sc.nextInt();

        // Step 2: Loop through rows
        for (int i = 1; i <= n; i++) {
            // Step 3: Loop through numbers in each row
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            // Step 4: Move to the next line after each row
            System.out.println();
        }

        sc.close();
    }
}
