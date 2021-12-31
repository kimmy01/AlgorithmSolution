package com.algo0223;

import java.io.*;
import java.util.*;
public class Main_BOJ_2331_반복수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(stk.nextToken()));
        int P = Integer.parseInt(stk.nextToken());
        int index = 0;
        while(true){
            int temp = list.get(index);
            int D = 0;
            while(temp > 9){
                D += Math.pow(temp%10, P);
                temp = temp/10;
            }
            D+=Math.pow(temp%10, P);
            if(list.contains(D)){
                int idx = list.indexOf(D);
                while(idx != list.size()-1){
                    list.remove(idx);
                }
                list.remove(idx);
                break;
            }else{
                list.add(D);
                index++;
            }
        }
        System.out.println(list.size());
    }
}
