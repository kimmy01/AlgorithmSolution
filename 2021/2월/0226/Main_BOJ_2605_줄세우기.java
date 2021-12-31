package com.algo0226;

import java.io.*;
import java.util.*;

public class Main_BOJ_2605_줄세우기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> line = new ArrayList<>();
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            int temp = Integer.parseInt(stk.nextToken());
            if(temp == 0){
                line.add(i+1);
            }else{
                line.add(i-temp, i+1);
            }
        }
        for(int i=0; i<N; i++){
            System.out.print(line.get(i)+" ");
        }
    }
}