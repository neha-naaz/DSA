package Arrays;

/*
Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:
Input: s = "racecar", t = "carrace"
Output: true

Example 2:
Input: s = "jar", t = "jam"
Output: false
Constraints:

s and t consist of lowercase English letters.
 */

import java.util.Scanner;

public class validAnagram {
    private static boolean isAnagram(String s, String t) {
        int[] s1 = new int[26];
        int[] t1 = new int[26];

        for(int i=0;i<s.length();i++) {
            s1[s.charAt(i) - 'a']++;
        }

        for(int i=0;i<t.length();i++) {
            t1[t.charAt(i) - 'a']++;
        }

        for(int i=0;i<26;i++) {
            if(s1[i] != t1[i])return false;
        }

        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(isAnagram(s1, s2));
    }
}
