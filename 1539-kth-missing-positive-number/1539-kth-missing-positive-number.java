class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int start=0, end=n-1;
        // after complition of this loop(end, start)
        // end start ko cross kr jayga
        while(start<=end){
            int mid=start+(end-start)/2;
            int missing=arr[mid]-(mid+1);
            if(missing<k){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        // when start cross end
        // end+1 => start
        return (start+k);
    }
}


// 0 based indexing =>  0    1     2     3    4

// eg =>                2    3     4     7    11

// range(1,n)  =>       1    2     3     4    5

//                    (2-1)                   (11-5)
// Missing     =>       1    1     1     3     6
//                      |
//                      >1 el is missing till this idx

// formula => arr[i]-(i+1)  => arr[mid]-(mid+1)
// sare missing idx nikalne ki xarurat ni h
// mid ke sath check krke nikalo if needed