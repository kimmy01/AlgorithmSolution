package com.algo2022_02;
import java.util.*;
import java.io.*;
public class Main1929 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] primeNum = new boolean[1000001];
        for(int i=0; i<=1000000; i++){
            primeNum[i] = true;
        }
        primeNum[1] = false;
        for(int i=2; i<=1000000; i++){
            for(int j=i+i; j<=1000000; j+=i){
                primeNum[j] = false;
            }
        }
        for(int i=M; i<=N; i++){
            if(primeNum[i]){
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }
        bw.flush();
    }
}
