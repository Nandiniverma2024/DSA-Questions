class Solution {
    public int gcdOfOddEvenSums(int n) {

        // Calculate odd and evenSum without formula
        int evenSum = 0;
        int oddSum = 0;

        for (int i = 1; i <= n; i++) {
            evenSum += 2 * i;
            oddSum += 2 * i - 1;
        }
       
        while(evenSum%oddSum != 0){
            int rem=evenSum % oddSum;
            evenSum=oddSum;
            oddSum=rem;
        }
        return oddSum;
    }
}


