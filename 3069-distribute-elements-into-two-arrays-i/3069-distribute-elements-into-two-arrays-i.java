class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> li1=new ArrayList<>();
        ArrayList<Integer> li2=new ArrayList<>();

        // since java m 0 based indexing hi hoti h
        li1.add(nums[0]);
        li2.add(nums[1]);

        int i=2; //initialize by index 2
        while(i<nums.length){
            if(li1.get(li1.size()-1) > li2.get(li2.size()-1)){
                li1.add(nums[i]);
            }else{
                li2.add(nums[i]);
            }
            i++;
        }

        int j=0, k=0;
        i=0; //reset i for copying into original array

        while(j<li1.size()){
            nums[i]=li1.get(j);
            i++;
            j++;
        }
        
        while(k<li2.size()){
            nums[i]=li2.get(k);
            i++;
            k++;
        }

        return nums;
    }
}