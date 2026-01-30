import java.util.Scanner;

class InvalidUsernameException extends Exception {
    String message;
    InvalidUsernameException(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}

class InvalidAgeException extends Exception {
    String message;
    InvalidAgeException(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}

class InvalidEmailException extends Exception {
    String message;

    InvalidEmailException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

public class problem3 {
    static void validateusername(String username) throws InvalidUsernameException {
        if (username.length() < 6) {
            throw new InvalidUsernameException("Username must be at least 6 characters long.");
        }
        if (!username.matches("[a-zA-Z][a-zA-Z0-9_]*")) {
            throw new InvalidUsernameException("Username can only contain alphanumeric characters and underscores.Start with alphabet.ua");
        }
    }

    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18 || age > 100) {
            throw new InvalidAgeException("Age must be between 18 and 100.");
        }
    }

    static void validateEmail(String email) throws InvalidEmailException {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        if (!email.matches(emailRegex)) {
            throw new InvalidEmailException("Invalid email format ends with @gmail.com.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Validating user details...");
            System.out.println("enter username:");
            String username = sc.nextLine();
            System.out.println("enter age:");
            int age = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.println("enter email:");
            String email = sc.nextLine();

            validateusername(username);
            validateAge(age);
            validateEmail(email);
            System.out.println("All user details are valid.");
        } catch (InvalidUsernameException e) {
            System.out.println("Invalid username: " + e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("Invalid age: " + e.getMessage());
        } catch (InvalidEmailException e) {
            System.out.println("Invalid email: " + e.getMessage());
        } finally {
            System.out.println("Validation completed (log)");
            sc.close();
        }
    }
}