import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] board;
    static int[][] duration;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        board = new int[n][m];
        visited = new boolean[n][m];
        duration = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] job = queue.poll();
            int x = job[0];
            int y = job[1];
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }
                if (board[nextX][nextY] == 0) {
                    board[nextX][nextY] = 1;
                    visited[nextX][nextY] = true;
                    duration[nextX][nextY] = duration[x][y] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        if (!isAllRiped()) {
            System.out.println(-1);
            return;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (duration[i][j] > max) {
                    max = duration[i][j];
                }
            }
        }

        System.out.println(max);
    }

    static boolean isAllRiped() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
