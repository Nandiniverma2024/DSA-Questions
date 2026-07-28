class Solution {
    public String smallestPalindrome(String s) {
        // Base case
        if(s.length()==1){
            return s;
        }

        int n=s.length();

        int freq[]=new int[26];
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }

        // Generating left part of palindrome
        StringBuilder left=new StringBuilder();
        
        // Check for middle part, for odd palindrome
        char middle='\0'; //inilitially middle have null character
        
        for(int i=0; i<freq.length; i++){
            // add char for left part
            for(int j=0; j<freq[i]/2; j++){
                left.append((char)(i+'a'));
            }
            // add char in middle for odd palindrome
            if(freq[i]%2==1){
                middle=(char)(i+'a');
            }
        }

        // So my original value of left will not changes
        String right=new StringBuilder(left).reverse().toString();
        // right.reverse();


        // if have even palindrome
        if(middle=='\0'){
            return left.toString()+right;
        }

        return left.toString()+middle+right;
    }
}