// 13. Roman to Integer
// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
// For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Given a roman numeral, convert it to an integer.



// Galat approaches jo mene try kri

class Solution {
    public int romanToInt(String s) {
        char I = 1;
        char V = 5;
        char X = 10;
        char L = 50;
        char C = 100;
        char D = 500;
        char M = 1000;
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            sum+=s.charAt(i);
        }
        return sum;
    }
}


// Ab isse output aaya , 
s ="III"
Output
219 😂😂

// ye isilye aaya kuki char type me 1, 5, 10 ye actual characters nahi,
//  balki ASCII values ban jati hain.
// Agr bina Map ke use karnge to I ki value 73 hi li jaygi , 
// s=III, => 73+73=73=219, let's see , Map wala Solution



// Approach => Solution by Using Map

// 🔥 Roman numeral rule:
// Jab chhoti val badi val ke pehle aati hai, tb:
// Subtract chhoti val from badi val
// Example:
// IV → 1 < 5 → So 5 - 1 = 4
// IX → 10 - 1 = 9

// Point 1 -> direct sari values ka sum nhi kr sakte, agar prev val, curr val se choti h to subtract it from cyurrent val

// Point 2 -> in java code execute line by line,to nextVal ki value phele calculate nhi kr sakte 


class Solution {
    public int romanToInt(String s) {
        int sum=0;
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        for(int i=0; i<s.length(); i++){
            int currVal = romanMap.get(s.charAt(i));
            int nextVal = romanMap.get(s.charAt(i+1)); 
            // nextVal phele nhi nikal sakte , jb i + 1 < s.length() check krnge sirf 
            // tbi nikal sakte h ,kuki s.charAt(i+1) tabhi chalega jab wo line tak pahunchega

// Java pehle i + 1 calculate karega
// Fir s.charAt(i + 1) ko call karega
// Fir uska result romanMap.get(...) me daalega
// Aur finally usse nextVal me store karega
// ➡️ Yeh sab tabhi hoga jab Java is line pe aayega — bina kisi condition ke!

            if(i+1<s.length() && currVal<nextVal){
                sum-=currVal;
            }else{
                sum+=currVal;
            }
        }
        return sum;
    }
}

// aasa nhi ho sakta ki phele nextVal m calculate kr lia fir check kr rhe h , let's see correct code




// CORRECT APPROACH (and it's the optimal Approach)
class Solution {
    public int romanToInt(String s) {
        int sum=0;
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        for(int i=0; i<s.length(); i++){
            int currVal = romanMap.get(s.charAt(i));
            if(i+1<s.length() && currVal<romanMap.get(s.charAt(i+1))){
                sum-=currVal;
            }else{
                sum+=currVal;
            }
        }
        return sum;
    }
}


// TC -> O(n)
// Sc -> O(1) (Fixed size Map -> Since map contains only 7 fixed entries: 'I', 'V', 'X', 'L', 'C', 'D', 'M'.)


// Dry Run

Output => 1000-100+1000-10+100-1+5 = 1994

Adding 1000 for M
Subtracting 100 for C
Adding 1000 for M
Subtracting 10 for X
Adding 100 for C
Subtracting 1 for I
Adding 5 for V
Output: 1994
//////////////////////////////////////////////////////////

Index | Char | currVal | nextVal | Action      | sum
-------------------------------------------------------
  0   |  M   |   1000   |   100   | Adding      | 1000
  1   |  C   |    100   |  1000   | Subtracting |  900
  2   |  M   |   1000   |    10   | Adding      | 1900
  3   |  X   |     10   |   100   | Subtracting | 1890
  4   |  C   |    100   |     1   | Adding      | 1990
  5   |  I   |      1   |     5   | Subtracting | 1989
  6   |  V   |      5   |     0   | Adding      | 1994
Final Output: 1994

