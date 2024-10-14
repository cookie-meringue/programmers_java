import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder("");
        
        List<String> answerList = new ArrayList<>();
        
        for(int i : numbers){
            answerList.add(String.valueOf(i));
        }
        
        Collections.sort(answerList, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        for(String s : answerList){
            answer.append(s);
        }
        
        return answer.toString().startsWith("0") ? "0" : answer.toString();
    }
}