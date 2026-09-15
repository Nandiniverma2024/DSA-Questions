class Solution {
    public int hammingWeight(int n) {
        List<Integer> li=new ArrayList<>();
        while(n!=1){
            li.add(n%2);
            n=n/2;
        }
        li.add(1);
        int cnt=0;
        for(int i=0; i<li.size(); i++){
            if(li.get(i)==1){
                cnt++;
            }
        }
        return cnt;
    }
}