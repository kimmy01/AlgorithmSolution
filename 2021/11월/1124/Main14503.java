package com.algo11;

import java.util.*;
import java.io.*;

public class Main14503 {
    static int N, M, r, c, d;
    static int [][] map;
    static int [][] direction = {{0, -1, 3}, {-1, 0, 0}, {0, 1, 1}, {1, 0, 2}}; //왼쪽회전&그때방향
    static int [][] back = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}}; //현재방향에서 후진
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    private static void func() {
        int count = 0;
        while(true){
            int nr = r + direction[d][0];
            int nc = c + direction[d][1];
            if(map[nr][nc] == 0){ //왼쪽방향에 청소할 곳 있으면 이동해서 청소
                d = direction[d][2];
                r = nr;
                c = nc;
                map[r][c] = 2;
                count = 0;
            }else{ //이동할 곳 없으면 회전
                d = direction[d][2];
                count++;
                if(count == 4){
                    nr = r + back[d][0];
                    nc = c + back[d][1];
                    if(map[nr][nc] != 1){
                        r = nr;
                        c = nc;
                        count = 0;
                    }else{
                        break;
                    }
                }
            }
        }
        System.out.println(countClean());
    }
    private static int countClean(){
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != 0 && map[i][j] != 1) count++;
            }
        }
        return count;
    }
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken()); //행
        M = stoi(st.nextToken()); //열
        st = new StringTokenizer(br.readLine(), " ");
        r = stoi(st.nextToken()); //청소기 첫 행
        c = stoi(st.nextToken()); //청소기 첫 열
        d = stoi(st.nextToken()); //청소기 첫 방향 => 0북 1동 2남 3서
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }
        map[r][c] = 2;
    }
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
