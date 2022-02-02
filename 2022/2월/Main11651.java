package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main11651 {
    static class Position implements Comparable<Position>{
        int x;
        int y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position p) {
            if(this.y == p.y){
                return this.x - p.x;
            }
            return this.y - p.y;
        }
    }
    static int N;
    static ArrayList<Position> positions = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        input();
        print();
    }
    static void print() {
        for(Position p : positions){
            System.out.println(p.x + " " + p.y);
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            positions.add(new Position(x, y));
        }
        Collections.sort(positions);
    }
}
