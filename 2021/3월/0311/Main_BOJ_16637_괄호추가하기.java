package com.algo0311;
import java.util.*;
import java.io.*;
public class Main_BOJ_16637_괄호추가하기 {
    static int N;
    static int[] numbers;
    static char[] operators;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //연산자 우선순위 모두 동일 -> 왼쪽에서부터 순서대로 계산
        //3+8x7-9x2 = 3+8 = 11x7 = 77 77-9 = 68x2 = 136
        //괄호 안에 있는 식은 먼저 계산, 괄호 내에는 연산자 하나 있어야 함. 중첩 괄호x
        //괄호를 적절히 추가하여 만들 수 있는 식의 결과의 최댓값 구하기
        N = Integer.parseInt(br.readLine());
        numbers = new int[(N/2)+1];
        operators = new char[N/2];
        String a = br.readLine();
        answer = Integer.MIN_VALUE;
        int nIdx = 0;
        int oIdx = 0;
        for(int i=0; i<N; i++){
            char tmp = a.charAt(i);
            if(48<=tmp && tmp<=57){
                numbers[nIdx] = tmp-48;
                nIdx++;
            }else{
                operators[oIdx] = tmp;
                oIdx++;
            }
        }
        DFS(numbers[0], 0);
        System.out.println(answer);
    }

    static void DFS(int result, int opIdx){
        if(opIdx >= operators.length){
            answer = Math.max(answer, result);
            return;
        }
        //괄호 없는 계산
        int result1 = calc(operators[opIdx], result, numbers[opIdx+1]);
        DFS(result1, opIdx+1);
        //괄호 있는 계산
        if(opIdx+1 < operators.length){
            int result2 = calc(operators[opIdx+1], numbers[opIdx+1], numbers[opIdx+2]);
            DFS(calc(operators[opIdx], result, result2), opIdx+2);
        }
    }
    static int calc(char ops, int num1, int num2){
        if(ops == '+'){
            return num1+num2;
        }else if(ops == '-'){
            return num1-num2;
        }else if(ops == '*'){
            return  num1*num2;
        }
        return -1;
    }
}