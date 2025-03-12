import java.util.*;
public class Main {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        String grade;
        if (N >= 90) {
            grade = "A";
        } else if (N >= 80) {
            grade = "B";
        } else if (N >= 70) {
            grade = "C";
        } else if (N >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println(grade);
    }
}