package com.algo12;

import java.io.*;
import java.util.*;

public class Main1781 {
    static class Problem{
        int time;
        int cup;
        public Problem(int time, int cup){
            this.time = time;
            this.cup = cup;
        }
    }
    static int N, answer;
    static PriorityQueue<Problem> before, after;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        for(int i=0; i<N; i++){
            Problem problem = before.poll();
            if(after.size() < problem.time){
                after.add(problem);
                continue;
            }
            if(after.peek().cup < problem.cup){
                after.poll();
                after.add(problem);
            }
        }
        while(!after.isEmpty()){
            answer += after.poll().cup;
        }
        System.out.println(answer);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        before = new PriorityQueue<>(new Comparator<Problem>() {
            @Override
            public int compare(Problem o1, Problem o2) {
                return o1.time - o2.time;
            }
        });
        after = new PriorityQueue<>(new Comparator<Problem>() {
            @Override
            public int compare(Problem o1, Problem o2) {
                return o1.cup - o2.cup;
            }
        });
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            Problem problem = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            before.add(problem);
        }
    }
}
