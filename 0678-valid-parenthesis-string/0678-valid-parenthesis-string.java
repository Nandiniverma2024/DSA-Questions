class Solution {
    public boolean checkValidString(String s) {
        int low=0, high=0;
        // low => minimum kitne opening brackets h 
        // high => max kitne opening bracket bache hua h jo close nhi hua
        // (low, high) => empty ka case iske ander consider h
        // low and high opening bracket ki range btaynge

        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch=='('){
                low++;
                high++;
            }else if(ch==')'){
                low--;
                high--;
            }else{ //case for *
                low--; //i.e closing bracket
                high++; //i.e opening bracket
            }


            // maximum possible open brackets bhi 0 se kam ho gaye -> ')' ko match karne ke liye '(' nahi milega
            if(high<0){ //mltb koi bi opening bracket nhi aaya
                return false;
            }

            // minimum possible open brackets 0 se kam nahi ho sakte
            low=Math.max(low, 0); 
        }
        if(low==0){
            return true;
        }

        return false;
    }
}