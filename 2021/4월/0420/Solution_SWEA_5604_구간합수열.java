package com.algo0420;
import java.util.*;
import java.io.*;
public class Solution_SWEA_5604_구간합수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long start = Long.parseLong(st.nextToken());
            long N =  Long.parseLong(st.nextToken());
            long[] answer = new long[10];
            long point = 1;

            if(start == 0) start = 1;
            while (start <= N) {
                //페이지의 일의 자리 숫자를 9로 만들어주기
                while (N % 10 != 9 && start <= N) {
                    calc(N, answer, point);
                    N--;
                }
                if (N < start) break;
                //start의 일의 자리를 0으로 만들어주기
                while (start % 10 != 0 && start <= N) {
                    calc(start, answer, point);
                    start++;
                }
                start /= 10;
                N /= 10;
                //반복되는 등장 횟수 더해주기
                for (int i = 0; i < 10; i++) {
                    answer[i] += (N - start + 1) * point;
                }
                //다음 자리수로 넘어가기 위해 10 곱해주기
                point *= 10;
            }
            long result = 0;
            for (int i = 0; i < 10; i++) {
                result += answer[i]*i;
            }
            System.out.println("#"+t+" "+result);
        }
    }
    static void calc ( long x, long[] answer, long point){ //x를 10으로 나누면서 자리 수를 나눠 answer 배열에 더해준다.
        while (x > 0) { //x가 35일 때 -> x가 3일 때
            int tmp = (int) (x%10);
            answer[tmp] += point; //answer[5]+=1 -> answer[3] +=1; [0, 0, 0, 1, 0, 1, 0, 0, 0, 0]
            x /= 10; //x=3 -> x=0
        }
    }
}