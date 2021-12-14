package com.algo12;

import java.util.*;
import java.io.*;

public class Main15591 {
    static class Question{
        int k, v;
        public Question(int k, int v){
            this.k = k;
            this.v = v;
        }
    }
    static int N, Q, tmp;
    static ArrayList<int[]>[] nodeList;
    static Question[] questionArr;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        for(int i=0; i<Q; i++){
            boolean[] visited = new boolean[N+1];
            visited[questionArr[i].v] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(questionArr[i].v);

            int answer = 0;
            while(!queue.isEmpty()){
                int now = queue.poll();
                for(int j=0; j<nodeList[now].size(); j++){
                    int q = nodeList[now].get(j)[0];
                    int r = nodeList[now].get(j)[1];
                    if(!visited[q] && r >= questionArr[i].k){
                        queue.add(q);
                        visited[q] = true;
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        nodeList = new ArrayList[N+1];
        questionArr = new Question[Q];
        for(int i=1; i<=N; i++){
            nodeList[i] = new ArrayList<>();
        }
        for(int i=1; i<=N-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            nodeList[p].add(new int[]{q, r});
            nodeList[q].add(new int[]{p, r});
        }
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine(), " ");
            questionArr[i] = new Question(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }
}
