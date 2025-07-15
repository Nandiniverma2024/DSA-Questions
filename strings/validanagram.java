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


// Better Approach(using HashMap)
// convert s and t into character array, put s characters and
// it's frequency count into hashmap, check if t characters 
// present in hashmap, if yes decrease count
// if get empty array that measn count is balanced, valid anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        // if length are not equal, they can't be anagrams
        if(s.length() != t.length()){
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        // convert strings into character array
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        // store frequency count of characters from string s
        for(char c : sArr){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        // if t charactes are not present in map,then never be an anagram
        for(char c : tArr){
            if(!map.containsKey(c)){
                return false;
            }
            // reduce character count of s if that character also present in t 
            map.put(c,map.get(c)-1);

            // If character count becomes 0, remove character from the map
            if(map.get(c)==0){
                map.remove(c);
            }
        }
        // If map becomes empty that means all characters are matched , and it is an anagram
        return map.isEmpty();
    }
}


// Time Complexity -> 	    O(n)
// Space Complexity ->  	O(1) 



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




