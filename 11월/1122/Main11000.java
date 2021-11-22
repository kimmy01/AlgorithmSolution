package com.algo11;

import java.util.*;
import java.io.*;

public class Main11000 {
    private static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    static int N;
    static PriorityQueue<Lecture> pq;
    static PriorityQueue<Integer> pq2;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    public static void func() {
        for(int i=0; i<N; i++) {
            Lecture lecture = pq.poll();
            if(pq2.isEmpty()){
               pq2.add(lecture.end);
               continue;
            }
            if(pq2.peek() <= lecture.start) {
                pq2.poll();
            }
            pq2.add(lecture.end);
        }
        System.out.println(pq2.size());
    }
    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        StringTokenizer st = null;
        pq = new PriorityQueue<>(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) { // 시작시간 작은 것부터, 시작시간 같으면 끝시간 작은 것부터
                if(o1.start > o2.start) {
                    return 1;
                }else if(o1.start == o2.start) {
                    if(o1.end > o2.end) {
                        return 1;
                    }
                }
                return -1;
            }
        });
        pq2 = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            pq.add(new Lecture(stoi(st.nextToken()), stoi(st.nextToken())));
        }
    }
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}