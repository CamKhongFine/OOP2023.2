import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class HandleArray {
    public static void main(String[] args) {
        int array[];
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in array: ");
        int n = scanner.nextInt();
        array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = 1;                     //Create constant array
        }
        for(int i = 0; i < n; i++) {
            System.out.println("Enter element " +i +" :");
            array[i] = scanner.nextInt();
        }
        System.out.print("Array before sorted: ");
        for(int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        Arrays.sort(array);
        System.out.print("Array after sorted: ");
        for(int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
            sum += array[i];
        }
        System.out.println("");
        System.out.println("Sum of all elements in array: " +sum);
        double average = (double)sum / Array.getLength(array);
        System.out.println("Average of all elements in array: " +average);
    }
}
