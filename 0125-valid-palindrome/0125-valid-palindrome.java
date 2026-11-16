class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int l=0, r=s.length()-1; //idx
        while(l<r){
            char lc=s.charAt(l);
            char rc=s.charAt(r);
            // Agr dono hi alpha numeric nhi h skip that char
            if(!Character.isLetterOrDigit(lc)){
                l++;
            }else if(!Character.isLetterOrDigit(rc)){
                r--;
            // agr dono l and r pr present char alpha numeric h to compare them
            }else if(lc!=rc){
                return false;
            }else{ // jb dono char eqal honge tbi dono pointers move krnge
                l++;
                r--;
            }
        }
        return true;
    }
}