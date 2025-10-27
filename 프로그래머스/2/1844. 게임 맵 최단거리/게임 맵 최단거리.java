import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        distance[0][0] = 1;
        queue.add(new int[]{0, 0});
        
        while(!queue.isEmpty()) {
            int[] numbers = queue.poll();
            int x = numbers[0];
            int y = numbers[1];
            for(int i = 0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                if(visited[nextX][nextY] || maps[nextX][nextY] == 0) {
                    continue;
                }
                visited[nextX][nextY] = true;
                distance[nextX][nextY] = distance[x][y] + 1;
                queue.add(new int[]{nextX, nextY});
            }
        }
        
        if(distance[n-1][m-1] == 0) {
            return -1;
        }
        
        return distance[n-1][m-1];
    }
}