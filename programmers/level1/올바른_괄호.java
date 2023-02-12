import java.util.*;
public class 올바른_괄호 {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }
            else if(arr[i] == ')' && stack.peek() == '('){
                stack.pop();
            }else{ 
                stack.push(arr[i]);
            }
            
        }
            
        return stack.isEmpty() ? true : false;
    }
}