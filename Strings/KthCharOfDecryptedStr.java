package Strings;
/*
You have been given an Encrypted String where repetitions of substrings are represented as substring followed by the
count of substrings.
Example: String "aabbbcdcdcd" will be encrypted as "a2b3cd3".
You need to find the 'K'th character of Decrypted String. Decrypted String would have 1-based indexing.

Sample Input 1 :
a2b3cd3
8
Sample Output 1 :
c
 Explanation to Sample Input 1 :
S = "a2b3cd3"
Decrypted String of S = "aabbbcdcdcd"
According to 1-based indexing for S, the 8th character is 'c'.
Sample Input 2 :
ab12c3
20
Sample Output 2 :
b
 Explanation to Sample Input 2 :
S = "ab12c3"
Decrypted String of S = "ababababababababababababccc"
So 20th character is 'b'.
 */

//    Time Complexity : O(N)
//    Space Complexity : O(1)
//    Where 'N' is the length of Encrypted String 'S'
public class KthCharOfDecryptedStr {
    public static char kThCharaterOfDecryptedString(String s, long k)
    {
        long i, j;

        // Length of the Encrypted String.
        long n = s.length();

        // To store the length of the substring.
        long substringLength;

        // To store the resultant length of the repeated substring.
        long resultantLength;

        // To store the frequency of the substring.
        long freqOfSubstring;

        // 'k'th Character in Decrypted String.
        char kThChar = '$';

        i = 0;

        while (i < n)
        {
            j = i;
            substringLength = 0;
            freqOfSubstring = 0;

            // Find the length of substring by traversing the string until no digit is
            // found.
            while (j < n && Character.isLowerCase(s.charAt((int)j)))
            {
                j++;
                substringLength++;
            }

            // Find the frequency of preceding substring.
            while (j < n && Character.isDigit(s.charAt((int)j)))
            {
                freqOfSubstring = freqOfSubstring * 10 + (s.charAt((int)j) - '0');
                j++;
            }

            // Find length of the resultant length of the repeated substring.
            resultantLength = freqOfSubstring * substringLength;

            if (k > resultantLength)
            {
                /*
                 * If length of the repeated substring is less than 'k' then required character
                 * is present in later substring. Subtract the length of repeated substring from
                 * 'k' to keep account of number of characters required to be visited.
                 */

                k -= resultantLength;
                i = j;
            }
            else
            {
                /*
                 * If length of repeated substring is more or equal to 'k' then required
                 * character lies in current substring.
                 */

                k--;
                k %= substringLength;
                kThChar = s.charAt((int)(i + k));
                break;
            }
        }

        return kThChar;
    }
}
