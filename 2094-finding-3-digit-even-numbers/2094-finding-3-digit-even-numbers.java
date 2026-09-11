class Solution {
    public int[] findEvenNumbers(int[] digits) {
        TreeMap<Integer, Integer> map=new TreeMap<>();
        for(int i = 0; i < digits.length; i++){
            for(int j = 0; j < digits.length; j++){
                for(int k = 0; k < digits.length; k++){

                    if(i != j && j != k && i != k && digits[i] != 0){

                        int num = digits[i] * 100 + digits[j] * 10 + digits[k];

                        if(num % 2 == 0){
                            map.put(num, map.getOrDefault(num, 0)+1);
                        }
                    }
                }
            }
        }
        int ans[]=new int[map.size()];
        int i = 0;
        for(int key:map.keySet()){
            ans[i] = key;
            i++;
        }
        return ans;
    }
}