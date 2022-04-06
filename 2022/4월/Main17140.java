package com.algo2022_04;

import java.io.*;
import java.util.*;

public class Main17140 {
    static int r, c, k;
    static int max = 100;
    static int col = 3;
    static int row = 3;
    static int answer = 0;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;
        k = Integer.parseInt(st.nextToken());
        map = new int[max][max];
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func();
        System.out.println(answer);
    }
    static void func(){
        int time = 0;
        while(map[r][c] != k){ //해당 위치 값이 같아질 때까지
            if(row >= col){
                R();
            }else{
                C();
            }
            time++;
            if(time > 100)
                break;
        }
        if(time > 100) //100초 지나도 못찾으면
            answer = -1;
        else
            answer = time;
    }
    //행 정렬
    static void R(){
        int newCol = col;
        for(int i=0; i<row; i++){
            //등장횟수 저장
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for(int j=0; j<col; j++){
                if(map[i][j] == 0) continue;
                hashMap.put(map[i][j], hashMap.getOrDefault(map[i][j], 0)+1);
                map[i][j] = 0;
            }
            //등장횟수 기준 정렬
            List<Map.Entry<Integer, Integer>> entry = sort(hashMap);
            int colSize = 0;
            if(entry.size()*2 > 100)
                colSize = 100;
            else
                colSize = entry.size()*2;
            for(int j=0; j<colSize; j++){
                Map.Entry<Integer, Integer> v = entry.remove(0);
                map[i][j] = v.getKey();
                j++;
                map[i][j] = v.getValue();
            }
            //제일 긴 행의 길이
            newCol = Math.max(newCol, colSize);
        }
        //열 최대 길이
        col = Math.max(row, newCol);
    }
    //열 정렬
    static void C(){
        int newRow = row;
        for(int i=0; i<col; i++){
            //등장횟수 저장
            HashMap<Integer, Integer> hashMap = new HashMap();
            for(int j=0; j<row; j++){
                if(map[j][i] == 0) continue;
                hashMap.put(map[j][i], hashMap.getOrDefault(map[j][i], 0)+1);
                map[j][i] = 0;
            }
            //등장횟수 기준 정렬
            List<Map.Entry<Integer, Integer>> entry = sort(hashMap);
            int rowSize = 0;
            if(entry.size()*2 > 100)
                rowSize = 100;
            else
                rowSize = entry.size()*2;
            for(int j=0; j<rowSize; j++){
                Map.Entry<Integer, Integer> v = entry.remove(0);
                map[j][i] = v.getKey();
                j++;
                map[j][i] = v.getValue();
            }
            //제일 긴 열 길이
            newRow = Math.max(newRow, rowSize);
        }
        //행 최대 길이
        row = Math.max(row, newRow);
    }
    //등장 횟수 기준 정렬
    static List<Map.Entry<Integer, Integer>> sort(HashMap<Integer, Integer> hashmap){
        List<Map.Entry<Integer, Integer>> entry = new ArrayList<>(hashmap.entrySet());
        Collections.sort(entry, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue() == o2.getValue()) //등장 횟수 같을 때, 수의 크기로
                    return o1.getKey() - o2.getKey();
                return o1.getValue() - o2.getValue();
            }
        });
        return entry;
    }
}
