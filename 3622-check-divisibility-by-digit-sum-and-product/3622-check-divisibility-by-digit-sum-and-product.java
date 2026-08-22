class Solution {
    public boolean checkDivisibility(int n) {
        int diSum=0;
        int diProd=1;
        int temp=n;
        while(temp>0){
            int ld=temp%10;
            diSum+=ld;
            diProd*=ld;
            temp/=10;
        }
        if((n % (diSum + diProd)) == 0){
            return true;
        }
        return false;
    }
}