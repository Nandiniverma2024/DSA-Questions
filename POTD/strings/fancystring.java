// 1957. Delete Characters to Make Fancy String
// A fancy string is a string where no three consecutive characters are equal.

// Given a string s, delete the minimum possible number of characters from s to make it fancy.

// Return the final string after the deletion. It can be shown that the answer will always be unique.


// Approach
import java.util.*;
class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            // initially add all characters to result
            result.append(ch);
            // calculate result length
            int len = result.length();
            // check if last 3 elements are same
            if(len>=3 && result.charAt(len-1)==result.charAt(len-2) && result.charAt(len-2) == result.charAt(len-3)){
                // if yes then delete last character
                result.deleteCharAt(len-1);
            }
        }
        return result.toString();
    }
}



// Time Complexity: O(n)
// Space Complexity: O(n) (for storing final result in StringBuilder)

// Dry Run for input: leeetcode
// Added 'l' at index 0 → result: l
// Added 'e' at index 1 → result: le
// Added 'e' at index 2 → result: lee
// Deleted 'e' at index 3 → result: lee
// Added 't' at index 4 → result: leet
// Added 'c' at index 5 → result: leetc
// Added 'o' at index 6 → result: leetco
// Added 'd' at index 7 → result: leetcod
// Added 'e' at index 8 → result: leetcode

// Final Fancy String: leetcode



