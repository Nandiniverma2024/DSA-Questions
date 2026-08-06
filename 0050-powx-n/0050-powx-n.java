class Solution {
    public double myPow(double x, int n) {
        // Handle negative exponention
        if(n<0){
            return power(1/x, n);
        }
        return power(x, n);
    }
    // Binary exponentiation method
    public double power(double x, int n){
        if(n==0){
            return 1;
        }
        double half=power(x, n/2);
        if(n%2==0){
            return half*half;
        }
        return x*half*half;
    }
}