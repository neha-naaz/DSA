package Stack;
/*
You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.

Return the integer that represents the evaluation of the expression.

The operands may be integers or the results of other operations.
The operators include '+', '-', '*', and '/'.
Assume that division between integers always truncates toward zero.
Example 1:

Input: tokens = ["1","2","+","3","*","4","-"]

Output: 5

Explanation: ((1 + 2) * 3) - 4 = 5
Constraints:

1 <= tokens.length <= 1000.
tokens[i] is "+", "-", "*", or "/", or a string representing an integer in the range [-100, 100].
 */
import SlidingWindow.PermutationString;
import java.util.*;
public class EvaluateREversePolishNotation {
    //T: O(n) S: O(n)
    // postfix evaluation
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String ch: tokens) {
            if("+-*/".contains(ch)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                switch(ch) {
                    case "+":
                        stack.push(op1+op2);
                        break;
                    case "-":
                        stack.push(op1-op2);
                        break;
                    case "*":
                        stack.push(op1*op2);
                        break;
                    case "/":
                        int res = op1/op2;
                        stack.push(res);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(ch));
            }
        }
        return stack.pop();
    }
}

class ExecuteEvaluateREversePolishNotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextLine();
        }

        EvaluateREversePolishNotation solObj = new EvaluateREversePolishNotation();
        System.out.println(solObj.evalRPN(arr));
    }
}
