class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int prod=1;
            int temp=n;
            while(temp>0){
                int ld=temp%10;
                prod*=ld;
                temp/=10;
            }
            if(prod%t==0){
                return n;
            }
            n++;
        }
    }
}