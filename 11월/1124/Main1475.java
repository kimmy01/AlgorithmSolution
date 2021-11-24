package com.algo11;

import java.io.*;

public class Main1475 {
    static int answer;
    static char[] arr;
    static int[] number;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    private static void func() {
        for(char c : arr) {
            number[c -'0'] ++;
        }
        if((number[6]+number[9])%2 > 0){
            int tmp = (number[6] + number[9])/2 + 1;
            number[6] = tmp;
            number[9] = tmp;
        }else{
            int tmp = (number[6] + number[9])/2;
            number[6] = tmp;
            number[9] = tmp;
        }
        for(int i : number) {
            answer = Math.max(i, answer);
        }
        System.out.println(answer);
    }
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        number = new int[10];
        answer = 0;
    }
}
