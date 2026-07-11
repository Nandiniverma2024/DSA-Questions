class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();

        // i=> mid,
        // start => staring point of palindrome
        int start=0; //use to return substring

        int maxLen=Integer.MIN_VALUE;
        for(int i=0; i<s.length(); i++){
            // for odd length String
            int len1=expand(s,i,i); //since point to same idx(only have 1 mid)
            int len2=expand(s,i,i+1); //since point to same idx(only have 1 mid)
            int currLen=Math.max(len1, len2); // len of curr palindrome

            // Find length of longest palindrome
            if(currLen>maxLen){
                maxLen=currLen;
                // start is differnet for each palindrome
                // start => mid - mid
                start=i-(currLen-1)/2; //currLen-1 => give last index of curr palindrome
            }
        }
        return s.substring(start,start+maxLen);
    }
    public int expand(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        // (right-1) - (left+1) +1 =>r-1-l-1+1 => r-l-1
        return (right-1)-(left+1)+1; //return length
    }
}