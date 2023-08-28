package Strings;
/*
You are given two versions numbers A and B as a string. Your task is to compare them and find out which one of them is a
newer version.

Output Format:
For each test case, print 1 if version A is latest, -1  if version B is latest and 0 if both versions are the same.

Sample Input 1:
2
1.2.4
1.2.3
10.2.2
10.2.2
Sample Output 1:
1
0
Explanation For Sample Input 1:
For the first test case, the first two parts of both the strings are the same but the third part of the 1st version is bigger than the 2nd version. Hence our answer is 1

For the second test case, both the versions are identical here, so the answer will be 0.
Sample Input 2:
2
123.45
123
1.0.0
1
Sample Output 2:
1
0
 */

public class CompareVersions {
    public static int compareVersions(String a, String b)
    {

        // Removing zeros from end of both strings
        a = removeZerosFromEnd(a);
        b = removeZerosFromEnd(b);

        // Initialising the four pointers
        int start1 = 0, start2 = 0, end1 = 0, end2 = 0;

        // Traversing both strings
        while (true)
        {
            // Finding first dot to the right of start1 in string a
            while (end1 < a.length() && a.charAt(end1) != '.')
            {
                end1++;

            }

            // Finding first dot to the right of start2 in string b
            while (end2 < b.length() && b.charAt(end2) != '.')
            {
                end2++;
            }

            // Finding the greater one among end1 and end2
            if (end1 > end2)
            {
                return 1;
            }
            else if (end1 < end2)
            {
                return -1;
            }

            // Comparing both the strings character by character
            for (int i = start1; i < end1; i++)
            {
                if (a.charAt(i) > b.charAt(i))
                {
                    return 1;
                }
                else if (b.charAt(i) > a.charAt(i))
                {
                    return -1;
                }

            }

            // Check if we reached end of both strings
            if (end1 == a.length() && end2 == b.length())
            {
                return 0;
            }

            // Check if we reached end of string a
            if (end1 == a.length())
            {
                return -1;
            }

            // Check if we reached end of string b
            if (end2 == b.length())
            {
                return 1;
            }

            // Updating values of all the four pointers
            start1 = end1;
            start2 = end2;
            end1++;
            end2++;

        }
    }

    // Function to remove zeros from end
    private static String removeZerosFromEnd(String a)
    {

        // First initialising answer as complete string then removing zeros from end
        int p = a.length() - 1;

        // Traversing the string backwards
        for (int i = a.length() - 1; i >= 1; i -= 2)
        {
            // Checking if the current character is 0 and there is dot to the left of it
            // If yes, then decreasing length of desired string
            if (a.charAt(i) == '0' && a.charAt(i - 1) == '.')
            {
                p -= 2;
            }
            // Otherwise ending the loop
            else
            {
                break;
            }

        }

        // Returning the final string
        return a.substring(0, p + 1);
    }
}
