class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        solve(n,n, sb, res);
        return res;
    }
    public void solve(int opening , int closing, StringBuilder sb, List<String> res){
        // Base Case
        if(opening == 0 && closing==0){
            res.add(sb.toString());
            return;
        }

        // Taken
        if(opening>0){
            sb.append('(');
            solve(opening-1, closing, sb, res);
            sb.deleteCharAt(sb.length()-1); //backtrack
        }
        if(closing > opening){ //Not Taken
            sb.append(')');
            solve(opening, closing-1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}