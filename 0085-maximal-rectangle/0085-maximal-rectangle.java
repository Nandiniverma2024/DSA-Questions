class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int height[]=new int[m];
        int maxArea=0;
        // 1. Build histogram for each row
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]=='1'){
                    height[j]+=1;
                }else{
                    height[j]=0;
                }
            }
            // Find maxArea from each row of histogram
            maxArea=Math.max(maxArea, histogram(height));
        }
        return maxArea;
    }

    public int histogram(int height[]){
        int n=height.length;
        int pse[]=getPSE(height);
        int nse[]=getNSE(height);
        int maxArea=0;
        for(int i=0; i<n; i++){
            int width=nse[i]-pse[i]-1;
            int currArea=height[i]*width;
            maxArea=Math.max(maxArea, currArea);
        }
        return maxArea;
    }
    public int[] getNSE(int arr[]){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int res[]=new int[n];
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=n;
                st.push(i);
            }else if(arr[st.peek()]<arr[i]){
                res[i]=st.peek();
                st.push(i);
            }
        }
        return res;
    }
    public int[] getPSE(int arr[]){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int res[]=new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=-1;
                st.push(i);
            }else if(arr[st.peek()]<=arr[i]){
                res[i]=st.peek();
                st.push(i);
            }
        }
        return res;
    }
}