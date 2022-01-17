package com.algo2022_01;

import java.util.HashSet;

public class NTS_LiveCoding2 {
    public static void main(String[] args) {
        solution("3");
    }
    public static void solution(String count){
        int limit = Integer.parseInt(count);
        int average = 0;
        HashSet<Integer> employeeSet = new HashSet<>();
        for(int i=0; i<limit; i++){
            StringBuilder sb = new StringBuilder();
            sb.append("NT");
            double random;
            int randomEmployee;

            while(true){
                random = Math.random();
                randomEmployee = (int)(random*100000);
                if(!employeeSet.contains(randomEmployee)) break;
            }
            employeeSet.add(randomEmployee); // 중복체크

            if(randomEmployee <= 99999){
                String tmp = String.valueOf(randomEmployee);
                int zeroCount = 5 - tmp.length();
                for(int j=0; j<zeroCount; j++){
                    sb.append(0);
                }
                sb.append(tmp+ " ");
            }else{
                sb.append(randomEmployee+ " ");
            } // 사원번호

            random = Math.random();
            int randomScore = (int)(random*100);
            average += randomScore;
            sb.append(randomScore);
            System.out.println(sb.toString());
        }
        double answer = average/limit;
        System.out.println("생성된 점수의 평균은 "+ answer + "점입니다.");
    }
}
