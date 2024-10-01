import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>(commands.length);
        for(int i = 0; i<commands.length; i++){
            int[] sliced = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(sliced);
            answer.add(sliced[commands[i][2] - 1]);
        }
        return answer;
    }
}