class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        StringBuilder result=new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            //initial m jb ch='(' , to count start nhi krna tab count 0 hi h, count ko , ch=')' se start krnge , nhi to opening and closing bracket ka count 0 nhi hoga , answer galat aayga
            if(ch==')'){
                count--;
            }
            if(count>0){
                result.append(ch);
            }
            if(ch=='('){
                count++;
            }
        }
        return result.toString();
    }
}