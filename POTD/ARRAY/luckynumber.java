// 1394. Find Lucky Integer in an Array
// Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.

// Return the largest lucky integer in the array. If there is no lucky integer return -1.

 

// Example 1:

// Input: arr = [2,2,3,4]
// Output: 2
// Explanation: The only lucky number in the array is 2 because frequency[2] == 2.


// BruteForce approach
// BruteForce One
class Solution {
    public int findLucky(int[] arr) {
        int result = -1;

        // Check for the frequency
        for(int i=0; i<arr.length; i++){
            int count =0;
            for(int j=0; j<arr.length; j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            // Check for the lucky number
            if(arr[i] == count){
                result = Math.max(arr[i], result);
            }
        }
        return result;
    }
}

// tc -> O(n^2) , sc=O(n)

// Optimal Approach
class Solution {
    public int findLucky(int[] arr) {
        int result=-1;
        HashMap<Integer, Integer> freq = new HashMap<>();
        // Calculate Frequency
        for(int num : arr){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        // Check for the Lucky Number
        for(int key : freq.keySet()){
            int count = freq.get(key);
            if(key == count){
                result = Math.max(result, key);
            }
        }
        return result;
    }
} 

// tc -> O(n), sc -> O(n)
