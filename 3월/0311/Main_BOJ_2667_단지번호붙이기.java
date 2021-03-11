package com.algo0311;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Main_BOJ_2667_단지번호붙이기 {
    static int N, count;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue, queue2;
    static ArrayList<Integer> house;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        queue = new LinkedList<>();
        queue2 = new LinkedList<>();
        house = new ArrayList<>();
        for(int i=0; i<N; i++){
            String a = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = a.charAt(j)-48;
                if(map[i][j] == 1){
                    queue.add(new int[]{i, j});
                }
            }
        }
        BFS();
        Collections.sort(house);
        System.out.println(house.size());
        for(int i=0; i<house.size(); i++){
            System.out.println(house.get(i)+1);
        }
    }

    static void BFS(){
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        while(!queue.isEmpty()) {
            queue2.add(queue.poll());
            if(visited[queue2.peek()[0]][queue2.peek()[1]] == false){
                count = 0;
                while (!queue2.isEmpty()) {
                    int[] cur = queue2.poll();
                    visited[cur[0]][cur[1]] = true;
                    for (int i = 0; i < 4; i++) {
                        if (0 <= cur[0] + di[i] && cur[0] + di[i] < N && 0 <= cur[1] + dj[i] && cur[1] + dj[i] < N
                                && !visited[cur[0] + di[i]][cur[1] + dj[i]] && map[cur[0] + di[i]][cur[1] + dj[i]] == 1) {
                            visited[cur[0] + di[i]][cur[1] + dj[i]] = true;
                            queue2.add(new int[]{cur[0] + di[i], cur[1] + dj[i]});
                            count++;
                        }
                    }
                }
                house.add(count);
            }else{
                queue2.poll();
            }
        }
    }
}