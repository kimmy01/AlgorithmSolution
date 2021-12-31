package com.victoria;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3 {
    static int N;
    static int M;
    static int R;
    static int[][] arr;
    static int[] row5;
    static int[] col5;
    static int[] row6;
    static int[] col6;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        StringTokenizer stk = new StringTokenizer(a, " ");
        N = Integer.parseInt(stk.nextToken()); //배열 행 인덱스
        M = Integer.parseInt(stk.nextToken()); //배열 열 인덱스
        R = Integer.parseInt(stk.nextToken()); //연산 횟수
        arr = new int[N][M];
        row5 = new int[]{0, N/2, 0, -N/2};//우하좌상
        col5 = new int[]{M/2, 0, -M/2, 0};//우하좌상

        row6 = new int[]{N/2, 0, -N/2, 0};//하좌상우
        col6 = new int[]{0, -M/2, 0, M/2};//하좌상우
        for(int i=0; i<N; i++){
            a = br.readLine();
            stk = new StringTokenizer(a, " ");
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }//배열 입력받기
        a = br.readLine();
        stk = new StringTokenizer(a, " ");
        for(int i=0; i<R; i++){
            int num = Integer.parseInt(stk.nextToken());
            switch(num){
                case 1: operate1();break;
                case 2: operate2();break;
                case 3: operate3();break;
                case 4: operate4();break;
                case 5: operate5();break;
                case 6: operate6();break;
            }
        }//연산번호 입력받기
        print();
    }

/////////////////////////////////////////////////////////////////////////////////////////

    static void print(){
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void operate1(){
        int temp3[][] = new int[N][M];
        for(int j=0; j<M; j++){
            int k=N-1;
            for(int i=0; i<N; i++){
                temp3[k][j] = arr[i][j];
                k--;
            }
        }
        arr = temp3.clone();
    }
    static void operate2(){
        int temp3[][] = new int[N][M];
        for(int i=0; i<N; i++){
            int k=0;
            for(int j=M-1; j>=0; j--){
                temp3[i][k] = arr[i][j];
                k++;
            }
        }
        arr = temp3.clone();
    }
    static void operate3(){
        int temp3[][] = new int[M][N];
        int k=N-1;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                temp3[j][k] = arr[i][j];
            }
            k--;
        }
        int tmp = N;
        N = M;
        M = tmp;
        arr = temp3.clone();
    }
    static void operate4(){
        int temp3[][] = new int[M][N];
        int k=M-1;
        int y=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                temp3[k][y] = arr[i][j];
                k--;
            }
            k = M-1;
            y++;
        }
        int tmp = N;
        N = M;
        M = tmp;
        arr = temp3.clone();
    }
    static void operate5(){
        int temp3[][] = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(j<M/2 && i<N/2){//1번 영역
                    temp3[i+row5[0]][j+col5[0]] = arr[i][j];
                }else if(j>=M/2 && i<N/2){//2번 영역
                    temp3[i+row5[1]][j+col5[1]] = arr[i][j];
                }else if(j<M/2 && i>=N/2){//4번 영역
                    temp3[i+row5[3]][j+col5[3]] = arr[i][j];
                }else if(j>=M/2 && i>=N/2){//3번 영역
                    temp3[i+row5[2]][j+col5[2]] = arr[i][j];
                }
            }
        }
        arr = temp3.clone();
    }
    static void operate6(){
        int temp3[][] = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(j<M/2 && i<N/2){//1번 영역
                    temp3[i+row6[0]][j+col6[0]] = arr[i][j];
                }else if(j>=M/2 && i<N/2){//2번 영역
                    temp3[i+row6[1]][j+col6[1]] = arr[i][j];
                }else if(j<M/2 && i>=N/2){//4번 영역
                    temp3[i+row6[3]][j+col6[3]] = arr[i][j];
                }else if(j>=M/2 && i>=N/2){//3번 영역
                    temp3[i+row6[2]][j+col6[2]] = arr[i][j];
                }
            }
        }
        arr = temp3.clone();
    }
}