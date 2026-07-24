/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start=0, end=n;
        // 1 2 3 4 5 6 7 8 9 10
        // F F F F F F T T T T
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isBadVersion(mid)==false){
                // iska mltb left m abi tak koi bad version 
                // wala product nhi aaya to isilye search in right half
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        // first bad vision hmasa right side m hoga
        // loop khatam hote hote =>
        // start => reach to first bad version of product
        
        // end => end reached to last good version of product
//         (end = mid - 1;
// ➡️ Matlab end ko piche le aate hain, taaki pehla bad version miss na ho.)
        return start;
    }
}