import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            if(match(stack.peek(), s.charAt(i))){
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        
        return stack.isEmpty();
    }
    
    boolean match(char c1, char c2){
        return c1 == '(' && c2 == ')';
    }
}