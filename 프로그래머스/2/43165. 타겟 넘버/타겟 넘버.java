import java.util.*;

class Solution {
    
    int[] d = {1, -1};
    
    public int solution(int[] numbers, int target) {
        // bfs를 통해 모든 경우의 수를 저장한다.
        Map<Integer, Integer> resultMap = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{numbers[0], 0});
        queue.add(new int[]{numbers[0] * -1, 0});
        while(!queue.isEmpty()) {
            int[] pair = queue.poll();
            int sum = pair[0];
            int index = pair[1];
            
            if(index == numbers.length - 1) {
                resultMap.put(sum, resultMap.getOrDefault(sum, 0) + 1);
                continue;
            }
            
            int nextIndex = index + 1;
            queue.add(new int[]{sum + numbers[nextIndex], nextIndex});
            queue.add(new int[]{sum + (-1 * numbers[nextIndex]), nextIndex});
        }
        if(resultMap.containsKey(target)) {
            return resultMap.get(target);
        }
        return 0;
    }
}