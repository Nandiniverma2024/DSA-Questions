class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set=new HashSet<>();

        for(int n : nums){
            while((n&1)==0){
                set.add(2);
                n=n>>1; //n divide by 2
            }
            
            // check for the odd/prime factors
            for(int i=3; i*i<=n; i+=2){
                while(n%i == 0){
                    set.add(i);
                    n/=i;
                }
            }
            
            // Jo kisi se na kata, vo khud se katega
            if(n>1){
                set.add(n);
            }
        }

        return set.size();
    }
}