package com.algo2022_01;

import java.util.*;
public class Solution_거리두기확인하기 {
    static class Person{
        int r;
        int c;
        public Person(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
    static int[] answer = new int[5];
    static ArrayList<Person> people = new ArrayList<>();
    static char[][] map = new char[5][5];
    public static void main(String[] args) {
        func();
    }
    static void func(){
        for(int i=0; i<5; i++){
            String[] tmp = places[i];
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    map[j][k] = tmp[j].charAt(k);
                    if(map[j][k] == 'P'){
                        people.add(new Person(j, k));
                    }
                }
            }
            //거리두기 확인 메소드 호출
            answer[i] = check();
            people.clear();
        }
        System.out.println(Arrays.toString(answer));
    }
    static int check(){
        for(int i=0; i<people.size(); i++){
            Person now = people.get(i);
            for(int j=i+1; j<people.size(); j++){
                int distance = calcManhattan(now, people.get(j));
                if(distance == 2){
                    if(!checkPartition(now, people.get(j)))
                        return 0;
                }else if(distance > 2){
                    continue;
                }else{
                    return 0;
                }
            }
        }
        return 1;
    }
    static boolean checkPartition(Person p1, Person p2){
        if(p1.r == p2.r && map[p1.r][(p1.c+p2.c)/2] == 'O'){
            return false;
        }else if(p1.c == p2.c && map[(p1.r+p2.r)/2][p1.c] == 'O'){
            return false;
        }else if(map[p1.r][p2.c] == 'O' || map[p2.r][p1.c] == 'O'){
            return false;
        }
        return true;
    }
    static int calcManhattan(Person p1, Person p2){
        return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
    }
}
