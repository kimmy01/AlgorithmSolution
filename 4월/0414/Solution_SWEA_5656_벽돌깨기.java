package com.algo0413;
import java.io.*;
import java.util.*;
public class Solution_SWEA_5656_벽돌깨기 {
    static class Block {
        int h;
        int w;
        int range;
        public Block(int h, int w, int range){
            this.h = h;
            this.w = w;
            this.range = range;
        }
    }
    static int T, N, W, H, answer;
    static int[] dh = {-1, 1, 0, 0};
    static int[] dw = {0, 0, -1, 1};
    static int[] spots;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Block> q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            q = new LinkedList<>();
            spots = new int[N];
            answer = 123456789;

            for(int i=0; i<H; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<W; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            func(0);
            System.out.println("#"+t+" "+answer);
        }
    }
    static void func(int spot){
        if(spot == N){
            int[][] copy = copyMap(); //배열 깊은 복사
            int block = 0; //남은 블록 개수
            for(int i=0; i<N; i++){
                visited = new boolean[H][W]; //방문처리
                selectCrash(copy, spots[i]); //벽돌깨기
                compact(copy); //벽돌 내리기
            }
            block = count(copy);
            answer = Math.min(answer, block);
            return;
        }
        for(int i=0; i<W; i++){ //중복조합
            spots[spot] = i;
            func(spot+1);
        }
    }
    static void selectCrash(int[][] copy, int spot){
        for(int i=0; i<H; i++){
            if(copy[i][spot] > 0){ //제일 첫번째로 만나는 벽돌
                q.add(new Block(i, spot, copy[i][spot]));
                break;
            }
        }
        while(!q.isEmpty()){
            Block current = q.poll();
            for(int i=0; i<4; i++){
                for(int j=0; j<current.range; j++){ //벽돌 범위가 3이라면? 현재 칸 부터 0, 1, 2 칸 깨기
                    int nh = current.h + dh[i]*j;
                    int nw = current.w + dw[i]*j;
                    if(inRange(nh, nw) && !visited[nh][nw]){ //범위 이내 && 미방문
                        visited[nh][nw] = true; //방문체크
                        q.add(new Block(nh, nw, copy[nh][nw])); //큐 삽입
                        copy[nh][nw] = 0; //깬 벽돌 0으로 변경
                    }
                }
            }
        }
    }
    static void compact(int[][] copy){
        Queue<Integer> tmp = new LinkedList<>();
        for(int j=0; j<W; j++){ //0번 열부터 ~ W-1번 열까지
            for(int i=H-1; i>=0; i--){ //맨 아래칸 부터 위로 올라가면서 0보다 큰 값 담기
                if(copy[i][j]>0){
                    tmp.add(copy[i][j]);
                }
            }
            for(int i=H-1; i>=0; i--){ //맨 아래칸 부터 순서대로 넣어주기, 다 넣으면 0으로 나머지 채우기
                if(!tmp.isEmpty()){
                    copy[i][j] = tmp.poll();
                }else{
                    copy[i][j] = 0;
                }
            }
        }
    }
    static int count(int[][] copy){
        int block = 0;
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(copy[i][j] > 0) block++;
            }
        }
        return block;
    }
    static int[][] copyMap(){
        int[][] arr = new int[H][W];
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                arr[i][j] = map[i][j];
            }
        }
        return arr;
    }
    static boolean inRange(int nh, int nw){
        if(0<=nh && nh<H && 0<=nw && nw<W) return true;
        return false;
    }
}
