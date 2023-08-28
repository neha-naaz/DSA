package Strings;
/*
You are given two big numbers ‘A’ and ‘B’ as strings. Your task is to find the product of both the numbers.

Sample Input 1:
2
17281
91276
123
456
Sample Output 1:
1577340556
56088
Explanation For Sample 1:
For the first test case:
A=17281, and B=91276
The product of both numbers is 1577340556.

For the second test case:
A=123, B=456
The product of both numbers is 56088
Sample Input 2:
1
5
10
Sample Output 2:
50
 */

import java.util.*;
public class MultiplyStrings {
    public static String multiplyStrings(String a, String b) {

        int n = a.length();
        int m = b.length();

        // Initialising the answer array.
        int[] answer = new int[m + n];

        // Below two indexes are used to find positions in answer.
        int p = 0;
        int q = 0;

        // Traversing first number "a" from right to left
        for (int i = n - 1; i >= 0; i--) {
            int carry = 0;

            // Taking current digit of first number "a"
            int a1 = a.charAt(i) - '0';

            // Initialising q to zero to denote right end.
            q = 0;

            // Go from right to left in second number "b"
            for (int j = m - 1; j >= 0; j--) {

                // Taking current digit of second number
                int a2 = b.charAt(j) - '0';

                // Multiply with digit of first number and adding carry to it
                int sum = a1 * a2 + answer[p + q] + carry;

                // Carry for next iteration
                carry = sum / 10;

                // Storing the answer
                answer[p + q] = sum % 10;

                // Shifting q by 1
                q++;
            }

            // Store carry in the next cell if it exists
            if (carry > 0) {
                answer[p + q] += carry;
            }

            // Left shifting p by 1 unit
            p++;
        }

        // Moving to first non-zero digit from left
        int i = answer.length - 1;
        while (i >= 0 && answer[i] == 0) {
            i--;
        }

        // Generate the final answer as a string
        StringBuilder result = new StringBuilder();

        while (i >= 0) {
            result.append(answer[i--]);
        }

        // Checking the case of 0
        if (result.length() == 0) {
            return "0";
        }
        return result.toString();
    }
}
