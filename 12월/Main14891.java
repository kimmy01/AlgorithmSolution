package com.algo12;

import java.util.*;
import java.io.*;

public class Main14891 {
    static int N, answer;
    static int[][] rotation;
    static ArrayList<Integer>[] wheel;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    private static void func() {
        for(int i=0; i<rotation.length; i++){
            int num = rotation[i][0];
            int dir = rotation[i][1];

            boolean[] visited = new boolean[5];
            nextTurn(num, dir, visited);
        }
        for(int i=1; i<=4; i++){
            if(wheel[i].get(0) == 1){
                answer += Math.pow(2, i-1);
            }
        }
        System.out.println(answer);
    }
    private static void turnWheel(int num, int dir){
        if(dir == 1){ //시계방향
            int tmp = wheel[num].get(7);
            wheel[num].remove(7);
            wheel[num].add(0, tmp);
        }else{ //반시계방향
            int tmp = wheel[num].get(0);
            wheel[num].remove(0);
            wheel[num].add(tmp);
        }
    }
    private static void nextTurn(int num, int dir, boolean[] visited){
        int leftNum = num;
        int leftDir = dir;
        int rightNum = num;
        int rightDir = dir;
        int[] arr = new int[5];
        arr[num] = dir;
        while(leftNum - 1 > 0 && !visited[leftNum - 1]){
            visited[leftNum - 1] = true;
            if (wheel[leftNum].get(6) != wheel[leftNum - 1].get(2)) {
                leftNum--;
                leftDir *= -1;
                arr[leftNum] = leftDir;
            }
        }
        while(rightNum + 1 < 5 && !visited[rightNum + 1]){
            visited[rightNum + 1] = true;
            if (wheel[rightNum].get(2) != wheel[rightNum + 1].get(6)) {
                rightNum++;
                rightDir *= -1;
                arr[rightNum] = rightDir;
            }
        }
        for(int i=1; i<=4; i++){
            if(arr[i] != 0){
                turnWheel(i, arr[i]);
            }
        }
    }
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        wheel = new ArrayList[5];
        for(int i=0; i<5; i++){
            wheel[i] = new ArrayList<>();
        }
        for(int i=1; i<=4; i++){
            char[] tmp = br.readLine().toCharArray();
            for(int j=0; j<8; j++){
                wheel[i].add(tmp[j] - '0');
            }
        }
        N = Integer.parseInt(br.readLine());
        rotation = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            rotation[i][0] = Integer.parseInt(st.nextToken());
            rotation[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}
