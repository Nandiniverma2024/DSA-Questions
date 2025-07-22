// 20. Valid Parentheses
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 
//Link : https://leetcode.com/problems/valid-parentheses/description/


// Approach
// Traverse the string and push every opening bracket to a stack.
// On encountering a closing bracket, pop from the stack and check if it matches the correct type.
// If the stack is empty at the end, return true; else, return false (some brackets unmatched).


class Solution {
    public boolean isValid(String s) {
        // Create a stack to track opening brackets
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            // If character is an opening bracket, push to stack
            if(ch == '(' || ch == '[' || ch =='{'){
                stack.push(ch);// Store for matching later
            }else if(ch == ')' || ch == ']' || ch == '}'){
                // Stack is empty means no matching opening bracket
                // agr stack khali h , mltb koi opening bracket nhi h stack m , to invalid ho gya
                if (stack.isEmpty()){
                    return false; //Invalid
                }
                // Pop the last opening bracket from stack
                // ek ek krke sare opening brackets ko stack se bhar nikalnge,
                // check krnge if they match with closing one's or not
                char opening = stack.pop();
                 // Check if current closing bracket matches opening bracket
                 if((ch == ')' && opening != '(')||
                    (ch == ']' && opening != '[')||
                    (ch == '}' && opening != '{')){
                        return false;
                }
            }
        }
        // After processing all characters
        // If stack is empty, all brackets matched correctly
        return stack.isEmpty();
    }
}



// Time: O(n) — Single pass through the string
// Space: O(n) — Worst-case all opening brackets stored in stack


