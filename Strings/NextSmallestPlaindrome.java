package Strings;
/*
You are given a number 'N' in the form of a string 'S', your task is to find the smallest number strictly greater than
the given number 'N' which is a palindrome.

Sample Input 1:
1
4
1221
Sample Output 1:
1331
Explanation For Sample Input 1:
The next smaller palindrome to 1221 is 1331, as it is strictly greater than 1221 and it reads the same from the front
and back both.

Sample Input 2:
1
3
999
Sample Output 2:
1001
Explanation For Sample Input 1:
The next smaller palindrome to 999 is 1001, as it is strictly greater than 999 and it reads the same from the front
and back both.
 */
public class NextSmallestPlaindrome {
    public static String nextLargestPalindrome(String s, int length) {
        String temp = s;
        boolean check = isPalindrome(s, length);

        // S is not a plaindrome
        if (check == false) {
            // make curr string a plaindrom
            s = makePalindrome(s, length);
            boolean isBig = biggerThanOriginal(s, temp, length);
            // if bigger than original return the bigger string
            if (isBig == true) {
                return s;
            }
        }
        boolean allnine = true;

        // check if all chars are 9
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != '9') {
                allnine = false;
                break;
            }
        }
        String ans = "";
        if (allnine) {
            for (int i = 0; i < length - 1; i++) {
                ans += '0';
            }
            // if all 9's return 1000...1
            ans = '1' + ans + '1';
            return ans;
        } else if (length % 2 == 0) {
            int i = length / 2 - 1;
            int j = length / 2;
            s = helperForEvenLength(s, i, j);
            return s;
        } else {
            int mid = length / 2;
            int i = mid - 1;
            int j = mid + 1;
            if (s.charAt(mid) != '9') {
                s = s.substring(0, mid) + ((char)(s.charAt(mid) + 1)) + s.substring(mid + 1);
                return s;
            } else {
                s = s.substring(0, mid) + '0' + s.substring(mid + 1);
                s = helperForEvenLength(s, i, j);
                return s;
            }
        }
    }

    public static String helperForEvenLength(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != '9' && s.charAt(j) != '9') {
                char c = (char)(s.charAt(i) + 1);
                s = s.substring(0, i) + c + s.substring(i + 1);
                s = s.substring(0, j) + c + s.substring(j + 1);
                break;
            } else {
                s = s.substring(0, i) + '0' + s.substring(i + 1);
                s = s.substring(0, j) + '0' + s.substring(j + 1);
                i--;
                j++;
            }
        }
        return s;
    }

    public static boolean isPalindrome(String s, int l) {
        int i = 0;
        int j = l - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static String makePalindrome(String s, int l) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = l - 1;
        while (i < j) {
            sb.setCharAt(j, s.charAt(i));
            i++;
            j--;
        }
        return sb.toString();
    }

    public static boolean biggerThanOriginal(String s, String temp, int length) {
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) < temp.charAt(i)) {
                return false;
            } else if (s.charAt(i) > temp.charAt(i)) {
                return true;
            }
        }
        return true;
    }
}
