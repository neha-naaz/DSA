package SlidingWindow;

import java.util.*;

public class LongestSubstrWithoutRepeatingChars {
    // O(n) time and O(m) space,
    // where n is the length of the string and m is the number of unique characters in the string.
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0, result=0;
        // to keep track of unique chars in the curr substr
        Set<Character> set = new HashSet<>();

        for(int j=0;j<n;j++) {
            // remove until the duplicate char is removed
            while(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }

            // mark char visited
            set.add(s.charAt(j));
            result = Math.max(result, j-i+1);
        }
        return result;
    }
}

class ExecuteLongestSubstrWithoutRepeatingChars{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        LongestSubstrWithoutRepeatingChars solObj = new LongestSubstrWithoutRepeatingChars();
        System.out.println(solObj.lengthOfLongestSubstring(str));
    }
}
