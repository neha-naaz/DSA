/*
You are given two words, beginWord and endWord, and also a list of words wordList. All of the given words are of the same length, 
consisting of lowercase English letters, and are all distinct.
Your goal is to transform beginWord into endWord by following the rules:
You may transform beginWord to any word within wordList, provided that at exactly one position the words have a different character, 
and the rest of the positions have the same characters.
You may repeat the previous step with the new word that you obtain, and you may do this as many times as needed.
Return the minimum number of words within the transformation sequence needed to obtain the endWord, or 0 if no such sequence exists.

Example 1:
Input: beginWord = "cat", endWord = "sag", wordList = ["bat","bag","sag","dag","dot"]
Output: 4
Explanation: The transformation sequence is "cat" -> "bat" -> "bag" -> "sag".

Example 2:
Input: beginWord = "cat", endWord = "sag", wordList = ["bat","bag","sat","dag","dot"]
Output: 0
Explanation: There is no possible transformation sequence from "cat" to "sag" since the word "sag" is not in the wordList.

Constraints:
1 <= beginWord.length <= 10
1 <= wordList.length <= 100
*/

public class WordLadder {
    //Time: O(m*n*26)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        Set<String> words = new HashSet<>(wordList);
        int res = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        while (!q.isEmpty()) {
            res++;
            for (int i = q.size(); i > 0; i--) {
                String node = q.poll();
                if (node.equals(endWord)) return res;
                for (int j = 0; j < node.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == node.charAt(j)) continue;
                        String nei = node.substring(0, j) + c + node.substring(j + 1);
                        if (words.contains(nei)) {
                            q.offer(nei);
                            words.remove(nei);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
