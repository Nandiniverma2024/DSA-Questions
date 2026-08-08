class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        StringBuilder str = new StringBuilder();

        solve(n, n, str, ans);

        return ans;
    }

    public void solve(int open, int close, StringBuilder str, List<String> ans) {
        // base case 
        if(open == 0 && close == 0) {
            ans.add(str.toString());
            return;
        }

        // choice 1 --> add "("
        if(open > 0) {
            str.append('(');

            solve(open-1, close, str, ans);

            //backtracking
            str.deleteCharAt(str.length() - 1);

        }
        // choice 2 --> add ")"
        if(close > open) {
            str.append(')');

            solve(open, close-1, str, ans);

            //backtracking
            str.deleteCharAt(str.length() - 1);

        }
    }
}