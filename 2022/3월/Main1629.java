package com.algo2022_03;

import java.io.*;
import java.util.*;

public class Main1629 {
    static int A, B, C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(calc(A, B));
    }
    static long calc(int a, int b){
        if(b == 1) return a % C;
        long tmp = calc(a, b/2);
        if(b%2 == 1)
            return (tmp*tmp%C)*a%C;
        return tmp*tmp%C;
    }
}
