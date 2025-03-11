public class Main {
    public static void main(String[] args) {
        int weight = 13;
        float rate = 0.165f;
        System.out.println(weight + " * " + String.format("%.6f", rate) + " = " + String.format("%.6f", weight * rate));
    }
}