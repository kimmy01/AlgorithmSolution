package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main23294 {
    static int N, Q, C, now, cache;
    static int[] webPages;
    static Deque<Integer> back = new LinkedList<>();
    static Deque<Integer> front = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        input();
    }
    static void goBack() {
        if(back.isEmpty()) return;
        if(now != 0){
            front.addLast(now);
            now = back.pollLast();
        }
    }
    static void goFront() {
        if(front.isEmpty()) return;
        if(now != 0){
            back.addLast(now);
            now = front.pollLast();
        }
    }
    static void enterWebpage(int pageNum) {
        while(!front.isEmpty()){
            cache -= webPages[front.pollFirst()];
        }
        if(now != 0){
            back.addLast(now);
        }
        now = pageNum;
        cache += webPages[now];
        while(cache > C){
            cache -= webPages[back.pollFirst()];
        }
    }
    static void compress() {
        Deque<Integer> tmpDeque = new LinkedList<>();
        int backSize = back.size();
        for(int i=0; i<backSize; i++){
            if(tmpDeque.isEmpty()){
                tmpDeque.add(back.pollFirst());
               continue;
            }
            int nextPage = back.pollFirst();
            if(tmpDeque.peekLast() == nextPage){
                cache -= webPages[nextPage];
                continue;
            }
            tmpDeque.addLast(nextPage);
        }
        while(!tmpDeque.isEmpty()){
            back.addLast(tmpDeque.pollFirst());
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        webPages = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            webPages[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<Q; i++){
            String command = br.readLine();
            char first = command.charAt(0);
            if(first == 'B'){
                goBack();
            }else if(first == 'A'){
                st = new StringTokenizer(command, " ");
                st.nextToken();
                enterWebpage(Integer.parseInt(st.nextToken()));
            }else if(first == 'C'){
                compress();
            }else if(first == 'F'){
                goFront();
            }
        }
        System.out.println(now);
        StringBuilder sb = new StringBuilder();
        if(back.isEmpty()){
            System.out.println(-1);
        }else{
            while(!back.isEmpty()){
                sb.append(back.pollLast()+ " ");
            }
            System.out.println(sb.toString());
        }
        sb = new StringBuilder();
        if(front.isEmpty()){
            System.out.println(-1);
        }else{
            while(!front.isEmpty()){
                sb.append(front.pollLast()+ " ");
            }
            System.out.println(sb.toString());
        }
    }
}
