import java.util.Scanner;

public class SquareRootApprox {
    
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        // Step 2: Start with an approximate root (guess)
        double guess = x;

        // Step 3 & 4: Improve guess iteratively using Newton's method
        while (true) {
            double newGuess = 0.5 * (guess + x / guess);
            
            // Stop when the difference is very small
            if (Math.abs(guess - newGuess) < 1e-6) {
                break;
            }
            guess = newGuess;
        }

        // Return floor of the approximation
        return (int) guess;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input
        System.out.print("Enter a non-negative integer: ");
        int x = sc.nextInt();

        int result = mySqrt(x);

        // Step 5: Output the result
        System.out.println("Square root (rounded down): " + result);

        sc.close();
    }
}
