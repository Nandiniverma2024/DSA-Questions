class Solution {
    public int minimumChairs(String s) {
        int people=0, minChair=0;
        char arr[]=s.toCharArray();
        int n=arr.length;
        for(int i=0; i<n; i++){
            if(arr[i]=='E'){
                people++;
            }else{
                people--;
            }
            // maximum number of people in the waiting room at any instance.
            minChair=Math.max(minChair, people);
        }
        return minChair;
    }
}