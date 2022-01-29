package com.algo2022_01;
import java.io.*;
import java.util.StringTokenizer;

public class Main1018 {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] chessW;
    static boolean[][] checkedW;
    static char[][] chessB;
    static boolean[][] checkedB;
    public static void main(String[] args) throws Exception{
        input();
        func();
    }
    static void func() {
        bruteforce('W', chessW, checkedW);
        bruteforce('B', chessB, checkedB);
        int min = 123456789;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(i+8 <= N && j+8 <= M){
                    int a = findMap(i, j, checkedW);
                    int b = findMap(i, j, checkedB);
                    if(a < b){
                        min = Math.min(min, a);
                    }else{
                        min = Math.min(min, b);
                    }
                }
            }
        }
        System.out.println(min);
    }

    static int findMap(int startI, int startJ, boolean[][] map){
        int count = 0;
        for(int i=startI; i<startI+8; i++){
            for(int j=startJ; j<startJ+8; j++){
                if(map[i][j])
                    count++;
            }
        }
        return count;
    }

    static void bruteforce(char c, char[][] chessMap, boolean[][] checkedMap) {
        if(chessMap[0][0] != c){
            chessMap[0][0] = c;
            checkedMap[0][0] = true;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                char now = chessMap[i][j];
                for(int k=0; k<4; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if(0<=nr && nr<N && 0<=nc && nc<M && chessMap[nr][nc] == now){
                        if(now == 'W')
                            chessMap[nr][nc] = 'B';
                        else
                            chessMap[nr][nc] = 'W';
                        checkedMap[nr][nc] = true;
                    }
                }
            }
        }
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chessW = new char[N][M];
        chessB = new char[N][M];
        checkedW = new boolean[N][M];
        checkedB = new boolean[N][M];
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<M; j++){
                char c = tmp.charAt(j);
                chessW[i][j] = c;
                chessB[i][j] = c;
            }
        }
    }
}
