// 1759. Count Number of Homogenous Substrings
// Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.
// A string is homogenous if all the characters of the string are the same.
// A substring is a contiguous sequence of characters within a string.
 

// Example 1:

// Input: s = "abbcccaa"
// Output: 13
// Explanation: The homogenous substrings are listed as below:
// "a"   appears 3 times.
// "aa"  appears 1 time.
// "b"   appears 2 times.
// "bb"  appears 1 time.
// "c"   appears 3 times.
// "cc"  appears 2 times.
// "ccc" appears 1 time.
// 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.



// PATTERN => CONSECUTIVE GROUP COUNTING OF SAME ELEMENT

// CODE

class Solution {
    public int countHomogenous(String s) {
        int MOD = 1_000_000_007;
        int result=0;
        int length=0;
        int n=s.length();
        for(int i=0; i<n; i++){
            if(i>0 && s.charAt(i)==s.charAt(i-1)){ // i>0 , since we need to check for the (i-1)th index also
                length+=1;
            }else{
                length=1;
            }
            result=(result+length)%MOD; //to prevent from overflow
        }
        return result;
    }
}


