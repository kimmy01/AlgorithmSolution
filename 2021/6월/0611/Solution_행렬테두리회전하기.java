package com.algo0611;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Solution_행렬테두리회전하기 {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        //int result = {8, 10, 25};

        int[] answer = new int[queries.length];
        int num = 1;
        int[][] map = new int[rows+1][columns+1];
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j] = num;
                num++;
            }
        } //행렬 채우기

        for(int i=0; i< queries.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            int row1 = queries[i][0];
            int col1 = queries[i][1];
            int row2 = queries[i][2];
            int col2 = queries[i][3];
            //오른쪽으로 이동 row1,col1 -> row1,col2
            int tmp1 = map[row1][col2];
            for(int j=col2; j>col1; j--){
                map[row1][j] = map[row1][j-1];
                list.add(map[row1][j]);
            }
            //밑으로 이동 row1,col2 -> row2,col2
            int tmp2 = map[row2][col2];
            for(int j=row2; j>row1; j--){
                if(j == row1+1){
                    map[j][col2] = tmp1;
                }else{
                    map[j][col2] = map[j-1][col2];
                }
                list.add(map[j][col2]);
            }
            //왼쪽으로 이동 row2,col2 -> row2,col1
            int tmp3 = map[row2][col1];
            for(int j=col1; j<col2; j++){
                if(j == col2-1){
                    map[row2][j] = tmp2;
                }else{
                    map[row2][j] = map[row2][j+1];
                }
                list.add(map[row2][j]);
            }
            //위로 이동 row2,col1 -> row1,col1
            for(int j=row1; j<row2; j++){
                if(j == row2-1){
                    map[j][col1] = tmp3;
                }else{
                    map[j][col1] = map[j+1][col1];
                }
                list.add(map[j][col1]);
            }
            Collections.sort(list);
            answer[i] = list.get(0);
        }
    }
}
