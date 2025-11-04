import java.util.Scanner;

public class Main {

    static int[] map;
    static int n;
    static int cnt = 0;

    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new int[n];

        run(0);
        System.out.println(cnt);
    }

    private static void run(int rowNum) {
        if (rowNum == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (canMove(i, rowNum)) {
                map[rowNum] = i;
                run(rowNum + 1);
            }
        }
    }

    private static boolean canMove(int index, int rowNum) {
        for (int i = 0; i < rowNum; i++) {
            if (map[i] == index) {
                return false;
            }
            if (Math.abs(i - rowNum) == Math.abs(map[i] - index)) {
                return false;
            }
        }

        return true;
    }
}
