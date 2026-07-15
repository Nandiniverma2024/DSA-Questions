class Solution {
    public int gcdOfOddEvenSums(int n) {
        int evenSum=n*(n+1);
        int oddSum=n*n;
        return gcd(evenSum, oddSum);
    }
    public int gcd(int evenSum , int oddSum){
        if(evenSum>oddSum){
            evenSum = evenSum % oddSum;
        }else{
            oddSum = oddSum % evenSum;
        }

        if(evenSum==0){
            return oddSum;
        }
        return evenSum;
    }
}

// int count=0;
        // while(count<=n){
        //     if(n%2==0){
        //         evensum+=n;
        //         count++;
        //     }
        // }
