package SlidingWindow;
/*
You are given two strings s1 and s2.

Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.

Both strings only contain lowercase letters.

Example 1:

Input: s1 = "abc", s2 = "lecabee"

Output: true
Explanation: The substring "cab" is a permutation of "abc" and is present in "lecabee".

Example 2:

Input: s1 = "abc", s2 = "lecaabee"

Output: false
Constraints:

1 <= s1.length, s2.length <= 1000
 */

import java.util.Scanner;

public class PermutationString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        // store the freq for first m(len of s1) chars
        for(int i=0;i<s1.length();i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // check how many chars found
        int matches = 0;
        for(int i=0;i<26;i++){
            if(count1[i] == count2[i])matches++;
        }

        int l = 0;
        // s1="abc"
        // s2="bbbca"
        for(int r=s1.length();r<s2.length();r++) {
            // if permutation found
            if(matches == 26)return true;

            // extend window on right
            int ind = s2.charAt(r) - 'a';
            count2[ind]++;
            // check if new extended char is a match
            if (count1[ind] == count2[ind]) matches++;
                // NOT MATCHING WITH PREVIOUSLY WHAT IT WAS MATCHING WITH
            else if(count1[ind]+1 == count2[ind])matches--;

            // remove the char excluded from window
            ind = s2.charAt(l) - 'a';
            count2[ind]--;
            if(count1[ind] == count2[ind])matches++;
                // NOT MATCHING WITH PREVIOUSLY WHAT IT WAS MATCHING WITH
            else if(count1[ind]-1 == count2[ind])matches--;

            // shift left window
            l++;
        }

        return matches==26;
    }
}

class ExecutePermutationString{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        PermutationString solObj = new PermutationString();
        System.out.println(solObj.checkInclusion(str1, str2));
    }
}
