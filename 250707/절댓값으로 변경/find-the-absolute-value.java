import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        abs(arr);
    }

    public static void abs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Math.abs(arr[i])+" ");
        }
    }
}