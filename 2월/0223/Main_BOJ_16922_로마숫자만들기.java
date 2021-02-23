package com.algo0223;
import java.io.*;
public class Main_BOJ_16922_로마숫자만들기 {
    static int[] roman = {50, 10, 5, 1};
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        solution(N);
    }
    static void solution(int N){
        answer = 0;
        Sum(N, 0, 0, new boolean[1001]);
        System.out.println(answer);
    }
    static void Sum(int n, int sum, int index, boolean[] visited){
        if(n==0){
            if(!visited[sum]){
                visited[sum] = true;
                answer++;
            }
            return;
        }
        for(int i=index; i<4; i++){
            Sum(n-1, sum+roman[i], i, visited);
        }
    }
}
