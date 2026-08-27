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