// 1614. Maximum Nesting Depth of the Parentheses
// Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

// Example 1:

// Input: s = "(1+(2*3)+((8)/4))+1"

// Output: 3

// Explanation:

// Digit 8 is inside of 3 nested parentheses in the string.



// BruteFroce Approach
class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int maxDepth = 0;

        // check all substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (isValid(sub)) { // check validity
                    maxDepth = Math.max(maxDepth, calculateDepth(sub));
                }
            }
        }
        return maxDepth;
    }

    // function to check valid parentheses string
    private boolean isValid(String str) {
        int balance = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') balance++;
            else if (c == ')') balance--;
            if (balance < 0) return false; // invalid
        }
        return balance == 0;
    }

    // function to calculate depth
    private int calculateDepth(String str) {
        int counter = 0, maxCounter = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                counter++;
                maxCounter = Math.max(maxCounter, counter);
            } else if (c == ')') {
                counter--;
            }
        }
        return maxCounter;
    }
}

// ✔ Time Complexity (TC) → O(n^3)
// Substrings generate karna → O(n^2)
// Har substring ke liye validity + depth check → O(n)

// ✔ Space Complexity (SC) → O(1)



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


