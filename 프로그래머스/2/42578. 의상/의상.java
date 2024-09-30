import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesMap = new HashMap<>();
        
        for(String[] c : clothes){
            clothesMap.put(c[1], clothesMap.getOrDefault(c[1], 0) + 1);
        }
        
        if(clothesMap.keySet().size() == 1){
            return clothes.length;
        }
        
        for(String i : clothesMap.keySet()){
            answer *= clothesMap.get(i) + 1;
        }
        
        return answer - 1;
    }
}