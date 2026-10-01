class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){ //push opening bracket into stack
                st.push(ch);
            }else if(st.isEmpty()){ //Closing bracket aaya, lekin stack khali hai
                return false; //Matlab iska koi opening bracket hi nahi h, return false;   
            }else if(ch==')' && st.peek()=='('){
                st.pop();
            }else if(ch==']' && st.peek()=='['){
                st.pop();
            }else if(ch=='}' && st.peek()=='{'){
                st.pop();
            }else{ 
                return false;
                // Yahan stack khali nahi hai,
                // lekin closing bracket ka opening bracket se match nahi hua
                // Matlab brackets ka order galat hai
                // Example: "([)]"
            }
        }
        if(st.size()>0){
            return false;
        }
        return true;
    }
}

// Steps->

// 1. Opening bracket
//    → PUSH

// 2. Closing bracket + stack EMPTY
//    → FALSE
//    → opening bracket hi nahi tha

// 3. Closing bracket + TOP matching
//    → POP

// 4. Closing bracket + TOP mismatch
//    → FALSE
//    → order galat hai

// 5. Loop ke end mein stack EMPTY
//    → TRUE
//    → saare opening brackets properly close ho gaye
