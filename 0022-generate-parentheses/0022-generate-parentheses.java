class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
    
        return solve(n, n, "", ans);
    }
    public List<String> solve(int openingBracket, int closingBracket, String str, List<String> ans){
        // Base Case
        if(openingBracket==0 && closingBracket==0){
            ans.add(str);
            return ans;
        }
        // choice 1 (add opening bracket)
        if(openingBracket>0){
            solve(openingBracket-1, closingBracket, str+"(", ans);
        }
        // Choice 2 (add closing brackets)
        if(closingBracket>openingBracket){
            solve(openingBracket, closingBracket-1, str+")", ans);
        }

        return ans;
    }
}