package com.algo0316;
import java.io.*;
public class Main_BOJ_2023_신기한소수 {
    static int N;
    static String[] startNumbers = {"2", "3", "5", "7"};
    static String[] numbers = {"1","3", "5", "7", "9"};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<startNumbers.length; i++){
            DFS(startNumbers[i]);
        }
    }
    static void DFS(String n){
        if(n.length() == N && isPrime(Integer.parseInt(n))){
            System.out.println(n);
            return;
        }else if(n.length() == N && !isPrime(Integer.parseInt(n))){
            return;
        }
        String temp = n;
        for(int i=0; i<numbers.length; i++){
            if(isPrime(Integer.parseInt(temp+numbers[i]))){
                DFS(temp+numbers[i]);
            }
        }
    }
    static boolean isPrime(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}