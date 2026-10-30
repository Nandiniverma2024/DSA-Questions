class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int i=sr, j=sc;
        int n=image.length, m=image[0].length;

        int oriColor=image[sr][sc];
        
        solve(image, sr, sc, n, m, oriColor, color);
        
        return image;
    }
    public void solve(int[][] image, int i, int j, int n, int m, int oriColor, int color){
        
        // int newColor=color;

        // Base Case
        if(i<0 || j<0 || i>=n || j>=m || image[i][j]!=oriColor || image[i][j]==color){
            return;
        }

        image[i][j]=color; //agr color nhi h to, lakin val same h
        solve(image, i-1, j, n, m, oriColor, color);
        solve(image, i+1, j, n, m, oriColor, color);
        solve(image, i, j-1, n, m, oriColor, color);
        solve(image, i, j+1, n, m, oriColor, color);
       
    }
}