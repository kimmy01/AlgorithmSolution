package com.algo0216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 1) 이닝 별 선수의 결과 저장하는 배열 생성
 * 2) 크기 9의 선수 순서 담는 배열 생성
 * 3) 큐에 선수 순서 배열 대로 {선수 번호, 1이닝 결과} 넣기
 * 4) queue.peek() 해서 이닝 결과 확인, 점수 체크 & 0 횟수 3번 되면 nextStart에 선수 번호 넣고 queue 비우기
 * 5) 이닝 끝나지 않았다면 queue.add(queue.poll())
 * 6) 이닝 끝나면 이닝++, 다음 이닝 시작, nextStart선수 번호부터~기존 순서대로 넣기
 *
 * 야구경기 진행(점수 계산)
 * int[] base = new int[4]; 배열 생성 (0-홈, 1-1루, 2-2루, 3-3루)
 * ex) 1 2 3 4 결과의 선수들이 들어온다
 * 1 -> base[4]!=0 이면 점수+1, base[4]=0
 *      base[3]!=0 이면 base[4]=base[3]
 *      base[2]!=0 이면 base[3]=base[2]
 *      base[1]!=0 이면 base[2]=base[1]
 * 2 -> base[4]!=0 이면 점수+1, base[4]=0
 *      base[3]!=0 이면 점수+1, base[3]=0
 *      base[2]!=0 이면 base[4]=base[2]
 *      base[1]!=0 이면 base[3]=base[1]
 * 3 -> base[4]!=0 이면 점수+1, base[4]=0
 *      base[3]!=0 이면 점수+1, base[3]=0
 *      base[2]!=0 이면 점수+1, base[2]=0
 *      base[1]!=0 이면 base[4]=base[1]
 * 4 -> base[4]!=0 이면 점수+1, base[4]=0
 *      base[3]!=0 이면 점수+1, base[3]=0
 *      base[2]!=0 이면 점수+1, base[2]=0
 *      base[1]!=0 이면 점수+1, base[1]=0
 * */

public class Main_BOJ_17281_야구 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] result = new int[N][9];
        int score = 0;
        StringTokenizer stk;
        for(int i=0; i<N; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<9; j++){
                result[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
    }
}