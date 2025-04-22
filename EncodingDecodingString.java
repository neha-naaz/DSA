package Arrays;
/*
Encode and Decode Strings

Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
Please implement encode and decode

Example 1:
Input: ["neet","code","love","you"]
Output:["neet","code","love","you"]

Example 2:
Input: ["we","say",":","yes"]
Output: ["we","say",":","yes"]

Constraints:
0 <= strs.length < 100
0 <= strs[i].length < 200
strs[i] contains only UTF-8 characters.
 */

import java.util.*;

class EncodingDecodingString {

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        // preceed with length of word ended with delimiter #
        for(String str: strs) {
            int len = str.length();
            sb.append(len).append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public static List<String> decode(String str) {
        int i=0, n=str.length();
        List<String> result = new ArrayList<>();
        while(i < n) {
            // strip the length of word
            String numS = "";
            while(str.charAt(i) != '#') {
                numS += str.charAt(i);
                i++;
            }
            int endR = Integer.valueOf(numS);

            // strip corresponding word
            String word = str.substring(i+1, i+endR+1);

            i += endR+1;
            result.add(word);
        }

        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(sc.nextLine());
        }

        String s = encode(arr);
        List<String> d = decode(s);
    }
}

