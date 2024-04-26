import java.util.Scanner;

public class BasicCalculate {
    public static void main(String[] args) {
        double firstNumber;
        double secondNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number: ");
        firstNumber = scanner.nextDouble();
        System.out.println("Enter second number: ");
        secondNumber = scanner.nextDouble();;
        System.out.println("The sum is: " + (firstNumber + secondNumber));
        System.out.println("The difference is: " + Math.abs(firstNumber - secondNumber));
        System.out.println("The product is: " + firstNumber * secondNumber);
        if(firstNumber == 0 && secondNumber == 0) {
            System.out.println("Can't divide");
        } else if (firstNumber == 0) {
            System.out.println("First number divide Second number result to: 0");
        } else if (secondNumber == 0) {
            System.out.println("Second number divide First number result to: 0");
        } else {
            System.out.print("First number divide Second number result to: " + firstNumber/ secondNumber);
        }
    }
}
