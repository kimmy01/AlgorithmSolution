package com.algo0312;
import java.util.*;
import java.io.*;
class virusPoint{
    int row;
    int col;
    public virusPoint(int row, int col){
        super();
        this.row = row;
        this.col = col;
    }
}
public class Main_BOJ_14502_연구소 {
    static int N, M, max;
    static int[][] map, wallmap;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<virusPoint> virus;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        max = Integer.MIN_VALUE;
        map = new int[N][M]; //기존 지도
        wallmap = new int[N][M]; //벽 세운 지도
        virus = new ArrayList<>(); //바이러스 좌표 모음
        for(int i=0; i<N; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 2){
                    virus.add(new virusPoint(i, j));
                }
            }
        }
        wallmap = copyMap(map);
        wall(0);
        System.out.println(max);
    }
    static boolean isValid(int row, int col){ //배열 범위 체크
        if(row<0 || row>=N || col<0 || col>=M){
            return false;
        }
        return true;
    }
    static int[][] copyMap(int[][] array){ //배열 복사
        int[][] copy = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                copy[i][j] = array[i][j];
            }
        }
        return copy;
    }
    static void wall(int num){ //벽 세우기
        if(num==3){
            spreading(); //바이러스 퍼뜨리기
            return;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(wallmap[i][j] == 0){ //빈칸이면
                    wallmap[i][j] = 1; //벽 세우기
                    wall(num+1); //다음 턴 돌리기
                    wallmap[i][j] = 0; //벽 안세우기
                }
            }
        }
    }
    static void spreading(){
        int[][] copyWall = copyMap(wallmap); //벽 세우기한 지도 복사
        Queue<virusPoint> queue = new LinkedList<>(); //바이러스 좌표 큐
        for(int i=0; i<virus.size(); i++){
            queue.add(new virusPoint(virus.get(i).row, virus.get(i).col));
        }
        while(!queue.isEmpty()){ //바이러스 퍼뜨리기
            int curRow = queue.peek().row;
            int curCol = queue.poll().col;
            for(int i=0; i<4; i++){
                int nextRow = curRow+dr[i];
                int nextCol = curCol+dc[i];
                if(isValid(nextRow, nextCol) && copyWall[nextRow][nextCol] == 0){
                    copyWall[nextRow][nextCol] = 2;
                    queue.add(new virusPoint(nextRow, nextCol));
                }
            }
        }
        int safe = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copyWall[i][j] == 0){
                    safe++;
                }
            }
        }
        max = Math.max(safe, max);
    }
}
