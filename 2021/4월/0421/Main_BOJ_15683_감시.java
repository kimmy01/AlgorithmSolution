package com.algo0421;
import java.util.*;
import java.io.*;
public class Main_BOJ_15683_감시 {
    static class A{
        int zero;
        int[][] map;
        public A(int zero, int[][] map){
            this.zero = zero;
            this.map = map;
        }
    }
    static int N, M, minZero;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] arr;
    static int[][] dir = {
            {1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1},
            {1, 0, 1, 0}, {0, 1, 0, 1},
            {1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 1}, {1, 0, 0, 1},
            {1, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1},
            {1, 1, 1, 1}
    };
    static ArrayList<int[]> a = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        minZero = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) minZero++;
                if(0 < arr[i][j] && arr[i][j] < 6){
                    a.add(new int[]{i, j});
                }
            }
        }
        BFS(minZero, arr);
        System.out.println(minZero);
    }
    static void BFS(int zero, int[][] map){
        Queue<A> q = new LinkedList<>();
        q.add(new A(zero, map));
        for(int i=0; i<a.size(); i++){
            int qSize = q.size();
            for(int j=0; j<qSize; j++){
                A tmp = q.poll();
                int[][] tmpMap = tmp.map;
                int z = tmp.zero;
                int r = a.get(i)[0];
                int c = a.get(i)[1];

                if(map[r][c] == 1){
                    q.add(cctv(tmpMap, r, c, z, dir[0]));
                    q.add(cctv(tmpMap, r, c, z, dir[1]));
                    q.add(cctv(tmpMap, r, c, z, dir[2]));
                    q.add(cctv(tmpMap, r, c, z, dir[3]));
                }
                if(map[r][c] == 2){
                    q.add(cctv(tmpMap, r, c, z, dir[4]));
                    q.add(cctv(tmpMap, r, c, z, dir[5]));
                }
                if(map[r][c] == 3){
                    q.add(cctv(tmpMap, r, c, z, dir[6]));
                    q.add(cctv(tmpMap, r, c, z, dir[7]));
                    q.add(cctv(tmpMap, r, c, z, dir[8]));
                    q.add(cctv(tmpMap, r, c, z, dir[9]));
                }
                if(map[r][c] == 4){
                    q.add(cctv(tmpMap, r, c, z, dir[10]));
                    q.add(cctv(tmpMap, r, c, z, dir[11]));
                    q.add(cctv(tmpMap, r, c, z, dir[12]));
                    q.add(cctv(tmpMap, r, c, z, dir[13]));
                }
                if(map[r][c] == 5){
                    q.add(cctv(tmpMap, r, c, z, dir[14]));
                }
            }
        }
    }
    static A cctv(int[][] map, int r, int c, int zero, int[] direction){
        int[][] copied = mapCopy(map);
        for(int i=0; i<4; i++){
            if(direction[i]==0) continue;
            int nr = r;
            int nc = c;
            while(true){
                nr = r + dr[i];
                nc = c + dc[i];
                if(!inRange(nr, nc)) break;
                if(copied[nr][nc] == 6) break;
                if(copied[nr][nc] == 0){
                    copied[nr][nc] = -1;
                    zero--;
                }
            }
        }
        if(minZero > zero) {
            minZero = zero;
        }
        return new A(zero, copied);
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<N && 0<=nc && nc<M) return true;
        return false;
    }
    static int[][] mapCopy(int[][] original){
        int[][] copied = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                copied[i][j] = original[i][j];
            }
        }
        return copied;
    }
}
