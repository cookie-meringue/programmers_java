import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arguments = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int a = arguments[0];
        int b = arguments[1];
        int c = arguments[2];
        int d = arguments[3];
        int e = arguments[4];
        int f = arguments[5];

        System.out.println(calculateX(a, b, c, d, e, f) + " " + calculateY(a, b, c, d, e, f));
    }

    private static int calculateX(int a, int b, int c, int d, int e, int f) {
        return (b * f - e * c) / (b * d - a * e);
    }

    private static int calculateY(int a, int b, int c, int d, int e, int f) {
        return (a * f - c * d) / (a * e - b * d);
    }
}
