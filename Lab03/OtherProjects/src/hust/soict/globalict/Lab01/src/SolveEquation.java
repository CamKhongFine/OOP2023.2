import java.util.Scanner;

public class SolveEquation {
    public static void main(String[] args) {
//        firstDegreeEq();
//        firstDegreeEq();
//        secondDegreeEq();
    }

    private static void firstDegreeEq() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.println("Enter coefficient b: ");
        double b = scanner.nextDouble();
        if(a == 0) {
            if(b == 0) {
                System.out.println("Infinite Solution");
            }
            else {
                System.out.println("No solution");
            }
        } else {
            System.out.println("The result X = " + (-b/a));
        }
    }

    private static void firstDegreeSys() {
        Scanner scanner = new Scanner(System.in);
        // initialize variable
        System.out.println("Enter a11: ");
        double a11 = scanner.nextDouble();
        System.out.println("Enter a12: ");
        double a12 = scanner.nextDouble();
        System.out.println("Enter b1: ");
        double b1 = scanner.nextDouble();
        System.out.println("Enter a21: ");
        double a21 = scanner.nextDouble();
        System.out.println("Enter a22: ");
        double a22 = scanner.nextDouble();
        System.out.println("Enter b2: ");
        double b2 = scanner.nextDouble();
        // initialize determinant
        double d = a11*a22 - a21*a12;
        double d1 = b1*a22 - b2*a12;
        double d2 = a11*b2 - a21*b1;

        if(d!=0) {
            double x1 = d1/d;
            double x2 = d2/d;
            System.out.println("The system has unique solution: x1 = " + x1 + ", x2 = " + x2);
        } else {
            if(((a11/a21) == (a12/a22)) && ((a11/a21) == (b1/b2))){
                System.out.println("The system has infinite solution");
            } else {
                System.out.println("The system has no solution");
        }
        }
    }

    private static void secondDegreeEq() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.println("Enter coefficient b: ");
        double b = scanner.nextDouble();
        System.out.println("Enter coefficient c: ");
        double c = scanner.nextDouble();

        if(a == 0) {
            if(b == 0) {
                System.out.println("Infinite of or No solution");
            }
            else {
                System.out.println("The solution is x = " + (-c/b));
            }
        } else {
            double delta = b*b - 4*a*c;
            if(delta > 0) {
                System.out.println("There are 2 solution x1 = " + (-b - Math.sqrt(delta))/(2*a) + " x2 = " + (-b + Math.sqrt(delta))/(2*a) );
            } else if  (delta == 0) {
                System.out.println("There is 1 solution x = " + -b/(2*a));
            } else {
                System.out.println("There is no solution");
            }
        }
    }
}
