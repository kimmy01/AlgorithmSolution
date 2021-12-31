package com.algo0413;
import java.util.*;
import java.io.*;
public class Main_BOJ_17144_미세먼지안녕 {
    static class Dust{
        int current;
        int r;
        int c;
        public Dust(int current, int r, int c){
            this.current = current;
            this.r = r;
            this.c = c;
        }
    }
    static int R, C, T, air, answer;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] room;
    static ArrayList<Dust> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        room = new int[R][C];
        list = new ArrayList<>();
        air = -1;
        answer = 0;
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<C; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
                if(air == -1 && room[i][j] == -1){
                    air = i;
                }
            }
        }
        for(int t=0; t<T; t++){
            setList();
            spread();
            operate();
        }
        calc();
        System.out.println(answer);
    }
    static void spread(){
        for(int l=0; l<list.size(); l++){
            Dust d = list.get(l);
            if(d.current < 5) continue;
            int currentR = d.r;
            int currentC = d.c;
            int dust = d.current/5;
            int count = 0;
            for(int i=0; i<4; i++){
                int nextR = currentR + dr[i];
                int nextC = currentC + dc[i];
                if(inRange(nextR, nextC) && room[nextR][nextC] != -1){
                    count++;
                    room[nextR][nextC] += dust;
                }
            }
            room[currentR][currentC] -= dust*count;
        }
    }
    static void setList(){
        list.clear();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(room[i][j] > 0){
                    list.add(new Dust(room[i][j], i, j));
                }
            }
        }
    }
    static void operate(){
        int top = air;
        int down = air+1;
        //위쪽 공기청정기
        //아래로
        for(int i=top-1; i>0; i--){
            room[i][0] = room[i-1][0];
        }
        //왼쪽으로
        for(int i=0; i<C-1; i++){
            room[0][i] = room[0][i+1];
        }
        //위로
        for(int i=0; i<top; i++){
            room[i][C-1] = room[i+1][C-1];
        }
        //오른쪽으로
        for(int i=C-1; i>1; i--){
            room[top][i] = room[top][i-1];
        }
        room[top][1] = 0;
        //아래쪽 공기청정기
        //위로
        for(int i=down+1; i<R-1; i++){
            room[i][0] = room[i+1][0];
        }
        //왼쪽으로
        for(int i=0; i<C-1; i++){
            room[R-1][i] = room[R-1][i+1];
        }
        //아래로
        for(int i=R-1; i>down; i--){
            room[i][C-1] = room[i-1][C-1];
        }
        //오른쪽으로
        for(int i=C-1; i>1; i--){
            room[down][i] = room[down][i-1];
        }
        room[down][1] = 0;
    }
    static void calc(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(room[i][j] != -1){
                    answer += room[i][j];
                }
            }
        }
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<R && 0<=nc && nc<C) return true;
        return false;
    }
}
