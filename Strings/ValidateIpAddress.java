package Strings;
/*
You are given the text ‘IPAddress’. Your task is to check if the given text ‘IPAddress’ is a valid ‘IPv4’ or not.
Conditions for a valid ‘IPv4’

Sample Input 1:
4
123.111.12.k
122.0.330.0
1.1.1.250
1.0.0.0.1
Sample Output 1:
False
False
True
False
Explanation Of Sample Input 1:
Test Case 1:
Given text ‘IPAddress = 123.111.12.k’, it is satisfying the first condition that given ‘IPAddress’ must be ‘a.b.c.d’ formed but it not satisfying the second condition that d must in a range of ‘0’ to ‘255’ but the value of ‘d’ is ‘k’.
Hence return ‘False’.

Test Case 2:
Given text ‘IPAddress = 122.0.330.0’, it is satisfying the first condition that given ‘IPAddress’ must be ‘a.b.c.d’ formed but it not satisfying the second condition that c must in a range of ‘0’ to ‘255’ but the value of ‘c’ is ‘330’ and it is out of range.
Hence return ‘False’.

Test Case 3:
Given text ‘IPAddress = 1.1.1.250’, it is satisfying the first condition that given ‘IPAddress’ must be ‘a.b.c.d’ formed as well as it satisfying the second condition that a,b,c, and d must in range of ‘0’ to ‘250’.
Hence return ‘True’.

Test Case 4:
Given text ‘IPAddress = 1.0.0.0.1’, it is not satisfying the first condition for valid ‘IPv4’, that text ‘IPAddress’ must be in form of ‘a.b.c.d’ but given text is a form of ‘a.b.c.d.e’
Hence return ‘False’.
Sample Input 2:
2
1.90.21.1
1.1
Sample Output 2:
True
False
 */
public class ValidateIpAddress {
    public static boolean isValidIPv4(String ipAddress) {
        // To track count of dots
        int k =0;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<ipAddress.length();i++)
        {
            // If there are more thsn 3 dots
            if(k > 3)return false;

            char ch = ipAddress.charAt(i);

            if(ch == '.' && sb.length() > 0){
                int n = Integer.valueOf(sb.toString());
                if(n < 0 || n > 255)return false;
                k++;
                sb.setLength(0);
            }
            else{
                if(!Character.isDigit(ch))return false;
                sb.append(ch);
            }
        }

        return k >= 3;
    }
}
