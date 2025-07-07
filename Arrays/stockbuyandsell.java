import java.util.*;

// 121. Best Time to Buy and Sell Stock

// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.


// BruteForce Approach
class Solution {
    public int maxProfit(int[] prices) {
        int profit=0, maxProfit=0;
        // Loop through each day -> consider each day as a potential buy day
        for(int i=0; i<prices.length; i++){
            // Loop through all future days -> consider them as the potential sell day
            for(int j=i+1; j<prices.length; j++){
                profit = prices[j]-prices[i];
                // Check profit for every j(or every future day)
                maxProfit = Math.max(profit, maxProfit);
            }
            // If check maxProfit after the completion of inner loop ,
            // we are only able to check for last j, but we have to check for everyday
            // that's why we checked this inside the inner loop
        }
        return maxProfit;
    }
}


// Time	O(n²)
// Space	O(1)




// Optimal Approach

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE; // Initializing with maximum value since we need to find minimum price
        int profit=0, maxProfit=0;
        for(int i=0; i<prices.length; i++){
            // Minimum price seen so far
            minPrice=Math.min(minPrice, prices[i]);
            // calculate profit for every day(i.e we sell on the current day)
            profit=prices[i]-minPrice;
            // Now, check for the maximum profit
            maxProfit=Math.max(profit, maxProfit);
        }
        return maxProfit;
    }
}



// Time Complexity	    O(n)	
// Space Complexity	O(1)



