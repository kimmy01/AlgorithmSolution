package com.algo0319;
import java.io.*;
import java.util.*;
public class Main_BOJ_1019_책페이지 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //35일 때
        int[] answer = new int[10];
        int point = 1; //자리 수
        int start = 1;

        while(start<=N){
            while(N%10 != 9 && start <= N){
                calc(N, answer, point);
                N--;
            }
            if(N<start)break;
            //start의 마지막 자리를 0으로 만들어주기
            while(start%10 != 0 && start <= N){
                calc(start, answer, point);
                start++;
            }
            start /= 10;
            N /= 10;
            //반복되는 등장 횟수 더해주기
            for(int i=0; i<10; i++){
                answer[i] += (N-start+1)*point;
            }
            point *= 10;
        }
        for(int i=0; i<10; i++){
            System.out.print(answer[i]+" ");
        }
    }
    static void calc(int x, int[] answer, int point){ //x를 10으로 나누면서 자리 수를 나눠 answer 배열에 더해준다.
        while(x > 0){ //x가 35일 때 -> x가 3일 때
            answer[x%10] += point; //answer[5]+=1 -> answer[3] +=1; [0, 0, 0, 1, 0, 1, 0, 0, 0, 0]
            x /= 10; //x=3 -> x=0
        }
    }
}