package com.algo0313;
import java.util.*;
import java.io.*;
public class Main_BOJ_1003_피보나치함수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] zero = new int[41];
        int[] one = new int[41];
        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;
        for(int i=2; i<41; i++){
            zero[i] = zero[i-1]+zero[i-2];
            one[i] = one[i-1]+one[i-2];
        }
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            System.out.print(zero[n]+" ");
            System.out.print(one[n]+" ");
            System.out.println();
        }
    }
}
