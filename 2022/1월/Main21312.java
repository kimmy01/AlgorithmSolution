package com.algo2022_01;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main21312 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(A);
        list.add(B);
        list.add(C);
        list.add(A*B);
        list.add(A*C);
        list.add(B*C);
        list.add(A*B*C);
        for(int i=0; i<list.size(); i++){
            if(answer == 0){
                answer = list.get(i);
                continue;
            }
            if(answer % 2 == 1){
                if(list.get(i) % 2 == 1){
                    answer = Math.max(answer, list.get(i));
                    continue;
                }
            }else{
                if(list.get(i) % 2 == 1){
                    answer = list.get(i);
                    continue;
                }
                answer = Math.max(list.get(i), answer);
            }
        }
        System.out.println(answer);
    }
}
