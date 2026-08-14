class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int totalSum=0;

        // Find totalSum
        for(int i=0; i<n; i++){
            totalSum+=cardPoints[i];
        }

        // agr total cards hi k h , to vo hi to maximum honge
        if(n==k){
            return totalSum;
        }


        // sliding window
        // (maxSum k cards left ya right se niklne ke lia , find array ke mid m present minimum cards)
        int left=0, right=0;
        int sum=0, minSum=Integer.MAX_VALUE;

        while(right<n){
            // globally sum cal krne se => hr iteration m add hoga
            sum+=cardPoints[right];
            if(right-left+1 < n-k){
                right++;
            }else if(right-left+1 == n-k){
                minSum=Math.min(minSum, sum);
                // Move the fixed size window
                sum-=cardPoints[left];
                left++;
                right++;
            }
        }
        // maxSum=totalSum-minSum;
        return totalSum-minSum;
    }
}


// Goal => find max k Cards either from left or from right