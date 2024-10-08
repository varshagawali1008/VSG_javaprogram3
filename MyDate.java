public class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}




import java.util.Scanner;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) throws InvalidDateException {
        if (!isValidDate(day, month, year)) {
            throw new InvalidDateException("Invalid Date: " + day + "/" + month + "/" + year);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void displayDate() {
        System.out.println("Date: " + day + "/" + month + "/" + year);
    }

    private boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > daysInMonth(month, year)) {
            return false;
        }
        return true;
    }

    private int daysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return (isLeapYear(year)) ? 29 : 28;
            default:
                return 0;
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter date (dd mm yyyy): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        
        try {
            MyDate myDate = new MyDate(day, month, year);
            myDate.displayDate();
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
