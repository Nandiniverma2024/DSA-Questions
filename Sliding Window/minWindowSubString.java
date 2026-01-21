// 76. Minimum Window Substring
// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
// The testcases will be generated such that the answer is unique.

// Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.


// Approach
// Right pointer se window expand karo jab tak valid na ho jaye,
// phir left pointer se shrink karo jab tak invalid na ho jaye,
// aur har valid window me minimum update karo.

// Code
class Solution {
    public String minWindow(String s, String t) {
        int left=0, right=0;
        int countReq=t.length(),currWin=0, minWin=Integer.MAX_VALUE;
        int start_left=0; // for storing starting index of window
        // Base Case
        if(t.length()>s.length()){
            return "";
        }
        // Convert s string into character Array
        char sArr[]=s.toCharArray();

        // For t string
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }
        // Sliding Window
        while(right<sArr.length){
            char ch = sArr[right];
            if(map.containsKey(ch)){
                if(map.get(ch)>0){ // agr map m el. ki freq > 0 ya +ve h, to decrease count 
                    countReq--;
                }
                map.put(ch, map.get(ch)-1); // and also decrease freq of that character in map
            }
            // Window Shrinking (when got all req characters)
            while(countReq == 0){ 
                currWin=right-left+1;
                if(minWin>currWin){ // update min window and window starting index
                    minWin=currWin;
                    start_left=left;
                }
                // check if left character is required character
                char leftChar=sArr[left];
                // agr left character t ka part tha then put into map
                // and update required count
                // required count increase only if freq of required character is +ve
                if(map.containsKey(leftChar)){
                    map.put(leftChar, map.get(leftChar)+1);
                    if(map.get(leftChar)>0){
                        countReq++;
                    }
                }
                left++; // window shrinking
            }
            right++;
        }
        // if min window still equal to MAXVALUE then return empty string
        // else return substring of min length containing t string
        return minWin==Integer.MAX_VALUE ? "" : s.substring(start_left, start_left+minWin);
    }
}


// TC
// O(n)

// SC
// O(1)
// HashMap me sirf characters of t store hote h


