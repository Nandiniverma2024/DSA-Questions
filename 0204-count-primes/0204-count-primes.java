class Solution {
    public int countPrimes(int n) {
        if(n<2){
            return 0;
        }
        boolean isPrime[]=new boolean[n];

        for(int i=2; i<n; i++){
            isPrime[i]=true;
        }

        for(int i=2; i<Math.sqrt(n); i++){
            // prime number ke sare multiples ko false bna de
            if(isPrime[i]){
                for(int j=i*i; j<n; j+=i){
                    isPrime[j]=false;
                }
            }
        }

        int cnt=0;
        for(int i=2; i<n; i++){
            if(isPrime[i]){
                cnt++;
            }
        }

        return cnt;
    }
}