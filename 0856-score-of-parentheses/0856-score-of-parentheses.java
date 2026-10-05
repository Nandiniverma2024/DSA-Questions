class Solution {
    public int scoreOfParentheses(String s) {
        int n=s.length();
        Stack<Integer> st=new Stack<>();
        int curr=0;
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(curr);
                curr=0; // reset curr for each pair of parenthesis
            }else{
                if(curr==0){
                    curr=1;
                }else{
                    curr=2*curr;
                }
                curr=st.pop()+curr;
            }
        }
        return curr;
    }
}