class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        String comb[]={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb=new StringBuilder();
        solve(digits, 0, sb, comb, ans);

        return ans;
    }
    public void solve(String digits, int idx, StringBuilder sb, String comb[], List<String> ans){
        // Base Case
        if(idx==digits.length()){
            ans.add(sb.toString());
            return;
        }
        char ch=digits.charAt(idx);
        int res=Character.getNumericValue(ch); //since index are always in numerical value
        String temp=comb[res];

        for(int i=0; i<temp.length(); i++){
            sb.append(temp.charAt(i));
            solve(digits, idx+1, sb, comb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}