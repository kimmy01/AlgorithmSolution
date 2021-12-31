package com.algo12;

import java.util.*;
import java.io.*;

public class Main13335 {
    static int n, w, L, answer;
    static Queue<Integer> truck;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        answer = 0;
        int time = 0;
        ArrayList<int[]> list = new ArrayList<>();
        while(!truck.isEmpty()){
            time++;
            while(!list.isEmpty()){
                if(time - list.get(0)[1] == w){
                    list.remove(0);
                }else{
                    break;
                }
            }
            int weight = 0;
            for(int i=0; i<list.size(); i++){
                weight += list.get(i)[0];
            }
            if(weight+truck.peek() > L) continue;
            list.add(new int[]{truck.poll(), time});
        }
        time += w - (time - list.get(list.size()-1)[1]);
        answer = time;
        System.out.println(time);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        truck = new LinkedList<>();
        for(int i=0; i<n; i++){
            truck.add(Integer.parseInt(st.nextToken()));
        }
    }
}
