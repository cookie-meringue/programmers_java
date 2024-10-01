import java.util.*;

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i = 0; i < truckWeights.length; i++){
            q1.add(truckWeights[i]);
        }
        
        for(int i = 0; i<bridgeLength; i++){
            q2.add(-1);
        }
        
        while(true){
            if(q1.isEmpty()){
                if(isEmptyQ2(q2)){
                    break;
                }
                q2.poll();
                q2.add(-1);
                answer++;
                continue;
            }
            
            q2.poll();
            q2.add(-1);
            
            int remainWeight = weight - sum(q2); // 다리의 남은 무게
            
            if(remainWeight >= q1.peek()){
                if(sizeOfQ2(q2) < bridgeLength){ // 다리 위에 트럭이 더 올라갈 수 있는 경우
                    LinkedList<Integer> list = (LinkedList<Integer>) q2;
                    list.set(list.size() - 1, q1.poll());
                }
            }
            
            answer++;
        }
        
        
        return answer;
    }
    
    public int sum(Queue<Integer> queue){
        int sum = 0;
        for(int i : queue){
            if(i == -1){
                continue;
            }
            sum += i;
        }
        
        return sum;
    }
    
    public boolean isEmptyQ2(Queue<Integer> q2){
        return !q2.stream().anyMatch(v -> v != -1);
    }
    
    public int sizeOfQ2(Queue<Integer> q2){
        int size = 0; 
        for(int i : q2){
            if(i != -1){
                size++;
            }
        }
        
        return size;
    }
}