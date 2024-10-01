import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Deque<Integer> deque = new LinkedList<>();
        
        int max = priorities[0];
        
        for(int i = 0; i<priorities.length; i++){
            deque.addLast(priorities[i]);
            if(priorities[i] > max){
                max = priorities[i];
            }
        }
        
        int result = 1;
        while(deque.peekFirst() != max || location != 0){
            if(deque.peekFirst() < max){
                int value = deque.pollFirst();
                deque.addLast(value);
                
                if(location == 0){
                    location = deque.size() - 1;
                }
                else{
                    location--;
                }
                continue;
            }
            else if(deque.peekFirst() == max){
                deque.pollFirst();
                location--;
                result++;
            }
            max = findMax(deque);
        }
        
        return result;
    }
    
    public int findMax(Deque<Integer> deque){
        int max = deque.peekFirst();
        
        for(int i : deque){
            if(i > max){
                max = i;
            }
        }
        
        return max;
    }
}