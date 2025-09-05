import java.util.Scanner;

public class PalindromeCheck {
    
    // Method to check palindrome for strings (ignoring case and spaces)
    public static boolean isStringPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase(); // remove spaces & lowercase
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // Method to check palindrome for numbers
    public static boolean isNumberPalindrome(int num) {
        int original = num;
        int reversed = 0;
        
        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        
        return original == reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string or number: ");
        String input = sc.nextLine();

        // Check if input is a number
        if (input.matches("\\d+")) {  
            int number = Integer.parseInt(input);
            if (isNumberPalindrome(number)) {
                System.out.println(number + " is a Palindrome.");
            } else {
                System.out.println(number + " is NOT a Palindrome.");
            }
        } else {  
            // It's a string
            if (isStringPalindrome(input)) {
                System.out.println(input + " is a Palindrome.");
            } else {
                System.out.println(input + " is NOT a Palindrome.");
            }
        }

        sc.close();
    }
}
