package Strings;
/*
You are given a string STR of length N. Your task is to remove all the vowels present in that string and print the
modified string.
English alphabets ‘a’, ‘e’, ‘i’, ‘o’, ‘u’ are termed as vowels. All other alphabets are called consonants.
Note: You have to only remove vowels from the string. There will be no change in the relative position of all other
alphabets.

Sample Input 1:
2
Mobile
CodingNinjas
Sample Output 1:
Mbl
CdngNnjs
Explanation Of Input 1:
(i) The output ‘Mbl’ is obtained after removing vowels ‘o’ and ‘i’ from second and fourth position respectively of given
string ‘Mobile’.
(ii) The output ‘CdngNnjs’ is obtained after removing vowels ‘o’, ‘i’, ‘i’, and ‘a’ from second, fourth, eighth, and
eleventh position respectively of given string ‘CodingNinjas’.
 */

import java.util.ArrayList;
import java.util.List;
public class RemoveVowels {
    public static String removeVowels(String str) {
        // Write your code here.
        List<Character> vowels = new ArrayList<Character>(){{
            add('a'); add('e'); add('i'); add('o'); add('u');
        }};
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!vowels.contains(Character.toLowerCase(ch))){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
