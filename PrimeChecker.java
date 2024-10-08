public class ZeroException extends Exception {
    public ZeroException(String message) {
        super(message);
    }
}



import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        try {
            checkZero(number);
            if (isPrime(number)) {
                System.out.println(number + " is a prime number.");
            } else {
                System.out.println(number + " is not a prime number.");
            }
        } catch (ZeroException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void checkZero(int number) throws ZeroException {
        if (number == 0) {
            throw new ZeroException("Number is 0");
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
