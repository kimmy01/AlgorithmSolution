package com.algo0415;
import java.util.*;
import java.io.*;
public class Solution_SWEA_1953_탈주범검거 {
    static class Tunnel{
        boolean up;
        boolean down;
        boolean left;
        boolean right;
        public Tunnel(boolean up, boolean down, boolean left, boolean right){
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
        }
    }
    static int N, M, R, C, L, answer;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] up = {1, 2, 5, 6};
    static int[] down = {1, 2, 4, 7};
    static int[] left = {1, 3, 4, 5};
    static int[] right = {1, 3, 6, 7};
    static int[][] map;
    static int[][] map2;
    static boolean[][] visited;
    static Tunnel[] tunnels;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tunnels = new Tunnel[8];
        tunnels[1] = new Tunnel(true, true, true, true);
        tunnels[2] = new Tunnel(true, true, false, false);
        tunnels[3] = new Tunnel(false, false, true, true);
        tunnels[4] = new Tunnel(true, false, false, true);
        tunnels[5] = new Tunnel(false, true, false, true);
        tunnels[6] = new Tunnel(false, true, true, false);
        tunnels[7] = new Tunnel(true, false, true, false);

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            answer = 0;
            map = new int[N][M];
            map2 = new int[N][M];
            visited = new boolean[N][M];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            BFS(R, C);
            System.out.println("#"+t+" "+answer);
        }
    }
    static void BFS(int R, int C){
        Queue<int[]> q = new LinkedList<>();
        int time = 1;
        map2[R][C] = time;
        visited[R][C] = true;
        q.add(new int[]{R, C, map[R][C], time});
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            int num = temp[2];
            time = temp[3];
            Tunnel current = tunnels[num];
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(inRange(nr, nc) && !visited[nr][nc]){
                    if(current.up && i == 0){
                        for(int j=0; j<up.length; j++){
                            if(map[nr][nc] == up[j]){
                                visited[nr][nc] = true;
                                map2[nr][nc] = time+1;
                                q.add(new int[]{nr, nc, map[nr][nc], time+1});
                            }
                        }
                    }
                    if(current.down && i == 1){
                        for(int j=0; j<down.length; j++){
                            if(map[nr][nc] == down[j]){
                                visited[nr][nc] = true;
                                map2[nr][nc] = time+1;
                                q.add(new int[]{nr, nc, map[nr][nc], time+1});
                            }
                        }
                    }
                    if(current.left && i == 2){
                        for(int j=0; j<left.length; j++){
                            if(map[nr][nc] == left[j]){
                                visited[nr][nc] = true;
                                map2[nr][nc] = time+1;
                                q.add(new int[]{nr, nc, map[nr][nc], time+1});
                            }
                        }
                    }
                    if(current.right && i == 3){
                        for(int j=0; j<right.length; j++){
                            if(map[nr][nc] == right[j]){
                                visited[nr][nc] = true;
                                map2[nr][nc] = time+1;
                                q.add(new int[]{nr, nc, map[nr][nc], time+1});
                            }
                        }
                    }
                }
            }
        }
        answer = count();
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<N && 0<=nc && nc<M) return true;
        return false;
    }
    static int count(){
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map2[i][j] <= L && map2[i][j] > 0) count++;
            }
        }
        return count;
    }
}
