package Strings;
/*

You are given a string 'STR'. YOu have to convert the first alphabet of each word in a string to UPPERCASE.

Sample Input 1:
3
I love programming
they are playing cricket
good to see you
Output:
I Love Programming
They Are Playing Cricket
Good To See You
Explanation:
For the first test case:
Given string is “I love programming” we will convert every letter after space to uppercase to give the output as
”I Love Programming”.

For the second test case:
Given string is “they are playing cricket” we will convert every letter after space to uppercase to give the output as
“They Are Playing Cricket”.

For the third test case:
Given string is “good to see you” we will convert every letter after space to uppercase to give the output as
“Good To See You”.
 */
public class ConvertString {
    public static String convertString(String str) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i=1;i<str.length();i++)
        {
            if(str.charAt(i-1) == ' '){
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
