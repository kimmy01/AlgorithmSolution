package com.algo2022_03;

import java.util.*;
import java.io.*;

public class Main24336 {
    static class Time{
        int arriveHour;
        int arriveMinute;
        int startHour;
        int startMinute;
        Time(int arriveHour, int arriveMinute, int startHour, int startMinute){
            this.arriveHour = arriveHour;
            this.arriveMinute = arriveMinute;
            this.startHour = startHour;
            this.startMinute = startMinute;
        }
    }
    static HashMap<String, Double> distanceMap = new HashMap<>();
    static HashMap<String, Time> stationMap = new HashMap<>();
    static int N, Q;
    public static void main(String[] args) throws Exception {
        input();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        int lastTime = 0;
        boolean changed = false;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            if(i == 0){
                st.nextToken();
                String start = st.nextToken();
                int startHour = Integer.parseInt(start.split(":")[0]);
                int startMinute = Integer.parseInt(start.split(":")[1]);
                lastTime = startHour;
                stationMap.put(name, new Time(-1, -1, startHour, startMinute));
                continue;
            }else if(i == N-1){
                String arrive = st.nextToken();
                int arriveHour = Integer.parseInt(arrive.split(":")[0]);
                int arriveMinute = Integer.parseInt(arrive.split(":")[1]);
                if(changed || lastTime > arriveHour){
                    arriveHour += 24;
                    changed = true;
                    lastTime = arriveHour;
                }
                stationMap.put(name, new Time(arriveHour, arriveMinute, -1, -1));
                continue;
            }
            String arrive = st.nextToken();
            String start = st.nextToken();
            int arriveHour = Integer.parseInt(arrive.split(":")[0]);
            int arriveMinute = Integer.parseInt(arrive.split(":")[1]);
            int startHour = Integer.parseInt(start.split(":")[0]);
            int startMinute = Integer.parseInt(start.split(":")[1]);
            if(changed || lastTime > arriveHour){
                arriveHour += 24;
                changed = true;
                lastTime = arriveHour;
            }
            if(changed || lastTime > startHour){
                startHour += 24;
                changed = true;
                lastTime = startHour;
            }
            stationMap.put(name, new Time(arriveHour, arriveMinute, startHour, startMinute));
        }

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String station1 = st.nextToken();
            String station2 = st.nextToken();
            Double station1_pos = distanceMap.get(station1);
            Double station2_pos = distanceMap.get(station2);
            Double distance = Math.abs(station1_pos - station2_pos);

            int station1_startHour = stationMap.get(station1).startHour;
            int station1_startMinute = stationMap.get(station1).startMinute;
            int station2_arriveHour = stationMap.get(station2).arriveHour;
            int station2_arriveMinute = stationMap.get(station2).arriveMinute;

            int hour = station2_arriveHour - station1_startHour;
            int minute = 0;
            if(hour == 0){
                minute = station2_arriveMinute - station1_startMinute;
            }else{
                hour--;
                minute = station2_arriveMinute + (60 - station1_startMinute);
            }

            double time = hour + (double)minute / 60.0;
            System.out.println(distance/time);

        }

    }
    static void input(){
        distanceMap.put("Seoul", 0.0);
        distanceMap.put("Yeongdeungpo", 9.1);
        distanceMap.put("Anyang", 23.9);
        distanceMap.put("Suwon", 41.5);
        distanceMap.put("Osan", 56.5);
        distanceMap.put("Seojeongri", 66.5);
        distanceMap.put("Pyeongtaek", 75.0);
        distanceMap.put("Seonghwan", 84.4);
        distanceMap.put("Cheonan", 96.6);
        distanceMap.put("Sojeongni", 107.4);
        distanceMap.put("Jeonui", 114.9);
        distanceMap.put("Jochiwon", 129.3);
        distanceMap.put("Bugang", 139.8);
        distanceMap.put("Sintanjin", 151.9);
        distanceMap.put("Daejeon", 166.3);
        distanceMap.put("Okcheon", 182.5);
        distanceMap.put("Iwon", 190.8);
        distanceMap.put("Jitan", 196.4);
        distanceMap.put("Simcheon", 200.8);
        distanceMap.put("Gakgye", 204.6);
        distanceMap.put("Yeongdong", 211.6);
        distanceMap.put("Hwanggan", 226.2);
        distanceMap.put("Chupungnyeong", 234.7);
        distanceMap.put("Gimcheon", 253.8);
        distanceMap.put("Gumi", 276.7);
        distanceMap.put("Sagok", 281.3);
        distanceMap.put("Yangmok", 289.5);
        distanceMap.put("Waegwan", 296.0);
        distanceMap.put("Sindong", 305.9);
        distanceMap.put("Daegu", 323.1);
        distanceMap.put("Dongdaegu", 326.3);
        distanceMap.put("Gyeongsan", 338.6);
        distanceMap.put("Namseonghyeon", 353.1);
        distanceMap.put("Cheongdo", 361.8);
        distanceMap.put("Sangdong", 372.2);
        distanceMap.put("Miryang", 381.6);
        distanceMap.put("Samnangjin", 394.1);
        distanceMap.put("Wondong", 403.2);
        distanceMap.put("Mulgeum", 412.4);
        distanceMap.put("Hwamyeong", 421.8);
        distanceMap.put("Gupo", 425.2);
        distanceMap.put("Sasang", 430.3);
        distanceMap.put("Busan", 441.7);
    }
}
