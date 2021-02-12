package com.victoria;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10026_적녹색약 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] array = new char[N][N];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            array[i] = str.toCharArray();
        }//배열 입력받기
        int[] dx = {-1, 1, 0, 0}; //상하좌우
        int[] dy = {0, 0, -1, 1}; //상하좌우

        int area = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                boolean[] check = new boolean[4]; //0:상, 1:하, 2:좌, 3:우
                if(0<=i+dx[0] && i+dx[0]<N && 0<=j+dy[0] && j+dy[0]<N && array[i][j] == array[i+dx[0]][j+dy[0]]){ //상 자리가 인덱스 벗어나지 않고 현재와 같다면?
                    check[0] = true;
                }else if(0<=i+dx[1] && i+dx[1]<N && 0<=j+dy[1] && j+dy[1]<N && array[i][j] == array[i+dx[1]][j+dy[1]]){ //하 자리에 인덱스 벗어나지 않고 현재와 같다면?
                    check[1] = true;
                }else if(0<=i+dx[2] && i+dx[2]<N && 0<=j+dy[2] && j+dy[2]<N && array[i][j] == array[i+dx[2]][j+dy[2]]){ //좌 자리에 인덱스 벗어나지 않고 현재와 같다면?
                    check[2] = true;
                }else if(0<=i+dx[3] && i+dx[3]<N && 0<=j+dy[3] && j+dy[3]<N && array[i][j] == array[i+dx[3]][j+dy[3]]){ //우 자리에 인덱스 벗어나지 않고 현재와 같다면?
                    check[3] = true;
                }
                int flag = 0;
                int count = 0;
                for(int k=0; k<4; k++){
                    if(check[k] == true){
                        count++;
                    }
                }
                if(count>2){

                }
                if(flag == 0){
                    area++;
                }
            }
        }


        System.out.println(area);

    }
}