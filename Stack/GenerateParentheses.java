package Stack;

import java.util.*;

public class GenerateParentheses {
    // basic recursion
    public List<String> GenerateParentheses(int n) {
        List<String> result = new ArrayList<>();
        char[] arr = new char[n*2];
        helper(n, arr, 0, 0, 0, result);
        return result;
    }

    private void helper(int n, char[] arr, int ind, int oc, int cc, List<String> res) {
        if(cc == n || ind == n*2) {
            res.add(new String(arr));
            return;
        }

        if(oc < n || oc == cc) {
            arr[ind] = '(';
            helper(n, arr, ind+1, oc+1, cc, res);
        }
        if(oc > cc) {
            arr[ind] = ')';
            helper(n, arr, ind+1, oc, cc+1, res);
        }

    }
}

class ExecuteGenerateParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        GenerateParentheses solObj = new GenerateParentheses();
        System.out.println(solObj.GenerateParentheses(n));
    }
}