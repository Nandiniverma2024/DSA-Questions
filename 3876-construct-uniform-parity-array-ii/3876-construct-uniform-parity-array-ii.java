class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean  allEven=true;
        boolean  allOdd=true;
        for(int i=0; i<nums1.length; i++){
            if(nums1[i]%2 != 0){
                allEven=false;
            }
        }
        for(int i=0; i<nums1.length; i++){
            if(nums1[i]%2 == 0){
                allOdd=false;
            }
        }

        if(allEven || allOdd){
            return true;
        }

        // Mix parity, find minimum
        int min=nums1[0];
        for(int i=1; i<nums1.length; i++){
            min=Math.min(nums1[i],min);
        }
        // min => odd( even-odd or odd-even => odd)
        if(min%2 != 0){
            return true;
        }
        // min => even then (even-odd or odd-even => odd)
        // inka differnce kbi even nhi aayga
        return false;
    }
}