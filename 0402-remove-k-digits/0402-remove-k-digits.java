class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st=new Stack<>();
        int n=num.length();
        
        // edges Case 1
        if(k==n){
            return "0";
        }

        for(int i=0; i<n; i++){
            char ch=num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek()>ch-'0'){
                st.pop();
                k--;
            }
            st.push(ch-'0'); //push curr el             
            
        }

        // Edge case 2(n="123456" , k=3)
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }

        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        // Edge case 3 => remove leading zeros by using (replaceFirst("^0+", ""))
        String res=sb.reverse().toString().replaceFirst("^0+", "");

        if(res.isEmpty()){
            return "0";
        }

        return res;
    }
}