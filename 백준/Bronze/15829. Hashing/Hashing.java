import java.util.Scanner;

public class Main {

    public static int l; // 문자열의 길이
    public static int r = 31;
    public static long M = 1234567891;
    public static long result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        sc.nextLine();
        String word = sc.nextLine();


        for (int i = 0; i < l; i++) {
            result += ((word.charAt(i) - 96) * modPow(i)) % M;
        }

        System.out.println(result % M);
    }

    // r, M은 static으로 선언해뒀으므로 인자로 받지 않는다.
    // 몇 번 거듭해서 곱할 건지만 받는다.
    // 각 곱셈마다 모듈러 연산이 분배되어 들어간다..
    public static long modPow(int n) {
        long res = 1; // 0번 거듭제곱하는 경우는 항상 1을 반환한다. (반복문에 진입하지 않을 때를 위한 초기화) ex. 31^0 = 1
        long base = r; // 거듭제곱의 밑. 내부에서 대입하는 경우가 필요해서 새로 선언.
        while (n != 0) {
            if ((n % 2) == 1) {
                res = (res * base) % M;
            }
            base = (base * base) % M; // 다음 반복에서 곱해질 밑 계산
            n /= 2; // 지수를 2로 나누어 준다.
        }
        return res;
    }
}