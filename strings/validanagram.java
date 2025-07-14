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



// Optimal Approach

class Solution {
    public boolean isAnagram(String s, String t) {
        // If string lengths are not equal then they never be an anagram
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];

        // This loop tracks character count of s and t
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // If all values are zeros , then it's an anagram
        for(int i=0; i<26; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
}


// s.charAt(i) - 'a' -> meaning
// Character	ASCII	'char' - 'a'	Index in count[]
//    'a'	     97	     97 - 97 = 0	     0
//    'b'	     98	     98 - 97 = 1	     1
//    'z'	     122     122 - 97 = 25	     25



// Time and space complexity
// tc -> O(n + 26) = O(n)
// sc -> O(1) (since, only create a fixed size array count)




