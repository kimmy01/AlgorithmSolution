package com.algo0608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    static int now, max, t;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] island;
    static int[][] population;
    static int[][] area;
    static int[] sumPopulation;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> nextAreaNum = new LinkedList<>();
    static Queue<boolean[]> visitedCheck = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        now = 4;
        max = 225;
        t = 1;
        input(); //지도들 입력받기
        setGraph(); //인접리스트

        int count = 0;//갈 수 있는 지역의 개수

        move();
        sumPop();
        for(int i=0; i<sumPopulation.length; i++){
            System.out.println(sumPopulation[i]);
        }

//        for(int j=1; j<=t; j++){
//            sumPop();//주인공 이동 전에 실행
//            ///주인공이동///
//            if(j == 1){
//                for(int i=0; i<graph.get(now).size(); i++){
//                    boolean[] visitedArea = new boolean[15];
//                    visitedArea[now] = true; //제일 첫 지역 방문
//                    int a = graph.get(now).get(i);
//                    if(sumPopulation[a] <= max){
//                        visitedArea[a] = true;
//                        nextAreaNum.add(a);
//                        visitedCheck.add(visitedArea);
//                        count++; //갈 수 있는 지역의 개수
//                    }
//                }
//            }else{
//                int tmp = 0;
//                for(int i=0; i<count; i++){
//                    int tmpNum = nextAreaNum.poll(); //주인공이 있는 위치
//                    boolean[] tmpVisited = Arrays.copyOf(visitedCheck.poll(), 15);
//
//                    for(int k=0; k<graph.get(tmpNum).size(); k++){
//                        int a = graph.get(tmpNum).get(k); //다음지역
//                        if(sumPopulation[a] <= max){ //다음지역 인구수
//                            tmpVisited[a] = true; //방문체크
//                            nextAreaNum.add(a);
//                            visitedCheck.add(tmpVisited);
//                            tmpVisited[a] = false;//방문해제
//                            tmp++;//이번턴에서 이동가능한 횟수
//                        }
//                    }
//                }
//                count = tmp;
//            }
//            System.out.println("카운트: "+count);
//            move();//인구이동
//        }
//        int maxArea = 0;
//        while(!nextAreaNum.isEmpty()){
//            int tmpCnt = 0;
//            nextAreaNum.poll();
//            boolean[] tmp = Arrays.copyOf(visitedCheck.poll(), 15);
//            for(int i=1; i<15; i++){
//                if(tmp[i]){
//                    tmpCnt++;
//                }
//            }
//            maxArea = Math.max(maxArea, tmpCnt);
//        }
//        System.out.println(maxArea);
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //섬데이터
        island = new int[13][15];
        for(int i=0; i<13; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<15; j++){
                island[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //인구데이터
        population = new int[13][15];
        for(int i=0; i<13; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<15; j++){
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //지역구분데이터
        area = new int[13][15];
        for(int i=0; i<13; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<15; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    static void sumPop(){
        sumPopulation = new int[15];
        for(int i=0; i<13; i++){
            for(int j=0; j<15; j++){
                int areaNum = area[i][j];
                if(areaNum > 0){
                    sumPopulation[areaNum] += population[i][j];
                }
            }
        }
    }
    static void setGraph(){
        boolean[][] visited = new boolean[15][15];
        //인접리스트 생성
        for(int i=0; i<=14; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<13; i++){
            for(int j=0; j<15; j++){
                if(area[i][j] > 0 && area[i][j] < 13){ //섬
                    for(int k=0; k<4; k++){ //사방탐색
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(inRange(nr, nc) && !visited[area[i][j]][area[nr][nc]] && area[i][j] != area[nr][nc] && area[nr][nc] > 0){
                            graph.get(area[i][j]).add(area[nr][nc]);
                            graph.get(area[nr][nc]).add(area[i][j]);
                            visited[area[i][j]][area[nr][nc]] = true;
                            visited[area[nr][nc]][area[i][j]] = true;
                        }
                    }
                }else if(area[i][j] == 13 && graph.get(13).isEmpty()){
                    graph.get(13).add(12);
                    graph.get(12).add(13);
                }else if(area[i][j] == 14){
                    graph.get(14).add(7);
                    graph.get(7).add(14);
                }
            }
        }
    }
    static void move(){
        int[][] newPopulation = new int[13][15];
        for(int i=0; i<13; i++){
            for(int j=0; j<15; j++){
                if(population[i][j] > 0 && island[i][j] < 9){ //선착장 아닌 곳
                    int minusPopulation = 0;
                    for(int k=0; k<4; k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(inRange(nr, nc) && island[nr][nc] > 0){
                            if(island[nr][nc] > island[i][j]){ //20%
                                newPopulation[nr][nc] += population[i][j]*0.2;
                                minusPopulation += population[i][j]*0.2;
                            }else{ //25%
                                newPopulation[nr][nc] += population[i][j]*0.25;
                                minusPopulation += population[i][j]*0.25;
                            }
                        }
                    }
                    population[i][j] -= minusPopulation;
                }else if(population[i][j] > 0 && island[i][j] == 9){ //선착장인 곳
                    int minusPopulation = 0;
                    for(int k=0; k<4; k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(inRange(nr, nc) && island[nr][nc] > 0){ //선착장인 곳 -> 선착장 아닌 곳
                            if(island[nr][nc] > island[i][j]){ //20%
                                newPopulation[nr][nc] += population[i][j]*0.2;
                                minusPopulation += population[i][j]*0.2;
                            }else{ //25%
                                newPopulation[nr][nc] += population[i][j]*0.25;
                                minusPopulation += population[i][j]*0.25;
                            }
                        }
                        nr = i + dr[k]*2;
                        nc = j + dc[k]*2;
                        if(inRange(nr, nc) && island[nr][nc] == 9){ //선착장인 곳 -> 선착장인 곳
                            if(island[nr][nc] > island[i][j]){ //20%
                                newPopulation[nr][nc] += population[i][j]*0.2;
                                minusPopulation += population[i][j]*0.2;
                            }else{ //25%
                                newPopulation[nr][nc] += population[i][j]*0.25;
                                minusPopulation += population[i][j]*0.25;
                            }
                        }
                    }
                    population[i][j] -= minusPopulation;
                }
            }
        }
        for(int i=0; i<13; i++){
            for(int j=0; j<15; j++){
                population[i][j] = population[i][j] + newPopulation[i][j];
            }
        }
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<13 && 0<=nc && nc<15) return true;
        return false;
    }
}
