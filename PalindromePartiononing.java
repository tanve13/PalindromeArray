import java.util.*;

public class PalindromePartiononing {

    static class Solution {
        public List<List<String>> partition(String s) {
            int n = s.length();
            List<List<String>> result = new ArrayList<>();
            boolean[][] isPal = new boolean[n][n];

            // Step 1: Precompute palindrome substrings
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPal[i + 1][j - 1])) {
                        isPal[i][j] = true;
                    }
                }
            }

            // Step 2: Backtrack using precomputed palindromes
            backtrack(0, s, isPal, new ArrayList<>(), result);
            return result;
        }

        private void backtrack(int start, String s, boolean[][] isPal,
                               List<String> path, List<List<String>> result) {
            if (start == s.length()) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int end = start; end < s.length(); end++) {
                if (isPal[start][end]) {
                    path.add(s.substring(start, end + 1));
                    backtrack(end + 1, s, isPal, path, result);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "aab";
        List<List<String>> result = sol.partition(s);

        System.out.println("Palindrome partitions of \"" + s + "\":");
        for (List<String> list : result) {
            System.out.println(list);
        }

        // Try another test
        s = "aabb";
        System.out.println("\nPalindrome partitions of \"" + s + "\":");
        result = sol.partition(s);
        for (List<String> list : result) {
            System.out.println(list);
        }
    }
}
