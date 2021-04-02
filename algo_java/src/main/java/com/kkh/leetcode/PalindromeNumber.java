package com.kkh.leetcode;

public class PalindromeNumber {
    public static void main(String args[]) {
        new PalindromeNumber();
    }

    public PalindromeNumber() {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-101));
    }

    public boolean isPalindrome(int x) {
        //회문
        if(x<=0){
            return false;
        }

        StringBuilder sb = new StringBuilder(String.valueOf(x));
        String str1 = sb.toString();
        String str2 = sb.reverse().toString();
        return str1.equalsIgnoreCase(str2);
    }
}
