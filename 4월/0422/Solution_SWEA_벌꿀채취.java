package com.algo0422;
import java.util.*;
import java.io.*;
public class Solution_SWEA_벌꿀채취 {
    static int N, M, C, max;
    static int[] result;
    static int[][] honey;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            honey = new int[N][N];
            result = new int[N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<N; j++){
                    honey[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            select();
            Arrays.sort(result); //각 행 별 결과값 정렬
            int answer = result[N-1]+result[N-2]; //가장 큰 값 2개 더하기
            System.out.println("#"+t+" "+answer);
        }
    }
    static void select(){
        for(int i=0; i<N; i++){
            for(int j=0; j<=N-M; j++){
                max = 0;
                visited = new boolean[N];
                func(j, 0, 0, 0, honey[i].clone()); // 시작 열, 채취수익, 꿀의 양, 채취 횟수, 해당 행 복사
                result[i] = Math.max(result[i], max);
            }
        }
    }
    static void func(int start, int value, int size, int cnt, int[] row){
        if(size > C) return; // 꿀의 양이 C보다 크면 리턴
        max = Math.max(value, max); // 채취수익과 기존 max 중 더 큰 값 저장
        if(cnt == M) return; // 채취한 칸의 수가 M이면 리턴

        for(int i=start; i<start+M; i++){ //시작 열부터 M칸까지 반복
            if(!visited[i]){
                visited[i] = true;
                int a = row[i];
                func(start, value+(a*a), size+a, cnt+1, row);
                visited[i] = false;
            }
        }
    }
}
