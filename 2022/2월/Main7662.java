package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main7662 {
    static int T, K;
    static PriorityQueue<Integer> minPQ;
    static PriorityQueue<Integer> maxPQ;
    static HashMap<Integer, Integer> hashMap;
    public static void main(String[] args) throws Exception {
        input();
    }
    static int remove(PriorityQueue<Integer> pq) {
        int num = 0;
        while(true){
            num = pq.poll();
            int cnt = hashMap.getOrDefault(num, 0);
            if(cnt == 0) continue;
            if(cnt == 1) hashMap.remove(num);
            else hashMap.put(num, cnt-1);
            break;
        }
        return num;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            minPQ = new PriorityQueue<>();
            maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
            hashMap = new HashMap<>();
            K = Integer.parseInt(br.readLine());
            for(int k=0; k<K; k++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(command.equals("I")){
                    hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
                    minPQ.add(num);
                    maxPQ.add(num);
                }else{
                    int dir = num;
                    if(hashMap.size() == 0) continue;
                    if(dir == 1){
                        remove(maxPQ);
                    }else{
                        remove(minPQ);
                    }
                }
            }
            if(hashMap.size() == 0) System.out.println("EMPTY");
            else {
                int n = remove(maxPQ);
                int m = n;
                if(hashMap.size() > 0){
                    m = remove(minPQ);
                }
                System.out.println(n + " " + m);
            }
        }
    }
}
