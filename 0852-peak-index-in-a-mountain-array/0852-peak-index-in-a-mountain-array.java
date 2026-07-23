class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        int start=0, end=n-1;
        int res=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            int prev=(mid-1>=0)?arr[mid-1]:Integer.MIN_VALUE;
            int next=(mid+1<=n-1)?arr[mid+1]:Integer.MIN_VALUE;
            if(arr[mid]>prev && arr[mid]>next){
                res=mid;
                break;
            }else if(prev>arr[mid]){
                end=mid-1;
            }else if(next>arr[mid]){
                start=mid+1;
            }
        }
        return res;
    }
}