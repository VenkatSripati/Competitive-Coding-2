public class UglyNumber {

    // Function to check if a number is ugly
    static boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        // Divide num by 2, 3, 5 as long as possible
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }

        // If num reduces to 1, it's an ugly number
        return num == 1;
    }

    // Function to get the nth ugly number
    static int nthUglyNumber(int n) {
        int count = 0; // counter for ugly numbers
        int num = 0;   // current number to check

        while (count < n) {
            num++;
            if (isUgly(num)) {
                count++;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        int n = 10; // Example: Find 10th ugly number
        int uglyNum = nthUglyNumber(n);
        System.out.println("The " + n + "th ugly number is: " + uglyNum);
    }
}

