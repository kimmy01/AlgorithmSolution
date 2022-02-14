package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main1931 {
    static class Meeting {
        int start;
        int end;
        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    static int N;
    static ArrayList<Meeting> meetingList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        int count = 0;
        int endTime = 0;
        for(int i=0; i<N; i++){
            if(meetingList.get(i).start >= endTime){
                endTime = meetingList.get(i).end;
                count++;
            }
        }
        System.out.println(count);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            Meeting meeting = new Meeting(s, e);
            meetingList.add(meeting);
        }
        Collections.sort(meetingList, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.start - o2.start;
            }
        });
        Collections.sort(meetingList, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.end - o2.end;
            }
        });
    }
}
