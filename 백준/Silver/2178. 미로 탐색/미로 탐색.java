import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; //x방향배열-상하
    static int[] dy = {0, 0, -1, 1}; //y방향배열-좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs(new Location(0, 0));
        System.out.println(map[n - 1][m - 1]);
    }

    public static void bfs(Location location) {
        Queue<Location> q = new LinkedList<>();
        q.add(location);

        while (!q.isEmpty()) {
            Location now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }
                if (visited[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue;
                }

                q.add(new Location(nextX, nextY));
                map[nextX][nextY] = map[x][y] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }

    static class Location {
        int x;
        int y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}