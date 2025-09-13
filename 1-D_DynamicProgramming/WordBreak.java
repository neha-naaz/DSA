/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of dictionary words.
You are allowed to reuse words in the dictionary an unlimited number of times. You may assume all dictionary words are unique.

Example 1:
Input: s = "neetcode", wordDict = ["neet","code"]
Output: true
Explanation: Return true because "neetcode" can be split into "neet" and "code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen","ape"]
Output: true
Explanation: Return true because "applepenapple" can be split into "apple", "pen" and "apple". Notice that we can reuse words and also not use all the words.

Example 3:
Input: s = "catsincars", wordDict = ["cats","cat","sin","in","car"]
Output: false

Constraints:
1 <= s.length <= 200
1 <= wordDict.length <= 100
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
*/

class WordBreak {
    // Time Complexity: O(n * m * k)
    // n - length of str, m - len of words, k - avg size of sbstr
    // Space complexity: O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        // boolean arr to keep track of valid segments
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        // segment = endInd - startInd so (0,0) = "" valid segment hence true
        dp[0] = true;

        for (int i=1;i<=n;i++) {
            for (String word: wordDict) {
                int l = word.length();
                int start = i - l;
                if (start >= 0 && dp[start] && s.substring(start, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
