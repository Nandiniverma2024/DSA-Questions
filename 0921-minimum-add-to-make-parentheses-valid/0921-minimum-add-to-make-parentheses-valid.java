class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        int close=0;
        int cnt=0;
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push('(');
            }else if(!st.isEmpty() && ch==')' && st.peek()=='('){
                st.pop();
            }else{
                close++;
            }
        }

        // For tracking open brackets
        if(!st.isEmpty()){
            cnt+=st.size();
        }

        if(close>0){
            cnt+=close;
        }

        return cnt;
    }
}