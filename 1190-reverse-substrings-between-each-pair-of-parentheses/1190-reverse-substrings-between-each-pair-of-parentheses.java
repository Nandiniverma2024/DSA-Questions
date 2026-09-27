class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> st=new Stack<>();
        char sArr[]=s.toCharArray();
        st.push(new StringBuilder());
        for(char ch : sArr){
            if(ch=='('){
                st.push(new StringBuilder());
            }else if(ch==')'){
                StringBuilder end=st.pop();
                st.peek().append(end.reverse());
            }else{
                st.peek().append(ch);
            }
        }
        return st.pop().toString();
    }
}