// 205. Isomorphic Strings

// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



// ✅ Brute Force Approach:
// For each character in s, find its matching character in t at the same position.

// Check the entire string to ensure that:

// Wherever this s character appears, the same t character appears at the same index.

// No other s character maps to the same t character.

// If any mismatch is found, return false. Otherwise, return true.

// ⏱️ Time Complexity (TC):
// O(n²)

// 💾 Space Complexity (SC):
// O(1)



// Optimal Approach

import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Step 1: If String lengths are different can't be isomorphic
        if (s.length() != t.length()) return false;

        // Step 2: create map -> jisme 's' ke characters ka mapping 't' ke characters se hoga
        HashMap<Character, Character> map = new HashMap<>();

        // Step 3:Create HashMap to check -> if Character from 't' string has already map with some other character 
        HashSet<Character> used = new HashSet<>();

        // Step 4: Run loop for characters of both strings
        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);  // 's' string ka current character
            char chT = t.charAt(i);  // 't' string ka current character

            // Step 5: If chS already present in mapST
            if (map.containsKey(chS)) {
                // Check -> pehle jis character pe map hua tha wohi ab bhi hai ya nahi
                if (map.get(chS) != chT)
                    return false;  // Agar nahi hai to consistent mapping nahi, hence not isomorphic
            } else {
                // Step 6: Agar chT kisi aur chS ke sath pehle hi map ho chuka hai, then invalid
                if (used.contains(chT))
                    return false;  // ek t character ko 2 s character nahi mil sakte

                // Step 7: Map s→t and mark t character as used
                map.put(chS, chT);
                used.add(chT);
            }
        }

        // Step 8: Loop ke baad agar koi problem nahi aayi to strings are isomorphic
        return true;
    }
}


// ⏱️ Time Complexity (TC):
// O(n)

// 💾 Space Complexity (SC):
// O(1) (constant)



// A brute-force solution guarantees that a solution to the problem exists
