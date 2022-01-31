package com.algo2022_01;

import java.io.*;

public class Main15829 {
    static int L, r = 31, M = 1234567891;
    static long answer;
    public static void main(String[] args) throws Exception {
        input();
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        String tmp = br.readLine();
        for(int i=0; i<L; i++){
            long num = tmp.charAt(i) - 'a'+1;
            answer += num * hash(i);
        }
        answer = answer % M;
        System.out.println(answer);
    }
    static long hash(int num){
        return num == 0 ? 1 : r * hash(num - 1) % M;
    }
}
