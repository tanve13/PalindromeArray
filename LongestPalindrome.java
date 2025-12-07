public class LongestPalindrome {

    static class Solution {
        public int longestPalindrome(String s) {
            int[] count = new int[128];
            
            for (char c : s.toCharArray()) {
                count[c]++;
            }

            int length = 0;
            boolean oddFound = false;

            for (int freq : count) {
                if (freq % 2 == 0) {
                    length += freq;
                } else {
                    length += freq - 1; 
                    oddFound = true;
                }
            }

            // If any odd frequency exists → one odd char can be placed in center
            return oddFound ? length + 1 : length;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.longestPalindrome("abccccdd")); // 7
        System.out.println(sol.longestPalindrome("aA"));        // 1
        System.out.println(sol.longestPalindrome("aaabbbb"));   // 7
    }
}
