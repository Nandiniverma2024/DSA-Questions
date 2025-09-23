// 3005. Count Elements With Maximum Frequency
// You are given an array nums consisting of positive integers.
// Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
// The frequency of an element is the number of occurrences of that element in the array.

 
// Example 1:
// Input: nums = [1,2,2,3,1,4]
// Output: 4
// Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
// So the number of elements in the array with maximum frequency is 4.

// Example 2:
// Input: nums = [1,2,3,4,5]
// Output: 5
// Explanation: All elements of the array have a frequency of 1 which is the maximum.
// // So the number of elements in the array with maximum frequency is 5.



// Code:
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxFreq=0;
        int totalMaxFreq=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(int num : map.keySet()){
            int freq=map.get(num);
            maxFreq=Math.max(freq, maxFreq);
        }
        // mltb hm is loop m ye check kr rhe h , kis kis el ki max freq h ? , jis ji sel ki maxFreq h , us us el ki freq ko tatalMaxFreq m add kr do
        for(int f : map.values()){ //map.values -> mltb map m present frequencies pr loop chal rha h 
            if(f==maxFreq){ //f har iteration me ek element ki frequency hold karega.
                totalMaxFreq+=f;
            }
        }
        return totalMaxFreq;
    }
}



// NOTE:
// for (int f : map.values())
// f har iteration me ek element ki frequency hold karega.

// Example:
// nums = [1,2,2,3,1,4]
// map = {1=2, 2=2, 3=1, 4=1}
// map.values() = [2, 2, 1, 1]


// Loop me iteration:

// 1st iteration: f = 2

// 2nd iteration: f = 2

// 3rd iteration: f = 1

// 4th iteration: f = 1

// 3️⃣ if(f == maxFreq)

// maxFreq pehle find kiya tha (yaha maxFreq = 2)

// Condition check karti hai:
// "ye frequency max frequency ke barabar hai?"


// Tc-> O(n)
// Sc-> O(k) / O(n){in worst Case}

