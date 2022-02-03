package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main2609 {
    public static void main(String[] args) throws Exception {
        input();
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int small = Integer.parseInt(st.nextToken());
        int big = Integer.parseInt(st.nextToken());
        if(small > big){
            int tmp = small;
            small = big;
            big = tmp;
        }
        int gcd = GCD(small, big);
        int lcm = LCM(small, big, gcd);
        System.out.println(gcd);
        System.out.println(lcm);
    }
    static int LCM(int small, int big, int gcd){
        return small*big/gcd;
    }
    static int GCD(int small, int big){
        while(true){
            int tmp = big % small;
            if(tmp == 0) break;
            big = small;
            small = tmp;
        }
        return small;
    }
}
