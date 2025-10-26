import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        
        int max = Integer.parseInt(arr[0]);
        int min =  Integer.parseInt(arr[1]);
        for(String num : arr) {
            int number = Integer.parseInt(num);
            if(number > max) {
                max = number;
            } else if(number < min) {
                min = number;
            }
        }
        
        return min + " " + max;
    }
}