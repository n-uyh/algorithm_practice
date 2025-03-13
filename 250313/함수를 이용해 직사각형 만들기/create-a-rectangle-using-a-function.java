import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowNum = sc.nextInt();
        int colNum = sc.nextInt();
        
        printSqure(rowNum, colNum);
    }

    public static void printSqure(int row, int col) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sb.append(1);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}