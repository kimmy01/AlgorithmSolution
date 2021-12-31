package com.algo0416;
import java.util.*;
import java.io.*;
public class Main_BOJ_17471_게리맨더링 {
    static int N, min = 123456789;
    static int[] population;
    static ArrayList<Integer>[] list;
    static boolean[] selectedA;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N+1];
        list = new ArrayList[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            population[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
        }
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            for(int j=0; j<num; j++){
                int section = Integer.parseInt(st.nextToken());
                list[i].add(section);
            }
        }
        selectedA = new boolean[N+1];
        selectA(1);
        if(min == 123456789){
            min = -1;
        }
        System.out.println(min);
    }
    static void selectA(int index){
        if(index == N+1){
            if(BFS()){
                int sumA = 0;
                int sumB = 0;
                for(int i=1; i<=N; i++){
                    if(selectedA[i]) sumA += population[i];
                    else sumB += population[i];
                }
                min = Math.min(min, Math.abs(sumA-sumB));
            }
            return;
        }
        selectedA[index] = true;
        selectA(index+1);
        selectedA[index] = false;
        selectA(index+1);
    }
    static boolean BFS(){
        boolean[] visited = new boolean[N+1];
        int areaA = -1;
        for(int i=1; i<=N; i++){
            if(selectedA[i]){
                areaA = i;
                break;
            }
        }
        int areaB = -1;
        for(int i=1; i<=N; i++){
            if(!selectedA[i]){
                areaB = i;
                break;
            }
        }

        if(areaA == -1 || areaB == -1) return false;

        Queue<Integer> q = new LinkedList<>();
        q.add(areaA);
        visited[areaA] = true;
        while(!q.isEmpty()){
            int current = q.poll();
            for(int i=0; i<list[current].size(); i++){
                if(visited[list[current].get(i)]) continue;
                if(!selectedA[list[current].get(i)]) continue;
                visited[list[current].get(i)] = true;
                q.add(list[current].get(i));
            }
        }
        q.add(areaB);
        visited[areaB] = true;
        while(!q.isEmpty()){
            int current = q.poll();
            for(int i=0; i<list[current].size(); i++){
                if(visited[list[current].get(i)]) continue;
                if(selectedA[list[current].get(i)]) continue;
                visited[list[current].get(i)] = true;
                q.add(list[current].get(i));
            }
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}
