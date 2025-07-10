import java.util.*;
public class Main {
    static class Person {
        String name;
        String addr;
        String region;

        public Person(String name, String addr, String region) {
            this.name = name;
            this.addr = addr;
            this.region = region;
        }

        @Override
        public String toString() {
            return String.format("name %s\naddr %s\ncity %s",name,addr,region);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] people = new Person[n];
        
        for (int i = 0; i < n; i++) {
            people[i] = new Person(sc.next(),sc.next(),sc.next());
        }

        Arrays.sort(people, Comparator.comparing(p -> p.name));
        System.out.print(people[n-1]);
    }
}