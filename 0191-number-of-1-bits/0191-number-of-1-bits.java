class Solution {
    public int hammingWeight(int n) {
        int res=0; 
        for(int i=0; i<32; i++){
            res += n&1; //for tracking count
            n=n>>1; //(lsb i.e last bit n ke right shit se decide hogi)
        }
        return res;
    }
}

// eg => n=13 , i.e 1011 
// 1 -> n&1 => 1101 & 0001 => cnt=1 then n>>1  =>  101 
// 2 -> n&1 =>  101 & 0001 => cnt=2 then n>>1  =>  10 
// 3 -> n&1 =>   10 & 0001 => cnt=2 then n>>1  =>   1 
// 4 -> n&1 =>    1 & 0001 => cnt=3 then n>>1  =>   0 


