// 2011. Final Value of Variable After Performing Operations
// There is a programming language with only four operations and one variable X:
// ++X and X++ increments the value of the variable X by 1.
// --X and X-- decrements the value of the variable X by 1.
// Initially, the value of X is 0.

// Given an array of strings operations containing a list of operations, return the final value of X after performing all the operations.

// Example 1:
// Input: operations = ["--X","X++","X++"]
// Output: 1
// Explanation: The operations are performed as follows:
// Initially, X = 0.
// --X: X is decremented by 1, X =  0 - 1 = -1.
// X++: X is incremented by 1, X = -1 + 1 =  0.
// X++: X is incremented by 1, X =  0 + 1 =  1.



// Pattern / Algorithm Type:
// 👉 Simulation Pattern (or Simple String Traversal)


// Code
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        // Jb string type ka array ho tb , use .equals to compare elemnt from that index , and need to use double quote , since it is a character literal
        int count=0;
        for(int i=0; i<operations.length; i++){
            // Since it is a string array , so use everything in character literals , "X++"
            // .equals string compare krne ke lia use hota h
            if(operations[i].equals("++X") || operations[i].equals("X++")){
                count+=1;
            }else if(operations[i].equals("--X") || operations[i].equals("X--")){
                count-=1;
            }
        }
        return count;
    }
}

// TC -> O(n) (kuki hm pure array ke har element pr minimum ek bar traverse kr rhe h)
// SC -> O(1) (kuki hmne koi extra space nhi lia h)

// Note: In Java, use .equals() method to compare the contents of strings instead of '==' operator, which checks for reference equality.

