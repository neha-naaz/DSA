package Strings;

import java.util.Scanner;

class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        // remove all the spaces and convert to lowercase
        String formatted = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = formatted.length();
        int right = n-1, left = 0;

        // since the chars from frontwards and backwards should be same
        while(left < n && right >= 0 && formatted.charAt(left) == formatted.charAt(right)) {
            left++;
            right--;
        }

        // if we reach the extremes its true
        return left>=n && right<0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();


        System.out.println(isPalindrome(s));
    }
}

