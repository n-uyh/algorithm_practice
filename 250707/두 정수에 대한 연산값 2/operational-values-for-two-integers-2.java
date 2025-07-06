import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntWrapper a = new IntWrapper(sc.nextInt());
        IntWrapper b = new IntWrapper(sc.nextInt());

        calculate(a,b);
        System.out.printf("%d %d",a.v,b.v);

    }

    public static void calculate(IntWrapper a, IntWrapper b) {
        if (a.v > b.v) {
            a.v *= 2;
            b.v += 10;
        } else {
            a.v += 10;
            b.v *= 2;
        }
    }
}

class IntWrapper {
    int v;

    public IntWrapper(int v) {
        this.v = v;
    }
}