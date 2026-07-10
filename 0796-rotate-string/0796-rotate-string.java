class Solution {
    public boolean rotateString(String s, String goal) {

        if(goal.length()!=s.length()){
            return false;
        }

        String curr=s;
        for(int i=0; i<s.length(); i++){
            if(curr.equals(goal)){
                return true;
            }
            //check rotations
            curr=curr.substring(1)+s.charAt(i);
        }

        return false;
    }
}