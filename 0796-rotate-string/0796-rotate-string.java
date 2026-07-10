class Solution {
    public boolean rotateString(String s, String goal) {
        if(goal.length()!=s.length()){
            return false;
        }
        String dblS=s+s;
        if(dblS.contains(goal)){
            return true;
        }
        return false;
    }
}