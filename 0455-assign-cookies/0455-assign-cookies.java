class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int cnt=0;
        int i=0, j=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i<g.length && j<s.length){
            if(s[j]>=g[i]){
                cnt++;
                i++;
                j++;
            }else{
                j++; // find greater cookie satisfing greed
                // move to next cookie to find greater or equal to greed factor
            }
        }
        return cnt;
    }
}