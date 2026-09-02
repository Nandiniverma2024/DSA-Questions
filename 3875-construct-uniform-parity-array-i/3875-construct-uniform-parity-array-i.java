class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        boolean flag=false;

        // agr sare even el h
        for(int i=0; i<n; i++){
            if(nums1[i]%2==0){
                return true;
            }
        }
        // agr odd el h
        for(int i=0; i<n; i++){
            if(nums1[i]%2!=0){
                return true;
            }
        }

        if(nums1[n-1]%2 == 0){ //even
            for(int i=0; i<n-1; i++){
                if( (nums1[i]%2!=0 || (nums1[i]-nums1[i+1]) %2 ==0 ) && (nums1[i]%2==0 || (nums1[i]-nums1[i+1]) %2 !=0)){
                    return false;
                }
            }
        }else if(nums1[n-1]%2 != 0){ //odd
             for(int i=0; i<n-1; i++){
                if((nums1[i]%2==0 || (nums1[i]-nums1[i+1]) %2 !=0 ) && (nums1[i]%2!=0 || (nums1[i]-nums1[i+1]) %2 ==0)){
                    return false;
                }
            }
        }

        return true;
    }
}