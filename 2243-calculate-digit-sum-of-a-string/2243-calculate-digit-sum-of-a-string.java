class Solution {
    public String digitSum(String s, int k) {
        int n=s.length();

        while(n>k){
            StringBuilder sb=new StringBuilder();
            int i=0;
            while(i<n){
                int sum=0; // hr gp ka sum aalag cal hoga
                for(int j=i; j<Math.min(i+k,n); j++){
                    char ch=s.charAt(j);
                    sum+=ch-'0';
                }
                sb.append(sum);
                i+=k;
            }
            s=sb.toString();
            n=s.length();
        }
        return s;
    }
}