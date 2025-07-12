/*
You are given a string digits made up of digits from 2 through 9 inclusive.
Each digit (not including 1) is mapped to a set of characters as shown below:
A digit could represent any one of the characters it maps to.

Return all possible letter combinations that digits could represent. You may return the answer in any order.

Example 1:
Input: digits = "34"
Output: ["dg","dh","di","eg","eh","ei","fg","fh","fi"]

Example 2:
Input: digits = ""
Output: []

Constraints:
0 <= digits.length <= 4
2 <= digits[i] <= 9
*/

class LetterCombinationsOfPhone {
  // Time: O(n * 4^n)
  
    Map<Character, String> map;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        if(digits.equals(""))return res;

        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int ind, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        if(ind >= digits.length()) {
            return;
        }

        String s = map.get(digits.charAt(ind));
        for(int i=0;i<s.length();i++) {
            sb.append(s.charAt(i));
            backtrack(digits, ind+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
