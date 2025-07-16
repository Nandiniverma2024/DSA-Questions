
import java.util.*;

// BruteForce
class Solution {
    public String frequencySort(String s) {
        StringBuilder result = new StringBuilder();
        boolean[] used = new boolean[s.length()];

        while (result.length() < s.length()) {
            char maxChar = 0;
            int maxFreq = 0;

            // Count frequency of each unused character
            for (int i = 0; i < s.length(); i++) {
                if (used[i]) continue;
                char c = s.charAt(i);
                int count = 0;

                for (int j = 0; j < s.length(); j++) {
                    if (!used[j] && s.charAt(j) == c) {
                        count++;
                    }
                }

                if (count > maxFreq) {
                    maxFreq = count;
                    maxChar = c;
                }
            }

            // Append the maxChar maxFreq times
            for (int i = 0; i < maxFreq; i++) {
                result.append(maxChar);
            }

            // Mark all occurrences of maxChar as used
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == maxChar) {
                    used[i] = true;
                }
            }
        }

        return result.toString();
    }
}



// Time Complexity	    ❌ O(n²)
// Space Complexity	✅ O(n)


// Optimal Solution
class Solution {
    public String frequencySort(String s) {
        // convert string into character Array
        char[] sArr = s.toCharArray();
        // Build frequency map
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : sArr){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        // Convert HashMap to list(of entries) and sort by it's frequency
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        // sort entries by frequency in decending order
        list.sort((a,b) -> b.getValue()-a.getValue());

        // Build result string
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : list){
            char ch = entry.getKey();
            int freq = entry.getValue();
            for(int i = 0; i < freq; i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}


// Time Complexity	O(n + k log k) → worst: O(n log n)
// Space Complexity	O(n + k) → worst: O(n)


