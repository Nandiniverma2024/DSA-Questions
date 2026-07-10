class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        int depth=0, maxDepth=0;
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(ch=='('){
                depth++;
            }else if(ch==')'){
                depth--;
            }
            maxDepth=Math.max(maxDepth, depth);
        }
        return maxDepth;
    }
}