import java.util.*;


// 28. Find the Index of the First Occurrence in a String

// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

// Brute Force Approach

public class firstoccurrenceindex {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        // Loop through each possible starting index in haystack
        for (int i = 0; i <= m - n; i++) {
            int j = 0;

            // Check characters from current i in haystack with needle
            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            // If full needle matched
            if (j == n) return i;
        }

        // No match found
        return -1;
    }
}

// Time Complexity: O(m + n) [internally optimized]
// Space Complexity: O(1)




// Better Approach - Using two-pointers
// ✅ Two-Pointer Sliding Window Approach

public class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        // Slide a window of length n over haystack
        for (int i = 0; i <= m - n; i++) {
            // Get substring from i to i+n
            String window = haystack.substring(i, i + n);

            // Compare with needle
            if (window.equals(needle)) {
                return i;
            }
        }

        return -1; // Not found
    }
}

// Time Complexity: O(m * n)
// Space Complexity: O(1)



// Optimal Approach
// using Java's built-in indexOf()

public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle); // Clean and efficient
    }
}

// Time Complexity: O(m + n) [internally optimized]
// Space Complexity: O(1)



