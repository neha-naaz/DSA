/*
There is a foreign language which uses the latin alphabet, but the order among letters is not "a", "b", "c" ... "z" as in English.
You receive a list of non-empty strings words from the dictionary, where the words are sorted lexicographically based on the rules of this new language.
Derive the order of letters in this language. If the order is invalid, return an empty string. 
If there are multiple valid order of letters, return any of them.
A string a is lexicographically smaller than a string b if either of the following is true:
The first letter where they differ is smaller in a than in b.
There is no index i such that a[i] != b[i] and a.length < b.length.

Example 1:
Input: ["z","o"]
Output: "zo"
Explanation:
From "z" and "o", we know 'z' < 'o', so return "zo".

Example 2:
Input: ["hrn","hrf","er","enn","rfnn"]
Output: "hernf"
Explanation:
from "hrn" and "hrf", we know 'n' < 'f'
from "hrf" and "er", we know 'h' < 'e'
from "er" and "enn", we know get 'r' < 'n'
from "enn" and "rfnn" we know 'e'<'r'
so one possibile solution is "hernf"

Constraints:
The input words will contain characters only from lowercase 'a' to 'z'.
1 <= words.length <= 100
1 <= words[i].length <= 100
*/

class AlienDictionary {
    // topological sort
    // a - z alphabets nodes, compare adj string form edges
    // Time Complexity: O(N + V + E ) Space Complexity: O(V + E)
    public String foreignDictionary(String[] words) {
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, Set<Character>> adj = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }        
        // build adjaceny list
        for(int i=1;i<words.length;i++) {
            String w1 = words[i-1];
            String w2 = words[i];
            int minLen = Math.min(w1.length(), w2.length());
          // cases like apple before app
            if (w1.length() > w2.length() &&
                w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (!adj.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        for(char c: indegree.keySet()) {
            if (indegree.get(c) == 0) q.offer(c);
        }

        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()) {
            char ch = q.poll();
            res.append(ch);
            for (char c_: adj.get(ch)) {
                // update decremented indegree
                indegree.put(c_, indegree.get(c_)-1);
                if (indegree.get(c_) == 0) q.offer(c_);
            }
        }

        if (res.length() != indegree.size()) return "";
        return res.toString();
    }
}
