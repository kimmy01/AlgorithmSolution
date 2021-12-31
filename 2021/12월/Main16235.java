package com.algo12;

import java.util.*;
import java.io.*;

public class Main16235 {
    static class Tree implements Comparable<Tree>{
        int x, y, z;
        public Tree(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
        @Override
        public int compareTo(Tree o) {
            return this.z - o.z;
        }
    }
    static int N, M, K;
    static int[][] nourishment, garden;
    static Deque<Integer>[][] trees;
    static ArrayList<Tree> inputTrees;
    static ArrayList<Tree> deadTrees;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        for(int i=0; i<K; i++){
            spring();
            summer();
            autumn();
            winter();
        }
        int answer = count();
        System.out.println(answer);
    }
    static void spring() { //나무에 양분 주기
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(trees[i][j].isEmpty()) continue;
                int treeSize = trees[i][j].size();
                for(int k=0; k<treeSize; k++){
                    int tmp = trees[i][j].pollFirst();
                    if(garden[i][j] >= tmp){
                        garden[i][j] -= tmp;
                        trees[i][j].addLast(tmp+1);
                    }else{
                        deadTrees.add(new Tree(i, j, tmp));
                    }
                }
            }
        }
    }
    static void summer() { //죽은나무 => 양분
        for(int i=0; i<deadTrees.size(); i++){
            int x = deadTrees.get(i).x;
            int y = deadTrees.get(i).y;
            int z = deadTrees.get(i).z;
            garden[x][y] += z/2;
        }
        deadTrees.clear();
    }
    static void autumn() { //나무 번식
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(trees[i][j].isEmpty()) continue;
                int treeSize = trees[i][j].size();
                for(int k=0; k<treeSize; k++){
                    int tmp = trees[i][j].pollFirst();
                    if(tmp % 5 > 0){
                        trees[i][j].addLast(tmp);
                        continue;
                    }
                    for(int l=0; l<8; l++){
                        int nr = i+dr[l];
                        int nc = j+dc[l];
                        if(inRange(nr, nc)){
                            trees[nr][nc].addFirst(1);
                        }
                    }
                    trees[i][j].addLast(tmp);
                }
            }
        }
    }
    static void winter() { //양분 뿌리기
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                garden[i][j] += nourishment[i][j];
            }
        }
    }
    static int count() {
        int cnt = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                cnt += trees[i][j].size();
            }
        }
        return cnt;
    }
    static boolean inRange(int nr, int nc){
        if(0<nr && nr<=N && 0<nc && nc<=N) return true;
        return false;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nourishment = new int[N+1][N+1];
        garden = new int[N+1][N+1];
        trees = new Deque[N+1][N+1];
        deadTrees = new ArrayList<>();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                garden[i][j] = 5;
                trees[i][j] = new LinkedList<>();

            }
        } // 초기화
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=N; j++){
                nourishment[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 겨울에 추가할 양분 위치, 양
        inputTrees = new ArrayList<>();
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            inputTrees.add(new Tree(x, y, z));
        } // 나무 심는 곳
        Collections.sort(inputTrees);
        for(int i=0; i<M; i++){
            trees[inputTrees.get(i).x][inputTrees.get(i).y].add(inputTrees.get(i).z);
        }
    }
}
