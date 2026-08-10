class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> strLi = new ArrayList<>();

        // Start partitioning from index 0
        solve(0, s, strLi, ans);

        return ans;
    }

    public void solve(int idx, String str, 
                      List<String> strLi, 
                      List<List<String>> ans) {

        // Base Case:
        // Agar idx string ke end tak pahunch gaya,
        // iska matlab ek complete valid partition ban gaya
        if (idx == str.length()) {
            ans.add(new ArrayList<>(strLi));
            return;
        }

        // Try every possible substring starting from idx
        for (int i = idx; i < str.length(); i++) {

            // Check whether current substring str[idx...i]
            // is a palindrome
            if (isPalindrome(str, idx, i)) {

                // Take:
                // Current palindrome substring ko current partition me add karo
                strLi.add(str.substring(idx, i + 1));

                // Recursion:
                // Ab next remaining part ko partition karo
                // i+1 se processing start hogi
                solve(i + 1, str, strLi, ans);

                // Backtrack:
                // Current choice remove karo taaki next possible
                // partition try ki ja sake
                strLi.remove(strLi.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right) {

        // Two pointers se substring ko check karenge
        // left -> starting index
        // right -> ending index
        while (left <= right) {

            // Agar corresponding characters different hain,
            // substring palindrome nahi hai
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            // Dono pointers ko andar move karo
            left++;
            right--;
        }

        // Agar koi mismatch nahi mila,
        // substring palindrome hai
        return true;
    }
}