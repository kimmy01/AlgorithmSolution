package com.algo2022_01;

import java.io.*;

public class Main2312 {
    static int N;
    static int[] numbers;
    static boolean[] primeNum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }
        eratosthenes();
        for(int i=0; i<numbers.length; i++) {
            int[] count = new int[numbers[i]+1];
            int number = numbers[i];
            for(int j=2; j<=numbers[i]; j++) {
                if(primeNum[j]){
                    while(true){
                        if(number % j == 0){
                            count[j]++;
                            number /=j;
                            continue;
                        }
                        break;
                    }
                }
            }
            for(int j=2; j<=numbers[i]; j++){
                if(count[j] > 0) System.out.println(j + " " +count[j]);
            }
        }
    }
    static void eratosthenes(){
        primeNum = new boolean[100001];
        for(int i=2; i<100001; i++){
            primeNum[i] = true;
        }
        for(int i=2; i<100001; i++){
            for(int j=i*i; i<100001; i*=j){
                if(primeNum[j]){
                    primeNum[j] = false;
                }
            }
        }
    }
}
