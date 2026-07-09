class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans=strs[0];
        for(int i=0; i<strs.length; i++){
            ans=twoStrPrefix(ans, strs[i]);
        }
        return ans;
    }
    public String twoStrPrefix(String s1, String s2){
        int min=Math.min(s1.length(), s2.length());
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<min; i++){
            if(s1.charAt(i)==s2.charAt(i)){
                sb.append(s1.charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }
}