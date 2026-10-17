class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        Integer res[]=new Integer[n];
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<n; i++){
            res[i]=nums[i];
            map.put(nums[i], i);
        }

        Arrays.sort(res, (a,b) -> {
            int sumA=digitSum(a);
            int sumB=digitSum(b);

            if(sumA!=sumB){ //7,9 (i.e 16 and 18)
                return sumA-sumB; //sort on basis of diff sum
            }

            return a-b; //sort on basis of values of same sum(34 ans 43)
        });


        int swap=0;
        for(int i=0; i<n; i++){

            if(nums[i]!=res[i]){

                int idx=map.get(res[i]);

                // swap
                int temp=nums[i];
                nums[i]=nums[idx];
                nums[idx]=temp;

                // update indices in map
                map.put(nums[i], i);
                map.put(nums[idx], idx);
                swap++;
            }
        }

        return swap;
    }

    public int digitSum(int num){
        int sum=0;
        while(num>0){
            int ld=num%10;
            sum+=ld;
            num/=10;
        }
        return sum;
    }
}