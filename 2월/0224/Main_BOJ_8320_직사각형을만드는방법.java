package com.algo0224;
import java.io.*;
public class Main_BOJ_8320_직사각형을만드는방법 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] square = new boolean[n+1][n+1];
        int count = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i*j <= n && square[i][j]!=true){
                    square[i][j] = true;
                    square[j][i] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}