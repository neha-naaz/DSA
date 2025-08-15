/*
Given a 2-D grid of characters board and a list of strings words, return all words that are present in the grid.
For a word to be present it must be possible to form the word with a path in the board with horizontally or vertically neighboring cells. 
The same cell may not be used more than once in a word.

Example 1:
Input:
board = [
  ["a","b","c","d"],
  ["s","a","a","t"],
  ["a","c","k","e"],
  ["a","c","d","n"]
],
words = ["bat","cat","back","backend","stack"]
Output: ["cat","back","backend"]

Example 2:
Input:
board = [
  ["x","o"],
  ["x","o"]
],
words = ["xoxo"]
Output: []

Constraints:
1 <= board.length, board[i].length <= 12
board[i] consists only of lowercase English letter.
1 <= words.length <= 30,000
1 <= words[i].length <= 10
words[i] consists only of lowercase English letters.
All strings within words are distinct.
*/

class WordSearchII {
    List<String> res;
    TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        root = new TrieNode();

        // insert all the input words in trie
        for (int i=0;i<words.length;i++) {
            insertInTrie(words[i], i, root);
        }

        // for each cell
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if (root.children[board[i][j]-'a'] != null) {
                    dfs(board, i, j, root, words);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, String[] words) {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || 
        board[i][j] == '.' || root.children[board[i][j]-'a'] == null) {
            return;
        }

        char ch = board[i][j];
        board[i][j] = '.';
        root = root.children[ch-'a'];
        if (root.isLeaf && root.ind != -1) {
            res.add(words[root.ind]);
            root.ind = -1;
            root.isLeaf = false;
        }

        dfs(board, i+1, j, root, words);
        dfs(board, i-1, j, root, words);
        dfs(board, i, j+1, root, words);
        dfs(board, i, j-1, root, words);
        board[i][j] = ch;

    }

    public void insertInTrie(String word, int ind, TrieNode root) {
        TrieNode curr = root;
        for (char ch: word.toCharArray()) {
            if (curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isLeaf = true;
        curr.ind = ind;
    }
}

class TrieNode {
    TrieNode children[];
    boolean isLeaf;
    int ind;

    public TrieNode() {
        children = new TrieNode[26];
        isLeaf = false;
        ind = -1;
    }

    public TrieNode(int ind) {
        children = new TrieNode[26];
        isLeaf = false;
        this.ind = ind;
    }
}
class WordDictionary1 {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch: word.toCharArray()) {
            if (curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        return dfs(word, 0, temp);
    }

    private boolean dfs(String word, int ind, TrieNode curr) {
        if (ind >= word.length()) {
            return curr.isEndOfWord;
        }

        if (word.charAt(ind) == '.') {
            for (TrieNode child: curr.children) {
                if (child != null && dfs(word, ind+1, child)) return true;
            }
            return false;
        } else {
            if (curr.children[word.charAt(ind)-'a'] == null) return false;
            return dfs(word, ind+1, curr.children[word.charAt(ind)-'a']);
        }
    }
}

class WordDictionary2 {
  // without a trie node class. here no root. self referential. this is root
    final static int N = 26;
    WordDictionary[] children;
    boolean isEnd;
    
    public WordDictionary() {
        this.children = new WordDictionary[N];
    }
    
    public void addWord(String word) {
        WordDictionary root = this;
        for(char ch: word.toCharArray()){
            int index = ch - 'a';
            if(root.children[index] == null) root.children[index] = new WordDictionary();
            root = root.children[index];
        }
        root.isEnd = true;
        return;
    }
    
    private boolean searchFor(WordDictionary root, char[] chArray, int index){
        if(index == chArray.length) return root.isEnd;
            
        if(chArray[index] == '.'){
            for(WordDictionary wd: root.children) 
                if(wd != null && searchFor(wd, chArray, index+1)) return true;
        } else if(root.children[chArray[index] - 'a'] != null) 
            return searchFor(root.children[chArray[index] - 'a'], chArray, index+1);
        
        return false; //default
    }
    
    public boolean search(String word) {
        return searchFor(this, word.toCharArray(), 0);
    }
}
