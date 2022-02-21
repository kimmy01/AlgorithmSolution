package com.algo2022_02;

import java.io.*;
import java.util.*;
import java.math.*;
public class Main2824 {
    static int N, M;
    static BigInteger A, B;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new BigInteger("1");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            A = A.multiply(new BigInteger(st.nextToken()));
        }
        M = Integer.parseInt(br.readLine());
        B = new BigInteger("1");
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++){
            B = B.multiply(new BigInteger(st.nextToken()));
        }
        BigInteger GCD = A.gcd(B);
        String answer = GCD.toString();
        if(answer.length() > 9){
            answer = answer.substring(answer.length() - 9);
        }
        System.out.println(answer);
    }
}
