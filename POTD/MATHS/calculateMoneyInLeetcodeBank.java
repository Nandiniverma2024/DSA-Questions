// 1716. Calculate Money in Leetcode Bank
// Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.
// He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.
// Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.


// Example 1:
// Input: n = 4
// Output: 10
// Explanation: After the 4th day, the total is 1 + 2 + 3 + 4 = 10.


// Example 2:
// Input: n = 10
// Output: 37
// Explanation: After the 10th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37. Notice that on the 2nd Monday, Hercy only puts in $2.



//  CODE:
class Solution {
    public int totalMoney(int n) {
        int total=0;
        // Divide n/7 to get to know , how many weeks are there , fir baki ke bache hua days calculte kr lenge
        // Example
        //n = 10 → weeks = 10 / 7 = 1 (1 full week)
        // n = 20 → weeks = 20 / 7 = 2 (2 full weeks)
        int weeks=n/7;
        int days=n%7; //This gives baki ke bache hua days
        // Example
        // n = 10 → days = 10 % 7 = 3
        // n = 20 → days = 20 % 7 = 6
        for(int i=0; i<weeks; i++){//i -> week number
            total+=7*(i+1)+21;

            // 7x + 21 → “Ek full week ka total”


            // Pattern
            // x, (x + 1), (x + 2), (x + 3), (x + 4), (x + 5), (x + 6)
            // Total = x + (x+1) + (x+2) + (x+3) + (x+4) + (x+5) + (x+6)
            // Total = (x + x + x + x + x + x + x) + (1 + 2 + 3 + 4 + 5 + 6)
            // Total = 7x + (1 + 2 + 3 + 4 + 5 + 6)
            // and x-> 1+i



            // i = 0 → total += 7*(0+1)+21 = 7 + 21 = 28
            // i = 1 → total += 7*(1+1)+21 = 14 + 21 = 35
            // i = 2 → total += 7*(2+1)+21 = 21 + 21 = 42


            // Week start value = 1 + i
            // Week 0 (first): starts at 1
            // Week 1 (second): starts at 2

            // DEPOSITE PATTERN
            // (start) + (start+1) + (start+2) + ... + (start+6)


            // Sum of 7 consecutive numbers starting from x
            //= 7*x + (1 + 2 + 3 + 4 + 5 + 6)
            // = 7*x + 21


        }
        // Handle last incomplete week ke remeaning days
        for(int i=0; i<days; i++){
            // Har new Monday pe start value 1 + weeks hoti h
            total+=(1+weeks)+i;

            // iska meaning:
            // Monday → (1 + weeks) + 0
            // Tuesday → (1 + weeks) + 1
            // Wednesday → (1 + weeks) + 2
        }
        return total;
    }
}


// Time Complexity ->  O(n)	Loop runs roughly n/7 times (proportional to n)
// Space Complexity ->	O(1)	Only constant extra space used


