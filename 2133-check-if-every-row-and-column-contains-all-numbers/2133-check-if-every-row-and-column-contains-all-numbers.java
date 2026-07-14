class Solution {
    public boolean checkValid(int[][] matrix) {
        int n=matrix.length;
        for(int i=0; i<n; i++){
            // Store unique el of curr row
            HashSet<Integer> rSet=new HashSet<>();
            // Store unique el of curr col
            HashSet<Integer> cSet=new HashSet<>();
            for(int j=0; j<n; j++){
                rSet.add(matrix[i][j]);
                cSet.add(matrix[j][i]);
            }
            if(rSet.size()!=n || cSet.size()!=n){
                return false;
            }
        }
        return true;
    }
}