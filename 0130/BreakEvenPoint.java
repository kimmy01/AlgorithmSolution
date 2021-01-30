package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BreakEvenPoint {
    public static void main(String[] args) throws IOException {
        /*임대료 재산세 보험료 급여 등 고정비용 A만원
        * 한 대 만들 때 재료비 인건비 등 가변비용 B만원
        * A=1000 B=70 1대 -> 1070, 10대 -> 1700
        * C만원으로 고정된 가격
        * 생산대수 늘려가다보면 어느 순간 판매비용이 총비용보다 많아진다
        * 최초로 총 비용보다 많아져서 이익이 발생하는 지점 - 손익분기점
        * A, B, C 주어졌을 때 손익분기점 구하는 프로그램
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer stk = new StringTokenizer(str);
        int A = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());

        if(B>=C){
            System.out.println(-1);
        }else{
            long i = 1;
            while(true) {
                if (A + B * i < C * i) {
                    System.out.println(i);
                    break;
                } else {
                    i += 1;
                }
            }
        }
    }
}
