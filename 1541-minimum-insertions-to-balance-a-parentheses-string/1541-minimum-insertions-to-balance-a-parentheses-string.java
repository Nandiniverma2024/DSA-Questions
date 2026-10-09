
class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int insertions = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                // Agar next ')' nahi hai, toh ek ')' insert karo
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++; // Dono ')' consume ho gaye
                } else {
                    insertions++;
                }

                // Closing pair ke liye opening bracket nahi hai
                if (open == 0) {
                    insertions++;
                } else {
                    open--;
                }
            }
        }

        return insertions + 2 * open;
    }
}