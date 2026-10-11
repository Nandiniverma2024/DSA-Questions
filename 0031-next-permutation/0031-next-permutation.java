class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int pivot=-1;
        // 1. Find pivot
        for(int i=n-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                pivot=i;
                break;
            }
        }
        if(pivot==-1){
            reverse(nums, 0, n-1);
            return;
        }

        int rightMost=n-1;
        // 2. find first rightmost el > then pivot (do swap)
        for(int i=n-1; i>=0; i--){
            if(pivot!=-1 && nums[i] > nums[pivot]){
                rightMost=i;
                break;
            }
        }
        swap(nums, rightMost, pivot);

        // 3. reverse pivot+1 to n-1
        reverse(nums, pivot+1, n-1);
        
    }

    public void swap(int arr[], int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public void reverse(int nums[], int i, int j){
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}