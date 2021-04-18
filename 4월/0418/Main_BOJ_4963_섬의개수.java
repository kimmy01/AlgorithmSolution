package com.algo0418;
import java.util.*;
import java.io.*;
public class Main_BOJ_4963_섬의개수 {
    static int W, H;
    static int[] dh = {-1, 1, 0, 0};
    static int[] dw = {0, 0, -1, 1};
    static int[][] map;
    static Queue<int[]> q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        q = new LinkedList<>();
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    map[i][j] = -1;
                    q.add(new int[]{i, j});
                }
            }
        }
    }
    static void BFS(int h, int w){

    }
    static boolean inRange(int nh, int nw){
        if(0<=nh && nh<H && 0<=nw && nw<W) return true;
        return false;
    }
}
