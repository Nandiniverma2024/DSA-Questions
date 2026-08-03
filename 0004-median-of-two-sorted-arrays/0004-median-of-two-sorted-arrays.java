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

        // Define range based on smallest array
        int start=0, end=smal.length;

        // px=> partition X, py=> partition Y
        while(start<=end){
            // Mid for partition in smallest array
            int px=start+(end-start)/2;
            // partition in largest array
            int py=(n1+n2+1)/2-px;

            int l1= (px==0) ? Integer.MIN_VALUE : smal[px-1];
            int r1= px==smal.length ? Integer.MAX_VALUE : smal[px];
            int l2= py==0 ? Integer.MIN_VALUE : lar[py-1];
            int r2= py==lar.length ? Integer.MAX_VALUE : lar[py];


            // All elements in left must bs smaller than all elements in right
            if(l1 <= r2 && l2<=r1){
                // check if merges array is odd or even
                // Even
                if(totalLen%2==0){
                    return ((double)(Math.max(l1, l2)+Math.min(r1, r2))/2);
                }else{
                    return Math.max(l1, l2);
                }
            }
            

            // if l1>r2 
            if(l1>r2){
                end=px-1;      // eleminate right half
            }else{
                start=px+1;    // eleminate right half
            }
        }
        return 0;
    }
}