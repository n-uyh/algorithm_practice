import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 4; j++) {
                if (sc.nextInt() == 0) {
                    count++;
                }
            }
            int c = 64 + count;
            if (count == 0) {
                System.out.println('E');
            } else {
                System.out.println((char) (c));                
            }
        }
    }
}