import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participantHashMap = new HashMap<>();
        
        Arrays.stream(participant).forEach(p -> {
            if(participantHashMap.containsKey(p)){
                participantHashMap.put(p, participantHashMap.get(p) + 1);
                return;
            }
            participantHashMap.put(p, 1);
        });
        
        Arrays.stream(completion).forEach(c -> {
            if(participantHashMap.get(c) != 1){
                participantHashMap.put(c, participantHashMap.get(c) - 1);
                return;
            }
            participantHashMap.remove(c);
        });
        
        return participantHashMap.keySet().toArray(new String[0])[0];
    }
}