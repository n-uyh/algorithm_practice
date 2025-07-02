import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char o = sc.next().charAt(0);
        int c = sc.nextInt();

        System.out.println(calculate(a,c,o));
    }

    public static String calculate(int a, int b, char o) {
        String result = a + " " + o + " " + b + " = ";
        switch (o) {
            case '+':
                result += add(a,b); break;
            case '-':
                result += sub(a,b);break;
            case '*':
                result += multiply(a,b);break;
            case '/':
                result += divide(a,b);break;
            default:
                return "False";
        }
        return result;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}