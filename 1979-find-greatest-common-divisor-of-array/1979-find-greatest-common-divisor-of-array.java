class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        return gcd(nums[0], nums[n-1]);
    }
    public int gcd(int n1, int n2){
        while(n1!=0 && n2!=0){
            if(n1>n2){
                n1=n1%n2;
            }else{
                n2=n2%n1;
            }
        }

        if(n1==0){
            return n2;
        }

        return n1;
    }
}