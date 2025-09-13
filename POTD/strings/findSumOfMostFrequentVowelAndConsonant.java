// 3541. Find Most Frequent Vowel and Consonant
// You are given a string s consisting of lowercase English letters ('a' to 'z').
// Your task is to:

// Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum frequency.
// Find the consonant (all other letters excluding vowels) with the maximum frequency.
// Return the sum of the two frequencies.
// Note: If multiple vowels or consonants have the same maximum frequency, you may choose any one of them. If there are no vowels or no consonants in the string, consider their frequency as 0.
// The frequency of a letter x is the number of times it occurs in the string.
 

// Example 1:
// Input: s = "successes"
// Output: 6
// Explanation:
// The vowels are: 'u' (frequency 1), 'e' (frequency 2). The maximum frequency is 2.
// The consonants are: 's' (frequency 4), 'c' (frequency 2). The maximum frequency is 4.
// The output is 2 + 4 = 6.



// PATTERN -> FREQUENCY COUNTING

✅ Time Complexity (TC):
// Step 1 (Frequency Array Build):
O(n) → where n = length of string s.
// Step 2 (Scan 26 letters):
O(26) → Constant time, can be approximated as O(1).
Overall TC → O(n)


✅ Space Complexity (SC):
Frequency array size → 26 (for 'a' to 'z') → O(26) → which is O(1) constant space.
Other variables use constant space → O(1).
Overall SC → O(1)


// CODE
class Solution {
    public int maxFreqSum(String s) {
        // build freq Array
        int[] freq = new int[26];
        // Find freq of all characters adn update in freq Array
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        int maxVowel=0;
        int maxConsonant=0;
        // From Freq Array Find which Vowel and Which Consonant have maxCount
        for(int i=0; i<26; i++){
            char ch=(char)(i+'a');//convert index into characters for easy understanding
            if(isVowel(ch)){
                maxVowel=Math.max(maxVowel, freq[i]);
            }else{
                maxConsonant=Math.max(maxConsonant, freq[i]);
            }
        }
        return maxVowel+maxConsonant;
    }
    // Function to find vowel
    private boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}



// 1st loop m ek freq array banugi or usme sare el.s ki freq store kr dungi 
// ki koi el 2 bar aaya koi 3 bar , iski lia m freq[ch-'a'} karungi 
// fir usi freq array pr loop chalungi or check karungi ki kis characters m se 
// kis vowel ka count sabse jyada h or consonant m se kis consonant ka count sabse jyada h, 
// jis vowel and jis consonant ka count sabse jayda hoga , us count ko leke dono ka sum krke return kr dungi 
// or vowel kon sa h or consonant kon sa isa pata krne ke lia m ek isVowel 
// krke function bna ke check kr lungi or fir usse return kr dungi




