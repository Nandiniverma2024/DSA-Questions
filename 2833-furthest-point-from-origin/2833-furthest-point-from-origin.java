class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n=moves.length();
        int left=0, right=0;
        for(int i=0; i<moves.length(); i++){
            char ch=moves.charAt(i);
            if(ch=='L'){
                left++;
            }else if(ch=='R'){
                right++;
            }
        }

        if(left==0 && right==0){
            return n;
        }

        int empty=n-(left+right);

        if(left>right){
            left+=empty;
        }else{
            right+=empty;
        }

        return Math.abs(left-right);
    }
}