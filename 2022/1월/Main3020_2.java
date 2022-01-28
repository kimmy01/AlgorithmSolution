package com.algo2022_01;
import java.util.*;
import java.io.*;
public class Main3020_2 {
    static int N, H;
    static int[] jong;
    static int[] seok;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        for(int i=H-1; i>=1; i--){
            seok[i] += seok[i+1];
        }
        for(int i=2; i<=H; i++){
            jong[i] += jong[i-1];
        }
        int min = 123456789;
        int cnt = 0;
        for(int i=1; i<=H; i++){
            int tmp = seok[i] + jong[i];
            if(tmp < min){
                min = tmp;
                cnt = 1;
            }else if(tmp == min){
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        jong = new int[H+1];
        seok = new int[H+1];
        for(int i=0; i<N; i+=2){
            int j = Integer.parseInt(br.readLine());
            int s = Integer.parseInt(br.readLine());
            seok[j]++;
            jong[H+1-s]++;
        }
    }
}
/*
석순[5]
[1 , 1, 1111, 1, ]
[1, 1, 4, 1, 0] => 석순 끝부분의 높이(인덱스)의 개수
[7, 6, 5, 1, 0]
1번 구간 => 1, 2, 3, 4
2번 구간 => 2, 3, 4
3번 구간 => 3, 4
4번 구간 => 4


종유석[5]
[ , 11, 111, 11, ]
[0, 2, 3, 2, 0] => 종유석 끝부분의 높이(인덱스)의 개수

[7, 6, 5, 1, 0]
[0, 2, 5, 7, 7]

[7, 8, 10, 8, 7]

더하면서, 더 작은 값이 나오면 최소값 갱신, 개수 1개로 바꾸고, 똑같은 값 나오면 개수 늘리기!

*/