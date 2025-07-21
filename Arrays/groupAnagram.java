package Arrays;
/*
Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:
Input: strs = ["act","pots","tops","cat","stop","hat"]
Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

Example 2:
Input: strs = ["x"]
Output: [["x"]]

Example 3:
Input: strs = [""]
Output: [[""]]

Constraints:
1 <= strs.length <= 1000.
0 <= strs[i].length <= 100
strs[i] is made up of lowercase English letters.
 */

import java.util.*;

public class groupAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // to mark visited
        int[] vis = new int[strs.length];

        // to store the result
        List<List<String>> result = new ArrayList<>();

        for(int i=0;i<strs.length;i++) {
            // if already part of group
            if(vis[i] == 1)continue;

            // pick curr string
            List<String> currL = new ArrayList<>();
            // first member of group
            currL.add(strs[i]);
            vis[i] = 1;

            for(int j=i+1;j<strs.length;j++) {
                // check for anagram of parent
                boolean anag = isAnagram(strs[i], strs[j]);

                // if not already part of any group
                if(isAnagram(strs[i], strs[j])) {
                    vis[j] = 1;
                    currL.add(strs[j]);
                }
            }

            // the group add it to result
            result.add(currL);
        }

        return result;
    }

    private static boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i=0;i<s1.length();i++) {
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }

        for(int i=0;i<s2.length();i++) {
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }

        for(char ch: s1.toCharArray()) {
            if(map1.get(ch) != map2.get(ch))return false;
        }

        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextLine();
        }

        System.out.println(groupAnagrams(arr));
    }
}
