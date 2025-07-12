/*
Given a string s, split s into substrings where every substring is a palindrome. Return all possible lists of palindromic substrings.
You may return the solution in any order.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]

Constraints:
1 <= s.length <= 20
s contains only lowercase English letters.
*/

class PalindromePartitioning {
  // Time: O(2^n*n)
  // Space: O(n) - to store result
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, 0, res, new ArrayList<>());
        return res;
    }

    private void helper(String s, int i, int j, List<List<String>> res, List<String> curr) {
        if (j >= s.length()) {
            if(isPalindrome(s, i, j)) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        if (isPalindrome(s, i, j)) {
            curr.add(s.substring(i, j+1));
            helper(s, j+1, j+1, res, curr);
            curr.remove(s.substring(i, j+1));
        }
        helper(s, i, j+1, res, curr);
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (i == j)return true;
        while(i<s.length() && j<s.length() && i<j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }

        return !(i<j);
    }
}
