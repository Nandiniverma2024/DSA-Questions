class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int total=n*m;

        int arr[]=new int[total];
        int idx=0;

        // copy all el of grid in array
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[idx++]=grid[i][j];
            }
        }

        k%=total; // To skip repeated steps
        // total=5, k=6, k%=total => 6%5 = 1

        // Rotate Array by k places
        reverse(arr, 0, total-1); // reverse whole array
        reverse(arr, 0, k-1); // reverse k part
        reverse(arr, k, total-1); // reverse k+1 to n part


        List<List<Integer>> res=new ArrayList<>();

        idx=0;
        for(int i=0; i<n; i++){
            List<Integer> rowLi=new ArrayList<>();
            for(int j=0; j<m; j++){
                rowLi.add(arr[idx++]);
            }
            res.add(rowLi);
        }

        return res;
    }

    public void reverse(int arr[], int left, int right){
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
}