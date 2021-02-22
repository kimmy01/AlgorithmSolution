package com.algo0222;
import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main_BOJ_17299_오등큰수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> stack = new Stack<>();
        int[][] numbers = new int[N][3]; //0:인덱스 1:숫자 2:등장횟수
        int count = 0;
        for(int i=0; i<N; i++){
            stack.push(i);
            numbers[i][0] = i;
            numbers[i][1] = Integer.parseInt(stk.nextToken());
            for(int j=0; j<N; j++){
                if(numbers[j][1] == numbers[i][1]){
                    count = ++numbers[j][2];
                    break;
                }
            }
            for(int j=0; j<N; j++){
                if(numbers[j][1] == numbers[i][1]){
                    numbers[j][2] = count;
                }
            }
        }
        int[] NGF = new int[N];
        ArrayList<Integer> saved = new ArrayList<>();//스택에서 꺼내온 애 담기
        int index = 0; //while문 인덱스
        while(!stack.isEmpty()){
            int temp = stack.pop();
            if(saved!=null){
                for(int i=0; i<saved.size(); i++){
                    if(numbers[saved.get(i)][2] > numbers[temp][2]){
                        NGF[temp] = numbers[saved.get(i)][1];
                    }
                }
                if(NGF[temp]==0){
                    NGF[temp]=-1;
                }
            }
            saved.add(temp);
            index++;
        }
        for(int i=0; i<N; i++){
            sb.append(NGF[i]+" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}