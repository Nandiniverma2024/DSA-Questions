
import java.util.*;

// BruteForce
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        StringBuilder sb = new StringBuilder();

        while(!map.isEmpty()){
            char maxChar = ' ';
            int maxFreq = 0;
            for(char c : map.keySet()){
                int freq = map.get(c);
                if(freq>maxFreq){
                    maxChar=c;
                    maxFreq=freq;
                }
            }
            for(int i=0; i<maxFreq; i++){
                sb.append(maxChar);
            }
            map.remove(maxChar);
        }
        return sb.toString(); 
    }
}



// WHY NOT TLE => Limited character set, matlab k (distinct chars) ki 
// upper bound ≈ 26 (lowercase), ya max 128 (extended ASCII).

// worst case me bhi k^2 = 26^2 = 676 comparisons hi lagte hain — 
// ye negligible hai compared to n


// Time Complexity  , Total TC = O(n + k^2)
// O(n) → map banane ke liye
// O(k^2) -> max nikalne ke lia saare chars traverse hote h
// O(n) -> String append ke liye



// Space Complexity	, Total SC = O(n + k)
// O(k) → HashMap me freq store karne ke lia
// O(n) → StringBuilder result store karne ke lia



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


