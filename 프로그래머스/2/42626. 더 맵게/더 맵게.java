import java.util.*;

class Solution {
    public int solution(int[] scovilles, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int scoville : scovilles) {
            queue.add(scoville);
        }
        int count = 0;
        while(queue.peek() < K) {
            if(queue.size() < 2) {
                return -1;
            }
            int scoville1 = queue.poll();
            int scoville2 = queue.poll();
            queue.add(shake(scoville1, scoville2));
            count++;
        }
        return count;
    }
    
    private int shake(int scoville1, int scoville2) {
        return scoville1 + (scoville2 * 2);
    }
}