import java.util.*;

// BruteForce Approach(Stack based approach)
class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                if(!stack.isEmpty()){
                    result.append(ch);
                }
                stack.push(ch);
            }else if(ch == ')'){
                stack.pop();

                // If stack is not empty after pop, it's not the outermost closing bracket,add it to result
                if(!stack.isEmpty()){
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}
//TC and SC(BruteForce)
⌛ Time Complexity: O(n)

📦 Space Complexity: O(n) 


// Optimal approach(Counter based Approach)
class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                count--; 
            }
           // count will only be 0, when we get outermost closing bracket, 
           // that's why 1st condition is for closing bracket

            if(count != 0){
                result.append(s.charAt(i));
            }
            if(s.charAt(i) == '('){
                count++;
            }
        }
        return result.toString();
    }
}


//TC and SC(Optimal)
⌛ Time Complexity: O(n)
📦 Space Complexity: O(1)
