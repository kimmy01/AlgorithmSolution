package com.algo0424;
import java.io.*;
import java.util.*;
public class Main_BOJ_2947_나무조각 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] woods = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<5; i++){
            woods[i] = Integer.parseInt(st.nextToken());
        }
        while(true){
            int flag = 0;
            for(int i=0; i<4; i++){
                if(woods[i]>woods[i+1]){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) break;

            for(int i=0; i<4; i++){
                if(woods[i] > woods[i+1]){
                    int tmp = woods[i];
                    woods[i] = woods[i+1];
                    woods[i+1] = tmp;
                    for(int j=0; j<5; j++){
                        System.out.print(woods[j]+" ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
