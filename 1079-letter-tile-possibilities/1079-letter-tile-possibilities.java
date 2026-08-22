class Solution {
    public int numTilePossibilities(String tiles) {
        int freq[]=new int[26];
        for(int i=0; i<tiles.length(); i++){
            char ch=tiles.charAt(i);
            freq[ch-'A']++;
        }

        return solve(freq);
    }
    public int solve(int freq[]){
        int count=0;
        for(int i=0; i<26; i++){
            if(freq[i]==0){
                continue;
            }
            count++;

            freq[i]--;
            count+=solve(freq);
            // backtrack
            freq[i]++;
        }
        return count;
    }
}