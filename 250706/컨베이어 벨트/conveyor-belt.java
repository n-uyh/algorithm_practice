import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }

        while (t-- > 0) {
            moveInLine(top);
            moveInLine(bottom);
            
            int temp = top[0];
            top[0] = bottom[0];
            bottom[0] = temp;
        }

        printArr(top);
        printArr(bottom);
    }

    public static void moveInLine(int[] line) {
        int temp = line[line.length - 1];
        for (int i = line.length - 1; i > 0; i--) {
            line[i] = line[i-1];
        }
        line[0] = temp;
    }

    public static void printArr(int[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] + " ";
        }
        System.out.println(result);
    }
}