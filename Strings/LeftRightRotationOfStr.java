package Strings;
/*
You are given a string 'str' and an integer 'D'. Your task is to rotate the given string left (anticlockwise) and right
(clockwise) by 'D' units from the starting index. You are required to return the rotated string.

Sample Input 1 :
1
codingninjas
3
Sample Output 1 :
ingninjascod jascodingnin
Explanation For The Sample Output 1 :
In string “codingninjas” the substring of length 'D' = 3, starting from the beginning is “cod”, in the left rotation this substring is removed from the beginning and attached to the end of the string (i.e. anti-clockwise).

Similarly, in the right rotation, the substring of length 'D'  = 3 from the end is “jas”, this substring is removed from the end and attached to the beginning of the string(i.e. clockwise).
Sample Input 2 :
2
abcd
4
abc
4
Sample Output 2 :
abcd abcd
bca cab
Explanation For The Sample Output 2 :
In the first test case, as 'D' is equal to the length of the string so the substring same as the given string needs to be removed from the beginning and from the end and attached to the end and beginning of the empty string in the left and the right rotation respectively.

In the second test case, as 'D' is greater than the length of the string, so rotate it multiple times. After rotating the given string by '3' units, we get the same string as given, So now rotate the given string by 1 i.e('D' % 'N') units.

 */

import java.util.*;
public class LeftRightRotationOfStr {
    public static String leftRotate(String str, int d) {
        // Write you code here.
        if(d > str.length())d %= str.length();
        return str.substring(d)
                + str.substring(0, d);
    }

    public static String rightRotate(String str, int d) {
        // Write you code here.
        if(d > str.length())d %= str.length();
        return str.substring(str.length() - d)
                + str.substring(0, str.length() - d);
    }
}
