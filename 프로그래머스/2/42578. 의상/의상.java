import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(String[][] clothes) {

        int answer = 0;

        HashMap<String, List<String>> clothesMap = new HashMap<>();

        for (String[] clothe : clothes) {
            List<String> value = clothesMap.getOrDefault(clothe[1], new LinkedList<>());
            value.add(clothe[0]);
            clothesMap.put(clothe[1], value);
            answer++;
        }

        if (clothesMap.size() == 1) {
            return answer;
        }

        int answer2 = 1;
        for (String key : clothesMap.keySet()) {
            answer2 *= clothesMap.get(key).size() + 1;
        }

        return answer2 - 1;
    }
}