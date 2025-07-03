import java.util.*;

// BruteForce approach

class Solution {
    public String largestOddNumber(String num) {
        String result = "";
        for (int i = 0; i < num.length(); i++) {
            String sub = num.substring(0, i + 1);
            // If the last number of string is odd,i.e it is an odd number, return substring from index zero to that number
            if ((sub.charAt(sub.length() - 1) - '0') % 2 != 0) {
                result = sub;
            }
        }
        return result;
    }
}


// ⏱ Time Complexity: O(n²)
// 📦 Space Complexity: O(n) (due to repeated substring creation)




// Optimal approach

class Solution {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            char ch = num.charAt(i);  
            // Check if current character is an odd digit
            if ((ch - '0') % 2 != 0) {
                // If it's odd, return the substring from 0 to i+1(portion of that string)
                return num.substring(0, i + 1);
            }
        } 
        // If no odd digit found, return empty string
        return "";
    }
}


// Time and space complexity
// ⏱ Time Complexity: O(n)
// 📦 Space Complexity: O(1)

