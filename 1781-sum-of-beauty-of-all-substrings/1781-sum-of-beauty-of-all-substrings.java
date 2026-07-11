class Solution {
    public int beautySum(String s) {
        int n=s.length();
        int beauty=0;
        for(int i=0; i<n; i++){

            int freq[]=new int[26];

            for(int j=i; j<n; j++){ //generate substring 

                char ch=s.charAt(j);
                freq[ch-'a']++;

                // calculate min and max freq for each substring
                int maxFreq=Integer.MIN_VALUE, minFreq=Integer.MAX_VALUE;
                for(int k=0; k<freq.length; k++){
                    if(freq[k]>0){
                        maxFreq=Math.max(maxFreq, freq[k]);
                        minFreq=Math.min(minFreq, freq[k]);
                    }
                }
                beauty+=maxFreq-minFreq;
            }
        }
        return beauty;
    }
}