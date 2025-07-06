// 14. Longest Common Prefix

// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

// BruteForce
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        // set )th row string as prefix
        String prefix = strs[0];

        // Check for other Strings from row 0
        for(int i=0; i<strs.length; i++){
            // compare charcter of prefix string to current strings
             while(strs[i].indexOf(prefix) != 0){

                prefix = prefix.substring(0 , prefix.length()-1);

                // After comparison , if no comman prefix found , return empty string
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }
}

// tc and sc -> 	O(N*M)	O(1)