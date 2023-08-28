package Strings;
/*
Ninja has given you a list of WORDS and a PATTERN string. Your task is to find all such words in the list which match
the given pattern. A valid match is found if and only if every character in the pattern is uniquely mapped to a
character in a word.

Sample Input 1:
2
2
cdd pcm
foo
3
abcd km qst
pqr
Sample Output 1:
cdd
qst
Explanation 1:
For the first test case, the list of words is {cdd, pcm} and the pattern is 'foo'.

For the word 'cdd':
The letters ‘f’, ‘o’, ‘o’ of the pattern, map to letters ‘c’, ‘d’, ‘d’ of the word respectively. As every letter in the pattern maps uniquely to a corresponding letter in the word. Hence, it is a valid match.

For the word 'pcm':
The letters ‘f’, ‘o’, ‘o’ of the pattern map to letters ‘p’, ‘c’, ‘m’ of the word respectively. As the same letter ‘o’, in the pattern, maps to two different letters ‘c’ and ‘m’ in the word. Hence, 'pcm' is not a valid match.

For the second test case, the list of words is {abcd, km, qst} and the pattern is 'pqr'.

For the word 'abcd':
The letters ‘p’, ‘q’, ‘r’ of the pattern map to letters ‘a’, ‘b’, ‘c’ of the word respectively. But, there is no character in the pattern which maps to the letter ‘d’ in the word. Hence, it is not a valid match.

For the word 'km':
The letters ‘p’, ‘q’ of the pattern, map to letters ‘k’, ‘m’ of the word respectively. But. there is no character in the word which maps to the letter ‘r’ in the pattern. Hence, it is not a valid match.

For the word 'qst':
The letters ‘p’, ‘q’, ‘r’ of the pattern map to letters ‘q’, ‘s’, ‘t’ of the word respectively. As every letter in the pattern maps uniquely to a corresponding letter in the word. Hence, it is a valid match.
Sample Input 2:
2
5
aaaa abcd code toma zedi
pqrs
6
adff coding ejqq fstt ggnn ninja
lmnn
Sample Output 2:
abcd code toma zedi
adff ejqq fstt
Sample Input 3:
2
3
#h#@# AmAka &t&y&
%R%s%
1
A
B
Sample Output 3:
#h#@# &t&y&
A
 */

import java.util.*;
public class MatchPattern {
    public static boolean isMatch(String s1, String s2){
        // If the number of chars aren't same
        if(s1.length() != s2.length())return false;

        HashMap<Character, Character> hm = new HashMap<>();


        for(int i=0;i<s1.length();i++){
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);

            // If the char in pattern is already mapped
            if(hm.containsKey(ch2)){
                // check if the mapping is correct
                if(hm.get(ch2) != ch1)return false;
            }
            // If the char has already a pattern key
            else if(hm.containsValue(ch1)){
                for(Map.Entry<Character, Character> entry: hm.entrySet()) {
                    // If pattern key isn't correct
                    if(entry.getValue() == ch1 && entry.getKey() != ch2){
                        return false;
                    }
                }
            }
            else
                hm.put(ch2, ch1);
        }
        return true;
    }

    public static List<String> matchSpecificPattern(List<String> words, int n, String pattern) {
        List<String> res = new ArrayList<>();

        for(String word: words){
            if(isMatch(word, pattern))res.add(word);
        }
        return res;
    }
}
