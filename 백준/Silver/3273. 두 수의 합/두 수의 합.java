import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        IntStream.range(0, n).forEach(i -> arr[i] = scanner.nextInt());
        int x = scanner.nextInt();

        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == x) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}