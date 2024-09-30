import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answerList = new ArrayList<>();
        answerList.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(arr[i - 1] != arr[i]){
                answerList.add(arr[i]);
            }
        }
        
        return answerList;
    }
}