import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++){
            int value = progresses[i];
            int days = (int) Math.ceil((100 - value) / (float)speeds[i]);
    
            for(int j = i; j < progresses.length; j++){
                progresses[j] += speeds[j] * days;
            }
            
            int sum = 0;
            while(i < progresses.length){
                if(progresses[i] < 100){
                    break;
                }
                sum++;
                i++;
            }
            i--;
            answer.add(sum);
        }
        return answer;
    }
}