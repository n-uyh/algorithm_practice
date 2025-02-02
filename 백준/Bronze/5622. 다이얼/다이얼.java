import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] dial = new String[]{
            "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"
        };
        
        Scanner sc = new Scanner(System.in);
        
        String word = sc.nextLine();
        int len = word.length();
        
        int result = len * 3;
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            for (int j=0; j < dial.length; j++) {
                if (dial[j].indexOf(c) != -1) {
                    result += j;
                    break;
                }
            }
        }
        
        System.out.print(result);
        
    }
}