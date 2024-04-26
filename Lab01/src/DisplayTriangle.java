public class DisplayTriangle {
    public static void main(String[] args) {
        for(int i = 1; i <= 9; i += 2) {
            for(int k = 1; k <= (9-i)/2; k++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
                if(i == j) {
                    System.out.println("");
                }
            }
        }
    }
}
