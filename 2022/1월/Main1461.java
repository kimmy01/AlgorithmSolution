package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main1461 {
    static int N, M, answer;
    static ArrayList<Integer> minusList = new ArrayList<>();
    static ArrayList<Integer> plusList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        boolean lastPosition = true;
        if(minusList.size() > 0 && plusList.isEmpty()){
            lastPosition = false;
        }else if(minusList.isEmpty() && plusList.size() > 0){
            lastPosition = true;
        }else{
            lastPosition = check();
        }
        last(lastPosition);
        calc();
        System.out.println(answer);
    }
    static void last(boolean lastPosition) {
        int cnt = 0;
        if(lastPosition){
            answer += plusList.get(0);
            while(!plusList.isEmpty() && cnt < M){
                plusList.remove(0);
                cnt++;
            }
        }else{
            answer += Math.abs(minusList.get(0));
            while(!minusList.isEmpty() && cnt < M){
                minusList.remove(0);
                cnt++;
            }
        }
    }
    static void calc() {
        while(!plusList.isEmpty()){
            answer += plusList.get(0)*2;
            for(int i=0; i<M; i++){
                if(plusList.isEmpty()) break;
                plusList.remove(0);
            }
        }
        while(!minusList.isEmpty()){
            answer += Math.abs(minusList.get(0))*2;
            for(int i=0; i<M; i++){
                if(minusList.isEmpty()) break;
                minusList.remove(0);
            }
        }
    }
    static boolean check() {
        int minus = minusList.get(0);
        int plus = plusList.get(0);
        if(Math.abs(minus) > plus) return false;
        return true;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num < 0){
                minusList.add(num);
            }else{
                plusList.add(num);
            }
        }
        Collections.sort(minusList);
        Collections.sort(plusList, Collections.reverseOrder());
    }
}
