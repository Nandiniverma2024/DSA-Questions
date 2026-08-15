class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        
        int totalXor=0, len=nums.length;
        for(int i=0; i<n; i++){
            totalXor=totalXor^nums[i];
        }
        
        if(totalXor!=0){
            return len;
        }

        // agr totalXor 0 h
        // yha hm aasa non zero el dund rhe h , jiski wajah se totalXor 0 hua h
        for(int i=0; i<n; i++){
            if((totalXor^nums[i]) != 0){
                len--;
                break;
            }
            // eg => 2^3^4^5 = 0 (let totalXor 0 aaya)
            // Again iterate => ((2^3^4^5)  ^ 2) != 0), i.e 2 se 2 cancel ho jayga (2 hi vo el tha jo pura xor ko 0 bna rha tha)
            // 3^4^5 => inka reslt != 0
        }
        // ans non-zero el abi tak nhi mila
        // to totalXor isilye 0 h, kuki array ke sare el 0 h
        if(len==n){
            return 0;
        }
        return len;
    }
}

// << => left shift
// >> => Right shift