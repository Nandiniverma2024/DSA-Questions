class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int cnt=0, sum=0;
        int odd=0;
        int even=1; //empty sum => i.e 0 ye bi even h , to even=1

        int mod=1_000_000_007;
        
        for(int i=0; i<n; i++){
            sum+=arr[i];
            if(sum%2==0){ // curr sum even
                cnt=(cnt+odd)%mod; //make odd subarray from odd prefix parity
                even++;
            }else{ //curr sum odd
                cnt=(cnt+even)%mod; //make odd subarray from even prefix parity
                odd++;
            }
        }
        return cnt;
    }
}