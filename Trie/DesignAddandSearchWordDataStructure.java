/*
Design a data structure that supports adding new words and searching for existing words.

Implement the WordDictionary class:

void addWord(word) Adds word to the data structure.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
Example 1:

Input:
["WordDictionary", "addWord", "day", "addWord", "bay", "addWord", "may", "search", "say", "search", "day", "search", ".ay", "search", "b.."]

Output:
[null, null, null, null, false, true, true, true]

Explanation:
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("day");
wordDictionary.addWord("bay");
wordDictionary.addWord("may");
wordDictionary.search("say"); // return false
wordDictionary.search("day"); // return true
wordDictionary.search(".ay"); // return true
wordDictionary.search("b.."); // return true
Constraints:

1 <= word.length <= 20
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 2 dots in word for search queries.
At most 10,000 calls will be made to addWord and search.

*/


class DesignAddandSearchWordDataStructure {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for (char ch: word.toCharArray()) {
            if (curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new Node();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isLeaf = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int ind, Node root) {
        Node curr = root;

        for (int i=ind;i<word.length();i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                // check from which child we have to continue searching
                for (Node child: curr.children) {
                    if (child != null && dfs(word, i+1, child)) {
                        return true;
                    }
                }
                return false;
            } else{
                if (curr.children[ch-'a'] == null) {
                    return false;
                }
                curr = curr.children[ch-'a'];
            }
        }
        return curr.isLeaf;
    }
}

class Node {
    Node[] children;
    boolean isLeaf;

    public Node() {
        children = new Node[26];
        isLeaf = false;
    }
}
