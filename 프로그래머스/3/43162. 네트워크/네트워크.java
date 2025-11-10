import java.util.*;

class Solution {
    
    public int solution(int n, int[][] arr) {
        int result = 0;
        boolean[] visited = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<>();
        for(int r = 0; r<n; r++) {
            if(visited[r]) {
                continue;
            }
            visited[r] = true;
            result++;
            queue.clear();
            queue.add(r);
        
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                
                for(int i = 0; i<n; i++) {
                    if(arr[cur][i] == 1 && !visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }
        return result;
    }
}