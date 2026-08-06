class Solution {
    public int countGoodNumbers(long n) {
        int MOD=1_000_000_007;
        long evenCnt=(n+1)/2;
        long primeCnt=n/2;

        long evenWays=power(5, evenCnt);
        long primeWays=power(4, primeCnt);

        return (int)((evenWays*primeWays)%MOD);
    }
    // bianry exponentiation method
    public long power(long x, long n) {
        int MOD = 1_000_000_007;
        // base case
        if(n == 0) {
            return 1;
        }

        long half = power(x, n/2);

        if(n%2 == 0) {
            return (half * half) % MOD;
        }

        return (x * half * half) % MOD;
    }
}

// n = 4

// idx    0  1  2  3
//        |  |  |  |
// com    5  4  5  4

// total combinations = 5*4*5*4 = 400
