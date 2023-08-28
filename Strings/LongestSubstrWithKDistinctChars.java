package Strings;
/*
You are given a string 'S' of length 'N' consisting of lowercase English alphabet letters. You are also given a positive
integer 'K'.
Now, a substring of this string is good if it contains at most 'K' distinct characters. A string 'X' is a substring of
string 'Y' if it can be obtained by deletion of several continuous elements(possibly zero) from the beginning and the
end from the string 'Y'.
Your task is to return the maximum size of any good substring of the string 'S'.

Sample Input 1:
2
2
abcbc
1
abccc
Sample Output 1:
4
3
Explanation For Sample Input 1:
For the first test case :
K = 2, so we can choose substring “bcbc” having 2 distinct character which is less than or equal to K = 2.

We cannot get any other substring of length 5 or more having distinct characters less than or equal to 2. Thus, you
should return ‘4’ as the answer.

For the second test case :
K = 1, so we can choose substring “ccc” having only 1 distinct character which is less than or equal to K = 1.

We cannot get any other substring of length 4 or more having distinct characters less than or equal to 1. Thus, you
should return ‘3’ as the answer.

Sample Input 2:
1
6
abcba
3
acbdab
Sample Output 2:
5
4
 */
public class LongestSubstrWithKDistinctChars {

    // Returns the number of distinct characters in the array 'freq'.
    public static int countDistinct(int[] freq) {
        int distinct = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                distinct++;
            }
        }

        return distinct;
    }

    public static int getLengthofLongestSubstring(String s, int k) {

        int longestLength = 0;
        int n = s.length();

        int freq[] = new int[26];

        // Starting index of the window.
        int start = 0;

        // Traverse for ending index of the window.
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;

            while (countDistinct(freq) > k) {
                freq[s.charAt(start) - 'a']--;
                start++;
            }

            longestLength = Math.max(longestLength, i - start + 1);
        }

        return longestLength;
    }
}
