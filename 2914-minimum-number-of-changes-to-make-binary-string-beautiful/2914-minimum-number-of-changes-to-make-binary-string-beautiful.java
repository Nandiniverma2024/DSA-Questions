class Solution {
    public int minChanges(String s) {
        int cnt=0;
        for(int i=0; i<s.length(); i+=2){
            int end=i+2;

            if(end>s.length()){
                end=s.length();
            }
            // Step1: Divide string into length of 2
            String temp=s.substring(i, end);

            // Step2: check if string is beautiful
            if(temp.charAt(0)!=temp.charAt(1)){
                cnt++;
            }
        }
        return cnt;
    }
}