package com.victoria;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer stk = new StringTokenizer(s, " ");
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int R = Integer.parseInt(stk.nextToken());
        int[][] map = new int[N][M];
        int[][] copy = new int[N][M];
        for(int i=0; i<N; i++) {
            s = br.readLine();
            stk = new StringTokenizer(s, " ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int num;
        if(N>M) {
            num = M/2; //사각형 개수
        }else {
            num = N/2;
        }

        int[] up = {M-1, 0, N-1}; //시작인덱스 끝인덱스 고정된 y
        int[] down = {0, M-1, 0}; //시작인덱스 끝인덱스 고정된 y
        int[] left = {N-1, 0, 0}; //시작인덱스 끝인덱스 고정된 x
        int[] right = {0, N-1, M-1}; //시작인덱스 끝인덱스 고정된x
        /////////////////////////////////////////////////////
        int[] dx = {0, 1, 0, -1}; //좌하우상
        int[] dy = {-1, 0, 1, 0}; //좌하우상
        /////////////////////////////////////////////////////
        int count = 0;
        int rx;
        int ry;
        while(count<num) {
            //세로로 올리기
            for(int i=up[0]; i>up[1]; i--) {
                rx = i;
                ry = up[2];
                copy[rx+dx[3]][ry+dy[3]] = map[rx][ry];
            }
            up[0]-=1;
            up[1]+=1;
            up[2]-=1;
            //세로로 내리기
            for(int i=down[0]; i<down[1]; i++) {
                rx = i;
                ry = down[2];
                copy[rx+dx[1]][ry+dy[1]] = map[rx][ry];
            }
            down[0]+=1;
            down[1]-=1;
            down[2]+=1;
            //왼쪽으로
            for(int i=left[0]; i>left[1]; i--) {
                rx = left[2];
                ry = i;
                copy[rx+dx[0]][ry+dy[0]] = map[rx][ry];
            }
            left[0]-=1;
            left[1]+=1;
            left[2]+=1;
            //오른쪽으로
            for(int i=right[0]; i<right[1]; i++) {
                rx = right[2];
                ry = i;
                copy[rx+dx[2]][ry+dy[2]] = map[rx][ry];
            }
            right[0]+=1;
            right[1]-=1;
            right[2]-=1;

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    map[i][j] = copy[i][j];
                }
            }
            count++;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}