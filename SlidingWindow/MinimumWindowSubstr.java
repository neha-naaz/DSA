package SlidingWindow;
/*
Given two strings s and t, return the shortest substring of s such that every character in t, including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".

You may assume that the correct output is always unique.

Example 1:

Input: s = "OUZODYXAZV", t = "XYZ"

Output: "YXAZ"
Explanation: "YXAZ" is the shortest substring that includes "X", "Y", and "Z" from string t.

Example 2:

Input: s = "xyz", t = "xyz"

Output: "xyz"
Example 3:

Input: s = "x", t = "xy"

Output: ""
Constraints:

1 <= s.length <= 1000
1 <= t.length <= 1000
s and t consist of uppercase and lowercase English letters.
 */
import java.util.*;

class MinimumWindowSubstr {
    // Intuition: at begining and ending of the curr substr
    // check if both the chars must be present
    public String minWindow(String s, String t) {
        // maps to store the freqs of individual chars in both strs
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for(char ch: s.toCharArray())sMap.put(ch, sMap.getOrDefault(ch, 0)+1);
        for(char ch: t.toCharArray())tMap.put(ch, tMap.getOrDefault(ch, 0)+1);
        if(s.equals(t))return s;
        if(t.length() > s.length())return "";

        // initial window is entire str
        int l = 0, r = s.length()-1;
        while(l <= r) {
            // get starting and ending chars
            char c = s.charAt(l);
            char c2 = s.charAt(r);
            // check if these chars must be present, we found the ans
            if(sMap.getOrDefault(c, 0) == tMap.getOrDefault(c, 0) &&
                    sMap.getOrDefault(c2, 0) == tMap.getOrDefault(c2, 0)){
                return s.substring(l, r+1);
            }

            // is one of char should be in ans
            if(tMap.containsKey(c)){
                // excess in number, can get rid of
                if(sMap.get(c)>tMap.get(c)){
                    // decrement the count in map
                    sMap.put(c, sMap.get(c)-1);
                    l++;
                } else {
                    // else shrink window from right
                    r--;
                }
            } else {
                // if the char not needed in ans shrink window from left
                l++;
            }
        }
        return "";
    }
}

class ExecuteMinimumWindowSubstr{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        MinimumWindowSubstr solObj = new MinimumWindowSubstr();
        System.out.println(solObj.minWindow(str1, str2));
    }
}

