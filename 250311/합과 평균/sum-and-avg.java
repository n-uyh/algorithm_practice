import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int total = A + B;
        double avg = total / 2.0;
        System.out.println(total + " " + avg);
    }
}