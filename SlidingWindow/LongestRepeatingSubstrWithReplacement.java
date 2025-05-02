package SlidingWindow;
/*
You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.

After performing at most k replacements, return the length of the longest substring which contains only one distinct character.

Example 1:

Input: s = "XYYX", k = 2

Output: 4
Explanation: Either replace the 'X's with 'Y's, or replace the 'Y's with 'X's.

Example 2:

Input: s = "AAABABB", k = 1

Output: 5
Constraints:

1 <= s.length <= 1000
0 <= k <= s.length
 */

import java.util.*;
public class LongestRepeatingSubstrWithReplacement {
    // Intuiton: max replacements  can be made to get the longest repeating
    // char substr is most freq chars <= k
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(n == 0 || n == 1)return n;

        //Map to store freq of chars
        Map<Character, Integer> map = new HashMap<>();
        int result = 0, maxFreq = 0, i=0;
        for(int j=0;j<n;j++) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            // value of most freq char till now
            maxFreq = Math.max(maxFreq, map.get(ch));

            // while replacements exceed k
            while((j-i+1) - maxFreq > k) {
                // increment first pointer and decrement count in the map
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                i++;
            }

            result = Math.max(result, (j-i+1));
        }
        return result;
    }
}

class ExecuteLongestRepeatingSubstrWithReplacement{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();

        LongestRepeatingSubstrWithReplacement solObj = new LongestRepeatingSubstrWithReplacement();
        System.out.println(solObj.characterReplacement(str, k));
    }
}