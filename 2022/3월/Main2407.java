package com.algo2022_03;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main2407 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        for(int i=0; i<M; i++){
            a = a.multiply(new BigInteger(String.valueOf(N-i)));
            b = b.multiply(new BigInteger(String.valueOf(i+1)));
        }
        BigInteger answer = a.divide(b);
        System.out.println(answer);
    }
}
