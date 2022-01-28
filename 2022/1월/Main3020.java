package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main3020 {
    static int N, H, count;
    static int[] A;
    static int[] B;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        int min = N;
        for(int i=1; i<=H; i++){
            int tmp = (A[H] - A[i-1]) + (B[1] - B[i+1]);
            if(tmp < min){
                min = tmp;
                count = 1;
            }else if(tmp == min){
                count++;
            }
        }
        System.out.println(min + " " + count);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        A = new int[H+2]; //석순
        B = new int[H+2]; //종유석
        for(int i=0; i<N/2; i++){
            A[Integer.parseInt(br.readLine())]++;
            B[H-Integer.parseInt(br.readLine())+1]++;
        }
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        for(int i=1; i<=H; i++){
            A[i] += A[i-1];
        }
        System.out.println(Arrays.toString(A));
        for(int i=H; i>=1; i--){
            B[i] += B[i+1];
        }
        System.out.println(Arrays.toString(B));
    }
}
