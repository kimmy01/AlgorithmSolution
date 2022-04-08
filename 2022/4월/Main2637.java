package com.algo2022_04;

import java.io.*;
import java.util.*;

public class Main2637 {
    static class Node{
        int n;
        int cnt;
        Node(int n, int cnt){
            this.n = n;
            this.cnt = cnt;
        }
    }
    static int N, M;
    static int[] arr, brr; //arr:기본부품찾기, brr:위상정렬
    static ArrayList<Node>[] nodeList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        nodeList = new ArrayList[N+1];
        arr = new int[N+1];
        brr = new int[N+1];
        for(int i=1; i<=N; i++){
            nodeList[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()); //중간부품
            int y = Integer.parseInt(st.nextToken()); //중간부품 or 기본부품
            int z = Integer.parseInt(st.nextToken()); //필요개수
            nodeList[x].add(new Node(y, z));
            arr[x]++; //여기서 증가하지 않으면 기본부품
            brr[y]++; //위상정렬 용 저장
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 1)); //완제품 번호부터 시작
        int[] crr = new int[N+1]; //필요한 부품 개수 저장
        crr[N] = 1; //N을 만들려면 N이 1개
        while(!queue.isEmpty()){
            Node now = queue.poll();
            for(int i=0; i<nodeList[now.n].size(); i++){ //현재 중간부품을 구성하는 부품 수만큼 탐색
                Node next = nodeList[now.n].get(i);
                crr[next.n] += crr[now.n]*next.cnt;
                brr[next.n]--;
                if(brr[next.n] == 0){ //0이 되면 이제 그 부품을 구성하는 다른 부품들 찾으러~
                    queue.add(new Node(next.n, crr[next.n]));
                }
            }
        }
        for(int i=1; i<=N; i++){
            if(arr[i] == 0){ //기본부품인것
                System.out.println(i+" "+crr[i]);
            }
        }
    }
}
