package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main10814 {
    static class Member implements Comparable<Member>{
        int idx;
        int age;
        String name;
        public Member(int idx, int age, String name){
            this.idx = idx;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member m) {
            if(this.age == m.age){
                return this.idx - m.idx;
            }
            return this.age - m.age;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Member> memberList = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            memberList.add(new Member(i, age, name));
        }
        Collections.sort(memberList);
        for(Member member : memberList){
            System.out.print(member.age + " ");
            System.out.println(member.name);
        }
    }
}
