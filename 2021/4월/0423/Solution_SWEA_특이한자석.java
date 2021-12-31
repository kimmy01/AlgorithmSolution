package com.algo0423;

import java.util.*;
import java.io.*;

public class Solution_SWEA_특이한자석 {
    static Deque<Integer> deque1 = new LinkedList<>();
    static Deque<Integer> deque2 = new LinkedList<>();
    static Deque<Integer> deque3 = new LinkedList<>();
    static Deque<Integer> deque4 = new LinkedList<>();

    static int[] deq1 = new int[8];
    static int[] deq2 = new int[8];
    static int[] deq3 = new int[8];
    static int[] deq4 = new int[8];

    static boolean[] checking;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine()); // 회전 횟수
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 8; j++) {
                int a = Integer.parseInt(st.nextToken());
                deq1[j] = a;
                deque1.addLast(a);
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 8; j++) {
                int a = Integer.parseInt(st.nextToken());
                deq2[j] = a;
                deque2.addLast(a);
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 8; j++) {
                int a = Integer.parseInt(st.nextToken());
                deq3[j] = a;
                deque3.addLast(a);
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 8; j++) {
                int a = Integer.parseInt(st.nextToken());
                deq4[j] = a;
                deque4.addLast(a);
            }
            for(int j=0; j<K; j++){
                checking = new boolean[3];
                check();
                st = new StringTokenizer(br.readLine(), " ");
                int num = Integer.parseInt(st.nextToken()); //바퀴 번호
                int dir = Integer.parseInt(st.nextToken()); //1: 시계방향 2: 반시계방향
                int[] direction = new int[4];
                direction[num-1] = dir;
                for(int i=num-1; i>0; i--){
                    direction[i-1] = -direction[i];
                }
                for(int i=0; i<4; i++){
                    if(direction[i] == 0){
                        direction[i] = -direction[i-1];
                    }
                } // 회전 방향 표시
                func(num, dir);
                boolean[] turned = new boolean[4];
                turned[num-1] = true;

                if(!turned[0] && turned[1] && checking[0]){
                    func(1, direction[0]);
                    turned[0] = true;
                }
                if(!turned[1] && turned[0] && checking[0]){
                    func(2, direction[1]);
                    turned[1] = true;
                }
                if(!turned[1] && turned[2] && checking[1]){
                    func(2, direction[1]);
                    turned[1] = true;
                }
                if(!turned[2] && turned[1] && checking[1]){
                    func(3, direction[2]);
                    turned[2] = true;
                }
                if(!turned[2] && turned[3] && checking[2]){
                    func(3, direction[2]);
                    turned[2] = true;
                }
                if(!turned[3] && turned[2] && checking[2]){
                    func(4, direction[3]);
                    turned[3] = true;
                }

                copy(deq1, deque1);
                copy(deq2, deque2);
                copy(deq3, deque3);
                copy(deq4, deque4);
            }

            int answer = 0;
            if(deq1[0] == 1) answer+=1;
            if(deq2[0] == 1) answer+=2;
            if(deq3[0] == 1) answer+=4;
            if(deq4[0] == 1) answer+=8;

            System.out.println("#"+t+" "+answer);
        }
    }
    static void func(int num, int dir){
        if(num == 1){
            if(dir == 1){
                int tmp = deque1.pollLast();
                deque1.addFirst(tmp);
            }else{
                int tmp = deque1.pollFirst();
                deque1.addLast(tmp);
            }
        }else if(num == 2){
            if(dir == 1){
                int tmp = deque2.pollLast();
                deque2.addFirst(tmp);
            }else{
                int tmp = deque2.pollFirst();
                deque2.addLast(tmp);
            }
        }else if(num == 3){
            if(dir == 1){
                int tmp = deque3.pollLast();
                deque3.addFirst(tmp);
            }else{
                int tmp = deque3.pollFirst();
                deque3.addLast(tmp);
            }
        }else if(num == 4){
            if(dir == 1){
                int tmp = deque4.pollLast();
                deque4.addFirst(tmp);
            }else{
                int tmp = deque4.pollFirst();
                deque4.addLast(tmp);
            }
        }
    }
    static void check(){
        if(deq1[2] == deq2[6]){
            checking[0] = false;
        }else if(deq1[2] != deq2[6]){
            checking[0] = true; //true면 회전
        }
        if(deq2[2] == deq3[6]){
            checking[1] = false;
        }else if(deq2[2] != deq3[6]){
            checking[1] = true;
        }
        if(deq3[2] == deq4[6]){
            checking[2] = false;
        }else if(deq3[2] != deq4[6]){
            checking[2] = true;
        }
    }
    static void copy(int[] arr, Deque<Integer> deq){
        for(int i=0; i<8; i++){
            int tmp = deq.pollFirst();
            arr[i] = tmp;
            deq.addLast(tmp);
        }
    }
}
