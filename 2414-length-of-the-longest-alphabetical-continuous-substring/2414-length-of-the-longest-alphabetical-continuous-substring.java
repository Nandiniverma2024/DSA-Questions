class Solution {
    public int longestContinuousSubstring(String s) {
        char charArr[]=s.toCharArray();
        int cnt=1, maxCnt=1;
        int freqArr[]=new int[26];
        for(int i=1; i<charArr.length; i++){
            // store integer val in charArr rather then  
            // after converting char literal into integer literal
            int idx=charArr[i]-'a';
            if(charArr[i] == charArr[i-1] + 1){
                cnt++;
            }else{
                cnt=1; //reset cnt
            }
            maxCnt=Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }
}