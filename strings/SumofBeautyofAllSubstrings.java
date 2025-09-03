// 1781. Sum of Beauty of All Substrings
// The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
// For example, the beauty of "abaacc" is 3 - 1 = 2.
// Given a string s, return the sum of beauty of all of its substrings. 

// Example 1:
// Input: s = "aabcb"
// Output: 5
// Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.




// PATTERN FOR GENERATING SUBSTRINGS => substring enumeration pattern
substring enumeration pattern => Fix start → expand end //(Not 2 pointer kuki usme dono pointer sat m move hote h)


//ENUMERATION
enumeration meaning => list banana(ek fix set define krna) ya ginti karke batana
// Example -> "India ke states enumerate karo" → iska matlab hoga ek ek karke list banana (Uttar Pradesh, Haryana, uttarakhand, …).
Example => enum Day {
                MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
            }




// CORE PATTERN => 
Fix start → expand end → maintain freq array → har step par answer contribute


// Approach , TC-> O(n^2), SC -> O(1)
// make 2 functions to find most and least frequent character of substrings
// For Every new starting point Make new frequency array of size 26(only for the lowercase letters)
// Calculate beauty for each substring => getMaxCount(freq) - getMinCount(freq)
// Add beauty of all substrings into sum
// Return Sum


class Solution {
    public int getMinCount(int[] freq){
        int minCount=Integer.MAX_VALUE;
        for(int i=0; i<26; i++){
            if(freq[i] != 0){
                minCount=Math.min(freq[i], minCount);
            }
        }
        return minCount;
    }
    public int getMaxCount(int[] freq){
        int maxCount=Integer.MIN_VALUE;
        for(int i=0; i<26; i++){
            if(freq[i] != 0){
                maxCount=Math.max(freq[i], maxCount);
            }
        }
        return maxCount;
    }
    public int beautySum(String s) {
        int sum=0;
        for(int i=0; i<s.length(); i++){
            int[] freq = new int[26];
            for(int j=i; j<s.length(); j++){
                freq[s.charAt(j)-'a']++;
                int beauty=getMaxCount(freq)-getMinCount(freq);
                sum += beauty;
            }
        }
        return sum;
    }
}




