class Solution {
    public List<String> validStrings(int n) {
        List<String> ans=new ArrayList<>();
        
        solve(n, 1, "", ans);

        return ans;
    }
    public void solve(int n, int lastDigit, String str, List<String> ans){
        // Base Case
        if(n==0){
            ans.add(str);
            return ;
        }

        // if ld => 0 , next place pr sirf 1 aayga
        solve(n-1, 1, str+"1", ans);

        // if ld => 1
        // to 1 and 0 kuch bi ho sakta h
        if(lastDigit==1){
            solve(n-1, 0, str+"0", ans);
        }
    }
}