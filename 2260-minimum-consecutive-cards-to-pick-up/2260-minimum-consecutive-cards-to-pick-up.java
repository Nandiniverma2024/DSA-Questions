class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> map=new HashMap<>();
        // map => el , el ka indx

        int left=0, right=0, n=cards.length;
        int len=-1, minLen=Integer.MAX_VALUE;

        while(right<n){
            if(map.containsKey(cards[right])){ //agr map m el h tb 
                left=map.get(cards[right]);
                len=right-left+1;
                minLen=Math.min(minLen, len);
                // agr map m duplicate exist kr rha h , cards[right] => ye previous duplicate el ka index dega
            }
            map.put(cards[right], right);
           
            right++;
        } 
        if(minLen==Integer.MAX_VALUE){
            return -1;
        }
        return minLen;
    }
}


// eg = 3,4,2,1,4,7
// jb duplicate aa jay
// cards[right] = jo el map m phele se h uska idx(mltb previous 4 ka index dega)