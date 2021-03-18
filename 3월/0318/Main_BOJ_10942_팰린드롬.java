package com.algo0318;
import java.util.*;
import java.io.*;
public class Main_BOJ_10942_팰린드롬 {
    static int[][] palindrome;
    static int[] num;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        num = new int[N+1];
        palindrome = new int[N+1][N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++){
            palindrome[i][i] = 1;
            if(num[i] == num[i-1]){
                palindrome[i-1][i] = 1;
            }
        }
        isPalindrome();
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(palindrome[a][b]+"\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
    }
    static void isPalindrome(){
        for(int j=2; j<N; j++){
            for(int i=1; i+j<=N; i++){
                if(num[i]==num[i+j] && palindrome[i+1][i+j-1] == 1){
                    palindrome[i][i+j] = 1;
                }
            }
        }
    }
}