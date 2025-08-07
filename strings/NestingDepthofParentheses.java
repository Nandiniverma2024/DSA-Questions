// 1614. Maximum Nesting Depth of the Parentheses
// Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

// Example 1:

// Input: s = "(1+(2*3)+((8)/4))+1"

// Output: 3

// Explanation:

// Digit 8 is inside of 3 nested parentheses in the string.



// Better Approach -> using Stack
class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack =  new Stack<>();
        int max=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push('(');
                max=Math.max(max, stack.size());
            }else if(s.charAt(i)==')'){
                stack.pop();
            }
        }
        return max;
    }
}

// tc -> O(n) (since using for loop for n elements, i.e One traversal)
// sc -> O(n) (since use stack, In worst case, all characters are '(' )



// Optimal Appraoch -. Using Counter
class Solution {
    public int maxDepth(String s) {
        int counter=0, maxCounter=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                counter++;
                maxCounter=Math.max(counter, maxCounter);
            }else if(s.charAt(i) == ')'){
                counter--;
            }
        }
        return maxCounter;
    }
}

// Tc -> O(n)
// sc -> O(1)


