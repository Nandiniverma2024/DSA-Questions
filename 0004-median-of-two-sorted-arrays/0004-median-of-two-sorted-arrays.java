class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0, j=0, k=0;
        int n=nums1.length, m=nums2.length;
        double temp[]=new double[m+n];

        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                temp[k]=nums1[i];
                i++;
                k++;
            }else{
                temp[k]=nums2[j];
                j++;
                k++;
            }
        }

        // LeftOvers
        while(i<n){
            temp[k]=nums1[i];
            i++;
            k++;
        }
        while(j<m){
            temp[k]=nums2[j];
            j++;
            k++;
        }

        // Median
        int len=temp.length;
        int idx=len/2;

        if(len%2==0){
            return (temp[idx-1]+temp[idx])/2;
        }

        return temp[idx];
    }
}