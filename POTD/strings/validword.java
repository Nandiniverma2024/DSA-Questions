// A word is considered valid if:

// It contains a minimum of 3 characters.
// It contains only digits (0-9), and English letters (uppercase and lowercase).
// It includes at least one vowel.
// It includes at least one consonant.
// You are given a string word.

// Return true if word is valid, otherwise, return false.

// Notes:

// 'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
// A consonant is an English letter that is not a vowel.


// Approach
class Solution {
    public boolean isValid(String word) {
        if (word == null || word.length() < 3) return false;

        boolean hasVowel = false;
        boolean hasConsonant = false;

        // Check each character
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            // Invalid character → return false
            if (!Character.isLetterOrDigit(ch)) return false;

            // If it's a letter, check vowel or consonant
            if (Character.isLetter(ch)) {
                char lower = Character.toLowerCase(ch);
                if ("aeiou".indexOf(lower) >= 0) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }

        // Only return true if both vowel and consonant are found
        return hasVowel && hasConsonant;
    }
}



// Time Complexity	O(n)
// Space Complexity	O(1)


