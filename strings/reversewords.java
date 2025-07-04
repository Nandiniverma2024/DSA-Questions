class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim and split by one or more spaces
        String[] words = s.trim().split("\\s+");

        // Step 2: Use StringBuilder to build the result in reverse order
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) reversed.append(" "); // Add space between words
        }

        return reversed.toString();
    }
}

🧠 Time and Space Complexity:
// ⏱ Time: O(n) — each character visited once (trim, split, reverse).

// 📦 Space: O(n) — for storing split words and the result.


// Optimal approach
class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;        
        // Step 1: Reverse the entire string
        reverse(arr, 0, n - 1);
        // Step 2: Reverse each word
        reverseEachWord(arr, n);
        // Step 3: Remove extra spaces and construct the final string
        return cleanSpaces(arr, n);
    }
    // Function to reverse characters in a given range of char array
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    // Function to reverse each word in the reversed string
    private void reverseEachWord(char[] arr, int n) {
        int start = 0, end = 0;
        
        while (start < n) { //jb tak start array ke index se chota h
            while (start < end || (start < n && arr[start] == ' ')) start++; // Skip spaces
            while (end < start || (end < n && arr[end] != ' ')) end++; // Move end to word boundary
            reverse(arr, start, end - 1); // Reverse the word
        }
    }
    // Function to remove extra spaces and return the cleaned-up string
    private String cleanSpaces(char[] arr, int n) {
        int i = 0, j = 0;
        
        while (j < n) {
            while (j < n && arr[j] == ' ') j++; // Skip spaces
            while (j < n && arr[j] != ' ') arr[i++] = arr[j++]; // Keep word
            while (j < n && arr[j] == ' ') j++; // Skip spaces after word
            if (j < n) arr[i++] = ' '; // Keep only one space
        }
        
        return new String(arr, 0, i);
    }
}

