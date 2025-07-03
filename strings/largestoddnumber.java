import.java.util.*;

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
