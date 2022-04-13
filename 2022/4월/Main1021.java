package com.algo2022_04;

import java.io.*;
import java.util.*;

public class Main1021 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> deque = new LinkedList<>();
        int count = 0;
        for(int i=1; i<=N; i++){
            deque.add(i);
        }
        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<M; i++){
            int target = deque.indexOf(arr[i]);
            int half;
            if(deque.size() % 2 == 0){
                half = deque.size() / 2 - 1;
            }else{
                half = deque.size() / 2;
            }
            if(target <= half){
                for(int j=0; j<target; j++){
                    int tmp = deque.pollFirst();
                    deque.addLast(tmp);
                    count++;
                }
            }else{
                for(int j=0; j<deque.size() - target; j++){
                    int tmp = deque.pollLast();
                    deque.addFirst(tmp);
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}
