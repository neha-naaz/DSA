package Strings;
/*
Given a string ‘STR’ consisting of lower case English letters, the task is to find the first non-repeating character in
the string and return it. If it doesn’t exist, return ‘#’.

Sample Input 1:
2
bbabcbcb
babaabea
Sample Output 1:
a
e
Explanation Of Sample Input 1:
For the first test case,
the first non-repeating character is ‘a’. As depicted the character ‘b’ repeats at index 1, 3, 5, 7, and character ‘c’ repeats at index 6. Hence we return the character ‘a’ present at index 2.

For the second test case,
the character ‘e’ is the first non-repeating character. As depicted the character ‘b’ repeats at index 2, 5, and character ‘a’ repeats at index 3, 4, and 7. Hence we return the character ‘e’ present at index 6.
Sample Input 2:
3
cbbd
bebeeed
abcd
Sample Output 2:
c
d
a
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FirstUniqueChar {
    public static char firstNonRepeating(String str) {
        HashMap<Character, Integer> hm = new LinkedHashMap<>();

        // store frequency of every character
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }

        // return the first char with count 1
        for(Entry<Character, Integer> e: hm.entrySet()){
            /*  */if(e.getValue() == 1)return e.getKey();
        }
        return '#';
    }
}
