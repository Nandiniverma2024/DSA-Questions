class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        // Step1 : Count freq
        // we can only find maxFreq using index
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;//convert character into index
        }
        int maxVowel=0;
        int maxCons=0;
        // Step2 : Among all letters a to z find maxVowel Count and maxCons Count
        // find max character count of vowel and consonant, we need character
        // for this convert index into character 
        for(int i=0; i<26; i++){
            char ch=(char)(i+'a');// index i → character ch
            if(isVowel(ch)){
                maxVowel=Math.max(maxVowel, freq[i]);
            }else{
                maxCons=Math.max(maxCons, freq[i]);
            }
        }
        return maxVowel+maxCons;
    }
    private boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}
