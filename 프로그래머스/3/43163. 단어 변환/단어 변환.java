import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        if(begin.compareTo(target) > 0){
            Arrays.sort(words, Collections.reverseOrder());
        } else {
            Arrays.sort(words);
        }
        long c = Arrays.stream(words)
            .filter(word -> word.equals(target))
            .count();
        if(c == 0) {
            return 0;
        }
        
        int minCount = words.length;
        // 0 = 인덱스, 1 = 카운트
        List<Integer> results = new ArrayList<>();
        int n = words.length;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i<n; i++) {
            if(canConvert(begin, words[i])) {
                queue.add(new int[]{i, 1});
                break;
            }
        }
        if(queue.isEmpty()) {
            return 0;
        }
        
        while(!queue.isEmpty()) {
            int[] pair = queue.poll();
            int index = pair[0];
            int count = pair[1];
            
            // 종료 조건 (일치)
            if(words[index].equals(target)) {
                minCount = Math.min(minCount, count);
                continue;
            }
            
            for(int i = 0; i < n; i++) {
                if(!visited[i] && canConvert(words[index],words[i])) {
                    queue.add(new int[]{i, count + 1});
                    visited[i] = true;
                }
            }
        }
        
        return minCount;
    }
    
    boolean canConvert(String from, String to) {
        int diffCount = 0;
        for(int i = 0; i<from.length(); i++) {
            if(from.charAt(i) != to.charAt(i)) {
                diffCount++;
            }
            if(diffCount > 1) {
                return false;
            }
        }
        
        return diffCount == 1;
    }
    
    class Node{
        int index;
        int count;
        boolean[] visited;
        
        Node(int index, int count, boolean[] visited) {
            this.index = index;
            this.count = count;
            this.visited = visited;
        }
    }
}