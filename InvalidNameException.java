public class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}




import java.util.Scanner;

public class DoctorNameValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Doctor's Name: ");
        String doctorName = scanner.nextLine();

        try {
            validateName(doctorName);
            System.out.println("Doctor's Name: " + doctorName);
        } catch (InvalidNameException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void validateName(String name) throws InvalidNameException {
        if (!name.matches("^[a-zA-Z\\s]+$")) {
            throw new InvalidNameException("Name is Invalid");
        }
    }
}
