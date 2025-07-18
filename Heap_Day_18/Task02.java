package Heap_Day_18;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a 5-digit number: ");
        int number = scanner.nextInt();

        if (number >= 10000 && number <= 99999) {
            int unitsDigit = number % 10;
            int onesDigit = (number / 10) % 10;
            int hundredsDigit = (number / 100) % 10;
            int thousandsDigit = (number / 1000) % 10;
            int tenThousandsDigit = (number / 10000) % 10;

            System.out.println("Units digit is " + unitsDigit);
            System.out.println("Ones digit is " + onesDigit);
            System.out.println("Hundreds digit is " + hundredsDigit);
            System.out.println("Thousands digit is " + thousandsDigit);
            System.out.println("Ten thousands digit is " + tenThousandsDigit);
        } else {
            System.out.println("Please enter a valid 5-digit number.");
        }
        scanner.close();
    }
}

