package com.algo0416;
import java.util.*;
import java.io.*;
public class Main_BOJ_2239_스도쿠 {
    static class Point{
        int i;
        int j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    static int[][] map;
    static boolean isFinished = false;
    static ArrayList<Point> list = new ArrayList();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        for(int i=0; i<9; i++){
            String s = br.readLine();
            for(int j=0; j<9; j++){
                map[i][j] = s.charAt(j)-'0';
                if(map[i][j] == 0){ //스도쿠 빈 칸 좌표 리스트에 담기
                    list.add(new Point(i,j));
                }
            }
        }
        DFS(0);
    }
    static void DFS(int index){
        if(index >= list.size()){ // 스도쿠의 빈 칸을 모두 탐색했다면 종료
            isFinished = true;
            print();
            return;
        }
        if(isFinished) return;
        Point current = list.get(index); // 제일 첫 번째 칸부터
        int r = current.i;
        int c = current.j;
        for(int i=1; i<=9; i++){
            int tmp = map[r][c];
            if(isRow(r, i) || isColumn(c, i) || isSquare(r, c, i)) continue; // 이미 해당 숫자가 행, 열, 사각형에 있으면 continue
            map[r][c] = i; // 행, 열, 사각형에 해당 숫자 없으면 그 값으로 넣기
            DFS(index+1);
            map[r][c] = tmp;
        }
    }
    static boolean isSquare(int r, int c, int num){
        int squareR = r/3 *3; // 5번째 행이라면? (5/3)*3 = 3 (3번행부터 5번행까지)
        int squareC = c/3 *3; // 7번째 열이라면? (7/3)*3 = 6 (6번열부터 9번열까지)
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(map[squareR+i][squareC+i] == num) return true;
            }
        }
        return false;
    }
    static boolean isRow(int r, int num){ // 행 탐색
        for(int i=0; i<9; i++){
            if(map[r][i] == num) return true;
        }
        return false;
    }
    static boolean isColumn(int c, int num){ // 열 탐색
        for(int i=0; i<9; i++){
            if(map[i][c] == num) return true;
        }
        return false;
    }
    static void print(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
