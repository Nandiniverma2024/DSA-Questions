class Solution {
    public int numberOfSubstrings(String s) {
        int left=0, right=0;
        // Length => ei -si (n-r)
        int count=0;
        int n=s.length();
        int freq[]=new int[3];
        while(right<n){
            char ch=s.charAt(right);
            freq[ch-'a']++;
            while(freq[0]>=1 && freq[1]>=1 && freq[2]>=1){
                count+=(n-right); //calculate length for all substring starts with abc
                freq[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return count;
    }
}