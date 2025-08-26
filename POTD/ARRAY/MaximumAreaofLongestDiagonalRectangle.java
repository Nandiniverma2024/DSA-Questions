// // 3000. Maximum Area of Longest Diagonal Rectangle
// You are given a 2D 0-indexed integer array dimensions.
// For all indices i, 0 <= i < dimensions.length, dimensions[i][0] represents the length and dimensions[i][1] represents the width of the rectangle i.
// Return the area of the rectangle having the longest diagonal. If there are multiple rectangles with the longest diagonal, return the area of the rectangle having the maximum area.
 

// Example 1:

// Input: dimensions = [[9,3],[8,6]]
// Output: 48
// Explanation: 
// For index = 0, length = 9 and width = 3. Diagonal length = sqrt(9 * 9 + 3 * 3) = sqrt(90) ≈ 9.487.
// For index = 1, length = 8 and width = 6. Diagonal length = sqrt(8 * 8 + 6 * 6) = sqrt(100) = 10.
// So, the rectangle at index 1 has a greater diagonal length therefore we return area = 8 * 6 = 48.


// Brute Froce APPraoch , TC=O(2n), SC=O(1);
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        long maxDiagonal = 0;
        
        // 🔹 First loop: find max diagonal
        for(int i = 0; i < dimensions.length; i++){
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            long diagonal = (long)l*l + (long)w*w;
            maxDiagonal = Math.max(maxDiagonal, diagonal);
        }
        
        int maxArea = 0;
        
        // 🔹 Second loop: among max diagonal rectangles, find max area
        for(int i = 0; i < dimensions.length; i++){
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            long diagonal = (long)l*l + (long)w*w;
            int area = l * w;
            
            if(diagonal == maxDiagonal){
                maxArea = Math.max(maxArea, area);
            }
        }
        
        return maxArea;
    }
}



// Optimal Appraoch , TC=(n), SC=O(1)
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        long maxDiagonal=0;
        int maxArea=0;
        for(int i=0; i<dimensions.length; i++){
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            long diagonal = (long)l*l + (long)w*w;
            int area = l*w;
            // If rectangle has a larger diagonal
            if(diagonal>maxDiagonal){
                maxDiagonal = diagonal;
                maxArea=area;
            // If this rectangle has same diagonal as current maximum diagonal
            }else if(diagonal == maxDiagonal){
                // Then pick the rectangle with larger area
                maxArea=Math.max(area, maxArea);
            }
        }
        return maxArea;
    }
}


