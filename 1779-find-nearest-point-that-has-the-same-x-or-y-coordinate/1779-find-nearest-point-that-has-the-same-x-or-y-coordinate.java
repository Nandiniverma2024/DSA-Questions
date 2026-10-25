class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int n=points.length;
        int minDist=Integer.MAX_VALUE;
        int idx=-1;
        for(int i=0; i<n; i++){
            int arr[]=points[i];
            if(x==arr[0] || y==arr[1]){
                int dist=distance(x,y,arr);
                if(dist<minDist){
                    minDist=dist;
                    idx=i;
                }
            }
        }
        return idx;
    }
    public int distance(int x, int y, int arr[]){
        return Math.abs(x-arr[0]) + Math.abs(y-arr[1]);
    }
}