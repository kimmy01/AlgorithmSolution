package com.algo12;

import java.util.*;
import java.io.*;

public class Main2056 {
    static int N;
    static int[] time, cost, count;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(count[i] == 0){ //제일 처음 실행되는 애
                queue.add(i);
                cost[i] = time[i];
            }
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0; i<list[now].size(); i++){
                int next = list[now].get(i); //나 다음에 실행할 애
                cost[next] = Math.max(cost[now]+time[next], cost[next]);
                count[next]--;
                if(count[next] == 0) queue.add(next);
            }
        }

        int result = 0;
        for(int i=1; i<=N; i++){
            result = Math.max(result, cost[i]);
        }
        System.out.println(result);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1]; //나보다 뒤에 실행되어야 하는 것 저장
        time = new int[N+1]; //실행하는데 걸리는 시간
        cost = new int[N+1];
        count = new int[N+1]; //선행실행 개수
        StringTokenizer st;
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            count[i] = Integer.parseInt(st.nextToken());
            for(int j=0; j<count[i]; j++){
                list[Integer.parseInt(st.nextToken())].add(i);
            }
        }
    }
}
