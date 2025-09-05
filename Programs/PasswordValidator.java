import java.util.Scanner;

public class PasswordValidator {

    public static boolean isValidPassword(String password) {
        boolean valid = true;

        // 1. Length check
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            valid = false;
        }

        // 2. Uppercase check
        if (!password.matches(".*[A-Z].*")) {
            System.out.println("Password must contain at least one uppercase letter.");
            valid = false;
        }

        // 3. Lowercase check
        if (!password.matches(".*[a-z].*")) {
            System.out.println("Password must contain at least one lowercase letter.");
            valid = false;
        }

        // 4. Digit check
        if (!password.matches(".*[0-9].*")) {
            System.out.println("Password must contain at least one digit.");
            valid = false;
        }

        // 5. Special character check
        if (!password.matches(".*[@#$%^&+=!].*")) {
            System.out.println("Password must contain at least one special character (@, #, $, %, etc.).");
            valid = false;
        }

        return valid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid. Please ensure it meets all criteria.");
        }

        sc.close();
    }
}
