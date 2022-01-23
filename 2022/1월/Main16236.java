package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main16236 {
    static int N, babySharkR, babySharkC, ateCount, babySharkSize, time;
    static int[][] space;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<int[]> fishList;
    static Stack<int[]> distanceStack;
    public static void main(String[] args) throws Exception {
        input();
        func();
        System.out.println(time);
    }
    static void func() {
        while(true){
            // 먹을 수 있는 물고기 구하기
            findFish();
            if(fishList.size() == 1){
                eatFish(fishList.get(0));
                continue;
            }else if(fishList.size() == 0){
                return;
            }
            // 먹을 수 있는 물고기 중 가까운 물고기 구하기
            distanceStack = new Stack<>();
            for(int[] fish : fishList){
                int distance = findNearestFish(fish[0], fish[1]);
                if(distanceStack.isEmpty()){
                    distanceStack.push(new int[]{fish[0], fish[1], distance});
                    continue;
                }
                if(distanceStack.peek()[2] > distance){
                    distanceStack.pop();
                }else if(distanceStack.peek()[2] < distance){
                    continue;
                }
                distanceStack.push(new int[]{fish[0], fish[1], distance});
            }
            // 가까운 물고기 중 가장 위, 왼쪽 물고기 구하기
            int[] destination = findDestination();
            // 물고기 먹기(상어 위치 변경, 먹은 물고기 수 증가, 상어 크기 증가)
            eatFish(destination);
        }
    }
    static void eatFish(int[] destination) {
        space[destination[0]][destination[1]] = 0;
        babySharkR = destination[0];
        babySharkC = destination[1];
        ateCount++;
        if(ateCount == babySharkSize){
            ateCount = 0;
            babySharkSize++;
        }
        time+=destination[2];
    }
    static int[] findDestination() {
        Stack<int[]> upperFishStack = new Stack<>();
        while(!distanceStack.isEmpty()){
            int[] fishInfo = distanceStack.pop();
            if(upperFishStack.size() == 0){
                upperFishStack.push(fishInfo);
                continue;
            }
            if(fishInfo[0] < upperFishStack.peek()[0]){
                upperFishStack.pop();
            }else if(fishInfo[0] > upperFishStack.peek()[0]){
                continue;
            }
            upperFishStack.push(fishInfo);
        }
        int[] destination = {100, 100, 100};
        while(!upperFishStack.isEmpty()){
            int[] fishInfo = upperFishStack.pop();
            if(destination[1] > fishInfo[1]){
                destination[0] = fishInfo[0];
                destination[1] = fishInfo[1];
                destination[2] = fishInfo[2];
            }
        }
        return destination;
    }
    static int findNearestFish(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{babySharkR, babySharkC, 0});
        boolean[][] visited = new boolean[N][N];
        int time = 0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(visited[now[0]][now[1]]) continue;
            visited[now[0]][now[1]] = true;
            if(now[0] == r && now[1] == c) {
                time = now[2];
                break;
            }
            for(int i=0; i<4; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                int nt = now[2] + 1;
                if(0<=nr && nr<N && 0<=nc && nc<N && !visited[nr][nc] && space[nr][nc] <= babySharkSize){
                    queue.add(new int[] {nr, nc, nt});
                }
            }
        }
        return time;
    }
    static void findFish() {
        fishList = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(space[i][j] < babySharkSize){
                    fishList.add(new int[]{i, j});
                }
            }
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        space = new int[N][N];
        babySharkSize = 2;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                space[i][j] = Integer.parseInt(st.nextToken());
                if(space[i][j] == 9){
                    babySharkR = i;
                    babySharkC = j;
                    space[i][j] = 0;
                }
            }
        }
    }
}
