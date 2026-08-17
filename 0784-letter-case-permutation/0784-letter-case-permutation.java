class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();
        
        solve(s, 0, new StringBuilder(), ans);
        return ans;
    }
    public void solve(String s, int i, StringBuilder sb, List<String> ans){
        if(i==s.length()){
            ans.add(sb.toString());
            return;
        }

        char ch=s.charAt(i);

        // Digit
        if(Character.isDigit(ch)){
            // Taken
            sb.append(ch);
            solve(s, i+1, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }else{
            // UpperCase
            sb.append(Character.toUpperCase(ch));
            solve(s, i+1, sb, ans);
            sb.deleteCharAt(sb.length()-1);
            // LowerCase
            sb.append(Character.toLowerCase(ch));
            solve(s, i+1, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}