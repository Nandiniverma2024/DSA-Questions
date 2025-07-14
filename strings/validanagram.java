// 242. Valid Anagram

// Given two strings s and t, return true if t is an anagram of s, and false otherwise.


import java.util.*;

// BruteForce Approach
// first convert both strings into character arrays
// sort both the arrasy , then check if both arrays are equal

class Solution {
    public boolean isAnagram(String s, String t) {
        // If string lengths are not equal than they never be an anagram
        if(s.length() != t.length()){
            return false;
        }
        // Convert both strings into character arrays(takes )(n) space)
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        // sort both arrays and check if, both arrays are equal
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        if(Arrays.equals(sarr,tarr)){
            return true;
        }
        // else return false
        return false;
    }
}


// Time and space complexities
// tc -> O(nlogn)(due to sorting)
// sc -> O(n) (since created two new arrays)


