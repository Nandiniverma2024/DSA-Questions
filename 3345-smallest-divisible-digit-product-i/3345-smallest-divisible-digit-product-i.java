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
            // outer while loop tab tak chalega jb tak return condition execute nhi ho jati 
            // kuki is overall while(true) loop se bhar niklne ka return hi one and only tarika h
            if(prod%t==0){
                return n;
            }
            n++;
        }
    }
}