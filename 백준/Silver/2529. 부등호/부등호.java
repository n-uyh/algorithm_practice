import java.util.*;

public class Main {

    static int[] numbers = new int[]{0,1,2,3,4,5,6,7,8,9}; // 미리 작은것부터 정렬해서 두기
    static int[] max, min;
    static char[] signs;
    static int k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = Integer.parseInt(sc.nextLine());
        max = new int[k+1];
        min = new int[k+1];
        signs = sc.nextLine().replaceAll(" ","").toCharArray();

        // 최솟값을 구성하려면 가장 작은 수들로 구성, > 가장 작은 수를 맨 앞으로 > 정렲필요
        // 최댓값을 구성하려면 가장 큰 수들로 구성, > 가장 큰 수를 맨앞으로
        for (int i = 0; i <= k; i++) {
            min[i] = numbers[i];
            max[i] = numbers[9 - i];
        }

        search(max);
        search(min);
    }

    static void search(int[] arr) {
        // 순서 변경을 위해 필요한 임시 변수
        int temp;
        // 부등호 맞는지 판단
        for (int i = 0; i < signs.length; i++) {
            // 순서 바꿔야 하는 경우 (부등호와 불일치)
            boolean cond1 = signs[i] == '<' && arr[i] > arr[i+1];
            boolean cond2 = signs[i] == '>' && arr[i] < arr[i+1];
            if (cond1 || cond2) {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                i = -1; // 다시 처음부터 반복
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k+1; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }

}
