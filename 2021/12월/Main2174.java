package com.algo12;

import java.io.*;
import java.util.*;

public class Main2174 {
    static class Robot{
        int x;
        int y;
        int d;
        public Robot(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static class Command{
        int robot;
        char command;
        int repeat;
        public Command(int robot, char command, int repeat){
            this.robot = robot;
            this.command = command;
            this.repeat = repeat;
        }
    }
    static int A, B, N, M;
    static int[][] map;
    static int[] num;
    static Robot[] robots;
    static Command[] commands;
    static int[] L = {3, 0, 1, 2};
    static int[] R = {1, 2, 3, 0};
    static int[][] F = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // N E S W
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[B+1][A+1];
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[B+1];
        robots = new Robot[N+1];
        commands = new Command[M];
        int tmp = B;
        for(int i=1; i<=B; i++){
            num[i] = tmp;
            tmp--;
        }
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = 0;
            char c = st.nextToken().charAt(0);
            if(c == 'N'){
                d = 0;
            }else if(c == 'E'){
                d = 1;
            }else if(c == 'S'){
                d = 2;
            }else{
                d = 3;
            }
            robots[i] = new Robot(x, num[y], d);
            map[num[y]][x] = i;
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int robot = Integer.parseInt(st.nextToken());
            char command = st.nextToken().charAt(0);
            int repeat = Integer.parseInt(st.nextToken());
            commands[i] = new Command(robot, command, repeat);
        }
    }
    static void func() {
        boolean flag = true;
        for(int i=0; i<M; i++){
            flag = move(robots[commands[i].robot], commands[i].command, commands[i].repeat, commands[i].robot);
            if(!flag) break;
        }
        if(flag){
            System.out.println("OK");
        }
    }
    static boolean move(Robot robot, char command, int repeat, int robotNum){
        if(command == 'L'){ //왼쪽 90도 회전
            for(int i=0; i<repeat; i++){
                robot.d = L[robot.d];
                robots[robotNum].d = robot.d;
            }
        }else if(command == 'R'){ //오른쪽 90도 회전
            for(int i=0; i<repeat; i++){
                robot.d = R[robot.d];
                robots[robotNum].d = robot.d;
            }
        }else if(command == 'F'){ //앞으로 한 칸
            for(int i=0; i<repeat; i++){
                int nx = robot.x + F[robot.d][1];
                int ny = robot.y + F[robot.d][0];
                if(inRange(ny, nx)){
                    if(map[ny][nx] == 0){
                        map[robot.y][robot.x] = 0;
                        map[ny][nx] = robotNum;
                        robot.x = nx;
                        robot.y = ny;
                        robots[robotNum].x = nx;
                        robots[robotNum].y = ny;
                    }else{
                        System.out.println("Robot " + robotNum + " crashes into robot " + map[ny][nx]);
                        return false;
                    }
                }else{
                    System.out.println("Robot " + robotNum + " crashes into the wall");
                    return false;
                }
            }
        }
        return true;
    }
    static boolean inRange(int ny, int nx){
        if(1<=ny && ny<=B && 1<=nx && nx<=A) return true;
        return false;
    }
}
