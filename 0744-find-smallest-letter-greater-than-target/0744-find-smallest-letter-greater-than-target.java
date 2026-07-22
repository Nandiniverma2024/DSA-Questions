class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;
        int start=0, end=n-1;
        char min=letters[0];
        while(start<=end){
            int mid=start+(end-start)/2;
            // Agr array m mid exist kre
            if(mid+1<=n-1 && letters[mid]==target && letters[mid]!=letters[mid+1]){
                return letters[mid+1];
            } //agr mid exist na krta tb
            else if(letters[mid]>target){ 
                // kya ye target se bari value hi next greater h
                // ya isse choti value bi exist krti h , jo target se greater h
                min=letters[mid];
                // Search in left half
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return min;
    }
}