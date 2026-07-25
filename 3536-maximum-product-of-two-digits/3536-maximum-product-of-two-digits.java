class Solution {
    public int maxProduct(int n) {
        int maxProd=0;
        while(n>0){
            int ldn=n%10;
            int temp=n/10; //for remaining digits
            while(temp>0){
                int ldt=temp%10; //remaining digits
                int prod=ldn*ldt;
                maxProd=Math.max(maxProd, prod);
                temp/=10;
            }
            n/=10;
        }
        return maxProd;
    }
}