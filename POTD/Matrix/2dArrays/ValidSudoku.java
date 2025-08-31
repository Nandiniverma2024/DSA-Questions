// 36. Valid Sudoku
// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:

// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.



// Code
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Make Arrays of HashSet , mltb array jisme hashSet type ke el.s store honge
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxs = new HashSet[9];
        // using for loop to allocate new hashset for every row/ col and box
        for(int i=0; i<9; i++){
            // 9 rows ke lia , 9 hashSet , same for col and box
            rows[i]=new HashSet<>();
            cols[i]=new HashSet<>();
            boxs[i]=new HashSet<>();
        }
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char c=board[i][j];
                // char = . mltb if empty then skip, move to next element
                if(c=='.'){
                    continue;
                }

                // Row Check
                if(rows[i].contains(c)){
                    return false;
                }
                rows[i].add(c);

                // Col check
                if(cols[j].contains(c)){
                    return false;
                }
                cols[j].add(c);

                // Box check
                int boxIndex = (i/3)*3 + (j/3);
                if(boxs[boxIndex].contains(c)){
                    return false;
                }
                boxs[boxIndex].add(c);
            }
        }
        return true;
    }
}


// Time and Space Complexity
// TC O(1) → Because Sudoku is always 9x9 → loops = 81 iterations, independent of input.
// SC O(1) → Only 3 arrays of HashSet with max 9 elements each → fixed memory, independent of input.
 

