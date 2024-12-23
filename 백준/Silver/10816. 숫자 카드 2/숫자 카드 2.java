import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        int m = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int input = scanner.nextInt();

            sb.append(map.getOrDefault(input, 0)).append(" ");
        }

        System.out.println(sb);
    }
}