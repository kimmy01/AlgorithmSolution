package com.algo12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main13904 {
    static class HW{
        int day;
        int score;
        public HW(int day, int score){
            this.day = day;
            this.score = score;
        }
    }
    static int N, answer;
    static PriorityQueue<HW> before, after;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    private static void func() {
        for(int i=0; i<N; i++){
            HW tmp = before.poll();
            if(after.size() < tmp.day){
                after.add(tmp);
                continue;
            }
            if(after.peek().score < tmp.score){
                after.poll();
                after.add(tmp);
            }
        }
        int s = after.size();
        for(int i=0; i<s; i++){
            int tmp = after.poll().score;
            answer += tmp;
        }
        System.out.println(answer);
    }
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        before = new PriorityQueue<>(new Comparator<HW>() {
            @Override
            public int compare(HW o1, HW o2) {
                return o1.day - o2.day;
            }
        });
        after = new PriorityQueue<>(new Comparator<HW>() {
            @Override
            public int compare(HW o1, HW o2) {
                return o1.score - o2.score;
            }
        });
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            HW hw = new HW(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            before.add(hw);
        }
    }
}
