// 5. Longest Palindromic Substring
// Given a string s, return the longest palindromic substring in s.

// Example 1:
// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:

// Input: s = "cbbd"
// Output: "bb"










// Approach
// Loop each char as center → expand for odd & even → 
// pick max length → update start/end → finally return substring


// Code
class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<1){
            return "";
        }
        int start=0, end=0;
        for(int i=0; i<s.length(); i++){
            int len1=expandFromCenter(s,i,i);//odd length palindrome
            int len2=expandFromCenter(s,i,i+1);//even length palindrome
            int len=Math.max(len1,len2);
            // If New plaindrome length is greater then the old one, update start and end
            if(len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    private int expandFromCenter(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}




✅ TC: O(n²)
// expandFromCenter worst case expand till the entire string → O(n)
// Loop runs n times → total worst-case O(n²)



✅ SC: O(1) (constant space)
// We are only using a few integers (start, end, len1, len2)
// No extra array or recursion



Pattern
// Expand Around Center Pattern




// EDGE CASES
Empty string → ""
Single character → "a"
All same characters → "aaaa"
Even length palindrome → "abba"
Odd length palindrome → "aba"
Multiple palindromes of same max length → "babad"




