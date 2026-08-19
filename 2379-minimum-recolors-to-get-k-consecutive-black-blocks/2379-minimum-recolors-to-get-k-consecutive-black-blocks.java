class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left=0, right=0, n=blocks.length();
        int cnt=0, minCnt=Integer.MAX_VALUE;
        // return min num of whites in win of size k
        while(right<n){
            char ch=blocks.charAt(right);
            if(ch=='W'){
                cnt++;
            }
            if(right-left+1 < k){
                right++;
            }else if(right-left+1 == k){
                minCnt=Math.min(minCnt, cnt);
                if(blocks.charAt(left)=='W'){
                    cnt--;
                }
                left++;
                right++;
            }
        }
        return minCnt;
    }
}