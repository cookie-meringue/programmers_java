import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int[][] map;
    static int[][] jDuration;
    static int[][] fDuration;
    static boolean[][] jihunVisited;
    static boolean[][] fireVisited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        int[] jihun = new int[2];
        List<int[]> fires = new ArrayList<>();
        map = new int[n][m];
        jihunVisited = new boolean[n][m];
        fireVisited = new boolean[n][m];
        jDuration = new int[n][m];
        fDuration = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            for (int j = 0; j < m; j++) {
                if (chars[j] == '#') {
                    map[i][j] = -1;
                } else if (chars[j] == 'J') {
                    jihun[0] = i;
                    jihun[1] = j;
                    jihunVisited[i][j] = true;
                } else if (chars[j] == 'F') {
                    fires.add(new int[]{i, j});
                    fireVisited[i][j] = true;
                }
            }
        }

        if (jihun[0] == 0 || jihun[0] == n - 1) {
            System.out.println(1);
            return;
        }
        if (jihun[1] == 0 || jihun[1] == m - 1) {
            System.out.println(1);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{jihun[0], jihun[1], 1});
        fires.forEach(point -> queue.add(new int[]{point[0], point[1], 0}));
        while (!queue.isEmpty()) {
            int[] obj = queue.poll();
            // 지훈이일 경우
            if (obj[2] == 1) {
                int x = obj[0];
                int y = obj[1];
                if (fireVisited[x][y]) {
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];

                    if (isOver(nextX, nextY) || isWall(nextX, nextY) || fireVisited[nextX][nextY]) {
                        continue;
                    }

                    if (jihunVisited[nextX][nextY]) {
                        continue;
                    }
                    jihunVisited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, 1});
                    jDuration[nextX][nextY] = jDuration[x][y] + 1;
                }
            } else {
                int x = obj[0];
                int y = obj[1];
                for (int i = 0; i < 4; i++) {
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];

                    if (isOver(nextX, nextY) || isWall(nextX, nextY)) {
                        continue;
                    }

                    if (fireVisited[nextX][nextY]) {
                        continue;
                    }
                    fireVisited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, 0});
                    fDuration[nextX][nextY] = fDuration[x][y] + 1;
                }
            }
        }

        List<int[]> availableEdge = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isEdge(i, j) && !isWall(i, j)) {
                    availableEdge.add(new int[]{i, j});
                }
            }
        }

        // 가능한 엣지 중에서, 지훈이의 duration 값이 fire의 duration 값보다 작은 것들을 필터링한다.
        // 그 다음, 지훈이의 duration 값이 가장 작은 값을 선택한다.
        List<int[]> canEdge = availableEdge.stream()
                .filter(point -> {
                    if (!fireVisited[point[0]][point[1]] && jihunVisited[point[0]][point[1]]) {
                        return true;
                    } else if (fireVisited[point[0]][point[1]] && jihunVisited[point[0]][point[1]]) {
                        return jDuration[point[0]][point[1]] < fDuration[point[0]][point[1]];
                    }
                    return false;
                })
                .collect(Collectors.toList());

        if (canEdge.isEmpty()) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        int min = jDuration[canEdge.get(0)[0]][canEdge.get(0)[1]];
        for (int[] p : canEdge) {
            if (jDuration[p[0]][p[1]] < min) {
                min = jDuration[p[0]][p[1]];
            }
        }
        min++;
        System.out.println(min);
    }

    static boolean isWall(int x, int y) {
        return map[x][y] == -1;
    }

    static boolean isOver(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    static boolean isEdge(int x, int y) {
        if (x == 0 || x == n - 1) {
            return y != 0 && y != m - 1;
        }
        if (y == 0 || y == m - 1) {
            return x != 0 && x != n - 1;
        }
        return false;
    }
}
