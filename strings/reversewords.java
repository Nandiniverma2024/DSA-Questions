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
