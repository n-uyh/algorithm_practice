import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntWrapper a = new IntWrapper(sc.nextInt());
        IntWrapper b = new IntWrapper(sc.nextInt());

        calculate(a,b);
        System.out.printf("%d %d",a.value,b.value);

    }

    public static void calculate(IntWrapper a, IntWrapper b) {
        int min = Math.min(a.value,b.value);
        a.value = calculate(a.value, a.value == min);
        b.value = calculate(b.value, b.value == min);
    }

    public static int calculate(int n, boolean isMin) {
        if (isMin) {
            return n * 2;
        }
        return n + 25;
    }
}

class IntWrapper {
    int value;
    public IntWrapper(int value) {
        this.value = value;
    }
}