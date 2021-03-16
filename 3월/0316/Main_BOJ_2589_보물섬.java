package com.algo0316;
import java.util.*;
import java.io.*;
class Node{
    int r;
    int c;
    Node(int r, int c){
        this.r = r;
        this.c = c;
    }
}
public class Main_BOJ_2589_보물섬 {
    static int H, W, max;
    static char[][]map;
    static int[][]distance;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static ArrayList<Node> arrayList = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        map = new char[H][W];
        for(int i=0; i<H; i++){
            String a = br.readLine();
            for(int j=0; j<W; j++){
                map[i][j] = a.charAt(j);
                if(map[i][j] == 'L'){
                    arrayList.add(new Node(i, j));
                }
            }
        }
        for(int i=0; i<arrayList.size(); i++){
            Node node = arrayList.get(i);
            visited = new boolean[H][W];
            BFS(node);
        }
        System.out.println(max);
    }
    static void BFS(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited[node.r][node.c] = true;
        distance = new int[H][W];
        while(!queue.isEmpty()){
            Node n = queue.poll();
            for(int i=0; i<4; i++){
                int nr = n.r+dr[i];
                int nc = n.c+dc[i];
                if(inRange(nr, nc)){
                    if(map[nr][nc] == 'L' && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        distance[nr][nc] = distance[n.r][n.c]+1;
                        queue.add(new Node(nr, nc));
                    }
                }
            }
        }
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                max = Math.max(max, distance[i][j]);
            }
        }
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<H && 0<=nc && nc<W){
            return true;
        }
        return false;
    }
}