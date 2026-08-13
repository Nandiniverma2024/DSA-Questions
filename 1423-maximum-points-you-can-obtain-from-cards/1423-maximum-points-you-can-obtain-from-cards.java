class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int left=0, right=0;
        int sum=0, minSum=Integer.MAX_VALUE;
        int totalSum=0;
        for(int i=0; i<cardPoints.length; i++){
            totalSum+=cardPoints[i];
        }

        if(n==k){
            return totalSum;
        }
        while(right<n){
            sum+=cardPoints[right];
            if(right-left+1 < n-k){
                right++;
            }else if(right-left+1 == n-k){
                minSum=Math.min(minSum, sum);
                sum-=cardPoints[left];
                left++;
                right++;
            }
        }
        
        return totalSum-minSum;
    }
}


// find window size of n-k , such it have minimum value(minimum el => kuki mid wale el h , or inki window hogi hi hogi)

// totaklcards i.e n (k cards window nhi bna rhe)
// totalcards-k , i.e => (n-k)
