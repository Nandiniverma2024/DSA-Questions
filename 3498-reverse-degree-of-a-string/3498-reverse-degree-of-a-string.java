class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            int c=ch-'a';
            int revC=26-c;
            sum+=(i+1)*revC;
        }
        return sum;
    }
}