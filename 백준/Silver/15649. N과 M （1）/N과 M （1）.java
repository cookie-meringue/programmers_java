import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] arr;
    static boolean[] visited;

    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[10];
        visited = new boolean[10];
        run(0);
    }

    static void run(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                arr[k] = i;
                visited[i] = true;
                run(k + 1);
                visited[i] = false;
            }
        }
    }
}
