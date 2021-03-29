package com.algo0329;

import java.io.*;

public class Main_17609_회문 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            if (checkPalindrome(a) == true) {
                System.out.println(0);
            } else if (checkPseudoPalindrome(a) == true) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }

    static boolean checkPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    static boolean checkPseudoPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return checkPalindrome(s.substring(start + 1, end + 1)) | checkPalindrome(s.substring(start, end));
            }
            start++;
            end--;
        }
        return true;
    }
}
