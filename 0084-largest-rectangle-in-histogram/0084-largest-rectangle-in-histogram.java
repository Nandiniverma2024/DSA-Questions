class Solution {
    public int largestRectangleArea(int[] heights) {
        int nse[]=getNSE(heights);
        int pse[]=getPSE(heights);
        int maxArea=-1;
        for(int i=0; i<heights.length; i++){
            int width=nse[i]-pse[i]-1;
            int currArea=heights[i]*width;
            maxArea=Math.max(maxArea, currArea);
        }
        return maxArea;
    }
    public int[] getNSE(int arr[]){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int res[]=new int[n];
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=n; //since it it right boundary
                st.push(i);
            }else if(arr[st.peek()]<arr[i]){
                res[i]=st.peek();
                st.push(i);
            }
        }
        return res;
    }
    public int[] getPSE(int arr[]){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int res[]=new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=-1; //since it it Left boundary
                st.push(i);
            }else if(arr[st.peek()]<=arr[i]){
                res[i]=st.peek();
                st.push(i);
            }
        }
        return res;
    }
}