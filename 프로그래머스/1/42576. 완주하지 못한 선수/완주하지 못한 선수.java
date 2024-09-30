import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participantHashMap = new HashMap<>();
        
        Arrays.stream(participant).forEach(p -> {
            participantHashMap.put(p, participantHashMap.getOrDefault(p, 0) + 1);
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