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





// Better Solution
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}


// tc adn sc -> O(N*M)	O(1)