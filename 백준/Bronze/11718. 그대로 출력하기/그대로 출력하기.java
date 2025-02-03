// 어느 시점에 끝을 내야할 것인가?

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            sb.append(sc.nextLine()).append('\n');
        }
        System.out.print(sb);
    }
}