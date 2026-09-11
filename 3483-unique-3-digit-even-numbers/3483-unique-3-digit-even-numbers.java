class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<Integer> set=new HashSet<>();

        for(int i=0; i<digits.length; i++){
            for(int j=0; j<digits.length; j++){
                for(int k=0; k<digits.length; k++){
                    if(i!=j && i!=k && j!=k && digits[i]!=0){
                        int num = digits[i]*100 + digits[j]*10 + digits[k];
                        if(num%2==0){
                            set.add(num);
                        }
                    }
                }
            }
        }
        
        return set.size();
    }
}