package Strings;
/*
Given a string "pattern", which contains only two types of characters ‘(’, ‘)’.
Your task is to find the minimum number of parentheses either ‘(’, ‘)’ we must add the parentheses in string ‘pattern’
and the resulted string is valid.
Condition for valid string:
Every opening parenthesis ‘(’ must have a correct closing parenthesis ‘)’.
Example - ‘(()(()))’, ‘()()()’, ‘((()))’ are valid string, and ‘(((’, ‘(()’, ‘)(())’ are invalid string.

Sample Input 1:
2
)((()
((
Sample Output 1:
3
2
Explanation Of Sample Input 1:
Test Case 1:

In the given "pattern" = ")((()", only one pair of parentheses ( at index ‘3’ and ‘4’) is valid and parentheses at index
‘0’, ‘1’ and ‘2’ are invalid.
As you can see, we need three extra parentheses to make the string valid in the above image, one opening parenthesis ‘(’
for index ‘0’, two closing parentheses ‘)’ for index ‘1’ and ‘2’.
So return 3 number of minimum extra parentheses to make string "pattern" valid.

Test Case 2:

In the given "pattern" = "((" so we need two extra closing parentheses ‘)’ to make string "pattern" valid.
So return 2 number of minimum extra parentheses to make string "pattern" valid.
 */
import java.util.*;
public class MinimumParentheses {
    public static int minimumParentheses(String pattern) {
        // Write your code here.
        List<Character> stack = new ArrayList<>();
        int result = 0;

        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(ch == ')'){
                if(stack.isEmpty())result++;
                else stack.remove(stack.size()-1);
            }
            else{
                stack.add(ch);
            }
        }
        return result + stack.size();
    }
}
