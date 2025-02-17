import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] nList = new int[T];
        for (int i = 0; i < T; i++) {
            nList[i] = sc.nextInt();
        }

        int max = Arrays.stream(nList).max().getAsInt();
        int[] counts = countFibo(max);

        for (int i = 0; i < nList.length; i++) {
            search(counts, nList[i]);
        }

    }

    static int[] countFibo(int n) {
        int[] countArr = new int[n+1];
        countArr[0] = 1;
        for (int i = 1; i < n+1; i++) {
            if (i == 1) {
                countArr[i] = 1;
                continue;
            }
            countArr[i] = countArr[i-2] + countArr[i-1];
        }
        return countArr;
    }

    static void search(int[] arr, int target) {
        if (target == 0) {
            System.out.println("1 0");
        } else if (target == 1) {
            System.out.println("0 1");
        } else {
            System.out.println(arr[target - 2] + " " + arr[target-1]);
        }
    }
}
