import java.util.*;

public class Main {

    static boolean[][] visited;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m; // main 밖에서도 쓸 수 있게 전역으로 선언

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int cnt = 0; // 그림의 총 개수
        int max = 0; // 가장 큰 그림의 넓이

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                // 1. 그림('1')이 아니거나, 이미 방문했으면 건너뛰기
                if (board[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                // --- 여기서부터 새로운 그림 발견 ---
                cnt++; // 1. 그림 개수 증가
                Queue<int[]> queue = new LinkedList<>();
                
                // 2. [수정] 시작 노드를 큐에 추가하고 **즉시 방문 처리**
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                
                // 3. [수정] 넓이(maxTemp)를 1로 시작 (시작 노드 포함)
                int maxTemp = 1; 

                while (!queue.isEmpty()) {
                    int[] pair = queue.poll();
                    int curX = pair[0];
                    int curY = pair[1];

                    // 4. [수정] (큐에서 꺼낼 때 하던 visited 체크 삭제)

                    // 5. 상하좌우 이웃 탐색
                    for (int k = 0; k < 4; k++) {
                        int nx = curX + dx[k]; // Next X
                        int ny = curY + dy[k]; // Next Y

                        // 6. [수정] 경계선 체크
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                            continue;
                        }

                        // 7. [핵심 수정] 
                        //    - 그림('1')이면서
                        //    - **아직 방문하지 않은 곳**만 큐에 넣습니다.
                        if (board[nx][ny] == 1 && !visited[nx][ny]) {
                            
                            // 8. [수정] **큐에 넣을 때** 방문 처리
                            visited[nx][ny] = true; 
                            queue.add(new int[]{nx, ny});
                            
                            // 9. [수정] **새로운 칸을 찾았을 때** 넓이 1 증가
                            maxTemp++; 
                        }
                    }
                    // 10. [수정] (for 루프 안에 있던 visited 처리, maxTemp++ 삭제)
                }
                
                // 11. 하나의 BFS가 끝나면 최대 넓이 갱신
                if (maxTemp > max) {
                    max = maxTemp;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }
}