class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;

        int smal[]=new int[n1];
        int lar[]=new int[n2];

        if(n1<n2){
            smal=nums1;
            lar=nums2;
        }else{
            smal=nums2;
            lar=nums1;
        }
        

        int totalLen=n1+n2;

        int start=0, end=smal.length;

        // px=> partition X, py=> partition Y
        while(start<=end){
            int px=start+(end-start)/2;
            int py=(n1+n2+1)/2-px;

            int maxLeftNums1=(px==0)?Integer.MIN_VALUE:smal[px-1];
            int minRightNums1=px==smal.length?Integer.MAX_VALUE:smal[px];
            int maxLeftNums2=py==0?Integer.MIN_VALUE:lar[py-1];
            int minRightNums2=py==lar.length?Integer.MAX_VALUE:lar[py];

            if(maxLeftNums1 <= minRightNums2 && maxLeftNums2<=minRightNums1){
                // Even
                if(totalLen%2==0){
                    return ((double)(Math.max(maxLeftNums1, maxLeftNums2)+Math.min(minRightNums1, minRightNums2))/2);
                }else{
                    return Math.max(maxLeftNums1, maxLeftNums2);
                }
            }
            

            if(maxLeftNums1>minRightNums2){
                end=px-1;
            }else{
                start=px+1;
            }
        }
        return 0;
    }
}