package Stack;
/*
You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.

The input string s is valid if and only if:

Every open bracket is closed by the same type of close bracket.
Open brackets are closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
Return true if s is a valid string, and false otherwise.

Example 1:

Input: s = "[]"

Output: true
Example 2:

Input: s = "([{}])"

Output: true
Example 3:

Input: s = "[(])"

Output: false
Explanation: The brackets are not closed in the correct order.

Constraints:

1 <= s.length <= 1000
 */

import SlidingWindow.PermutationString;
import java.util.*;

public class ValidParantheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for(char ch: s.toCharArray()) {
            System.out.println(ch);
            if(map.containsKey(ch)){
                if(!st.isEmpty() && st.peek() == map.get(ch))st.pop();
                else return false;
            } else {
                st.push(ch);
            }
        }

        return st.isEmpty();
    }
}

class ExecuteValidParantheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        ValidParantheses solObj = new ValidParantheses();
        System.out.println(solObj.isValid(str));
    }
}
