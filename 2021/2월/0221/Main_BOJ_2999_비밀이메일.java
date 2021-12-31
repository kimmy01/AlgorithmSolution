package com.algo02200221;
import java.io.*;
public class Main_BOJ_2999_비밀이메일 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String message = br.readLine();
        int N = message.length();
        int R=0;
        int C=0;
        int num = (int)Math.sqrt(N);
        for(int i=1; i<=num; i++){
            if(N%i==0){
                C = i;
                R = N/i;
            }
        }
        char[][] map = new char[R][C];
        int index = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                map[i][j] = message.charAt(index);
                index++;
            }
        }
        for(int j=0; j<C; j++){
            for(int i=0; i<R; i++){
                sb.append(map[i][j]);
            }
        }
        System.out.println(sb);
    }
}
