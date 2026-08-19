class Solution {
    public int maxVowels(String s, int k) {
        int left=0, right=0;
        int n=s.length();
        int cnt=0, maxCnt=Integer.MIN_VALUE;
        while(right<n){
            char ch=s.charAt(right);
            // cal cnt in each iteration
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                cnt++;
            }
            if(right-left+1 < k){
                right++;
            }else if(right-left+1 == k){
                maxCnt=Math.max(maxCnt, cnt);
                char chL=s.charAt(left);
                if(chL=='a' || chL=='e' || chL=='i' || chL=='o' || chL=='u'){
                    cnt--;
                }
                left++;
                right++;
            }
        }
        return maxCnt;
    }
}