package Strings;
/*
You have been given two strings A and B consisting of lower case English letters. The task is to count the minimum
number of pre-processing moves on the string A required to make it equal to string B after applying below operations:
1. Choose any index i (0 <= i < n) and swap characters a[i]  and b[i].
2. Choose any index i (0 <= i < n) and swap characters a[i]  and a[n-i-1] .
3. Choose any index i (0 <= i < n) and swap characters b[i]  and b[n-i-1] .
In one preprocess move, you can replace a character in A with any other character of the English alphabet.
 */

import java.util.HashMap;
public class MinOpsToMakeStrsEqual {
    public static int minimumOperations(String a, String b) {

        if (a.length() != b.length()) {
            return -1;
        }

        // Length of the given string.
        int n = a.length();

        // To store the required answer.
        int count = 0;

        // Run a loop upto 'n'/2.
        for (int i = 0; i < n / 2; i++) {

            // To store frequency of 4 characters in the ith group.
            HashMap<Character, Integer> group = new HashMap<>();

            if (group.containsKey(a.charAt(i))) {
                group.put(a.charAt(i), group.get(a.charAt(i)) + 1);
            } else {
                group.put(a.charAt(i), 1);
            }

            if (group.containsKey(a.charAt(n - i - 1))) {
                group.put(a.charAt(n - i - 1), group.get(a.charAt(n - i - 1)) + 1);
            } else {
                group.put(a.charAt(n - i - 1), 1);
            }

            if (group.containsKey(b.charAt(i))) {
                group.put(b.charAt(i), group.get(b.charAt(i)) + 1);
            } else {
                group.put(b.charAt(i), 1);
            }

            if (group.containsKey(b.charAt(n - i - 1))) {
                group.put(b.charAt(n - i - 1), group.get(b.charAt(n - i - 1)) + 1);
            } else {
                group.put(b.charAt(n - i - 1), 1);
            }

            int size = group.size();

            // All four characters are distinct.
            if (size == 4) {
                count += 2;
            }

            // Group contains three distinct characters.
            else if (size == 3) {
                // Replace both characters of String 'a'.
                if (a.charAt(i) == a.charAt(n - i - 1)) {
                    count += 2;
                } else {
                    count++;
                }
            }

            // Group contains two distinct characters.
            else if (size == 2) {
                // Replace one character of String 'a'.
                if (group.get(a.charAt(i)) != 2) {
                    count++;
                }
            }
        }

        // If 'n' is odd.
        if (n % 2 == 1 && a.charAt(n / 2) != b.charAt(n / 2)) {
            count++;
        }

        return count;
    }
}
