package com.algo0324;
import java.io.*;
import java.util.*;
public class Main_BOJ_2636_치즈 {
    static int H, W;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static Queue<int[]> outsideCheese = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int lastCheese = 0;
        int hours = 0;
        while(true){
            outsideAir();
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(map[i][j] == 1 && isOutsideCheese(i, j)){
                        map[i][j] = 2;
                        outsideCheese.add(new int[]{i, j});
                    }
                }
            }
            if(outsideCheese.isEmpty()) {
                break;
            }
            lastCheese = countLastCheese();
            meltingCheese();
            hours++;
        }
        System.out.println(hours);
        System.out.println(lastCheese);
    }
    //남은 치즈 개수 세기
    static int countLastCheese(){
        int last = 0;
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(map[i][j] == 2){
                    last++;
                }
            }
        }
        return last;
    }
    //가장자리에 있는 치즈 녹이기
    static void meltingCheese(){
        while(!outsideCheese.isEmpty()){
            int[] temp = outsideCheese.poll();
            map[temp[0]][temp[1]] = -1;
        }
    }
    //가장자리 치즈인지 확인하기
    static boolean isOutsideCheese(int r, int c){
        for(int i=0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(map[nr][nc] == -1){
                return true;
            }
        }
        return false;
    }
    //바깥공기 체크 & 바깥공기 내부공기 구분
    static void outsideAir(){
        boolean[][] visitedOA = new boolean[H][W];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0}); //0, 0부터 탐색 시작
        map[0][0] = -1; //0, 0 바깥공기니까 -1로 변경
        visitedOA[0][0] = true; //방문 체크

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int i=0; i<4; i++){
                int nr = temp[0]+dr[i];
                int nc = temp[1]+dc[i];
                //다음 칸이 배열의 범위 내에 있고, 방문하지 않았고, 값이 1보다 작다면
                if(inRange(nr, nc) && !visitedOA[nr][nc] && map[nr][nc]<1){
                    map[nr][nc] = -1;
                    visitedOA[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
    //범위 체크
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<H && 0<=nc && nc<W){
            return true;
        }
        return false;
    }
}