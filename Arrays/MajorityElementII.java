package Arrays;
/*
You are given an array of integers of length and you are supposed to find all the elements that occur strictly more
than n/3 times in the given array

Sample input 1:
2
7
3 2 2 1 5 2 3
5
7 4 4 9 7
Output:
2
4 7
Explanation:
In the first test case, floor(N/3) = floor(7/3) is equal to 2, and 2 occurs 3 times which is strictly more than N/3.
No other element occurs more than 2 times.
In the second test case, floor(N/3) = floor(5/3) is equal to 1, and 4 and 7 both occur 2 times. No other element occurs
more than once.

Sample input 2:
2
6
1 2 4 4 3 4
4
6 6 6 7
Output:
4
6
Explanation:
In the first test case, floor(N/3) = floor(6/3) is equal to 2, and 4 occurs 3 times which is strictly more than N/3.
No other element occurs more than 2 times.
In the second test case, floor(N/3) = floor(4/3) is equal to 1, and 6 occurs 3 times. No other element occurs more than once.
 */
import java.util.*;
public class MajorityElementII {
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int number1 = nums.get(0), number2 = nums.get(0), count1 = 0, count2 = 0, len = nums.size();
        for (Integer num : nums) {
            if (num == number1)
                count1++;
            else if (num == number2)
                count2++;
            else if (count1 == 0) {
                number1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                number2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums.get(i) == number1)
                count1++;
            else if (nums.get(i) == number2)
                count2++;
        }
        if (count1 > len / 3)
            result.add(number1);
        if (count2 > len / 3)
            result.add(number2);
        return result;
    }
}
