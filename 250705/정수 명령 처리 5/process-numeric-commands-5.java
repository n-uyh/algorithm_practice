import java.util.*;
public class Main {

    static List<Integer> list = new ArrayList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- >= 0) {
            String c = sc.nextLine();
            String[] commands = c.split(" ");
            obey(commands);
        }
    }

    public static void obey(String[] commands) {
        switch (commands[0]) {
            case "push_back":
                list.add(Integer.parseInt(commands[1]));
                break;
            case "pop_back":
                list.remove(list.size() - 1);
                break;
            case "size":
                System.out.println(list.size());
                break;
            case "get":
                System.out.println(list.get(Integer.parseInt(commands[1]) - 1));
                break;
        }

    }
}