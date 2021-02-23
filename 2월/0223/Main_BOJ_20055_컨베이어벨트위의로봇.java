package com.algo0223;
import java.io.*;
import java.util.*;

class Robot{
    int A;
    boolean R;

    Robot(int A, boolean R){
        this.A = A;
        this.R = R;
    }
}

public class Main_BOJ_20055_컨베이어벨트위의로봇 {
    public static void main(String[] args) throws Exception {
        Queue<Robot> lowerbelt = new LinkedList<>();
        ArrayList<Robot> upperbeltList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stk.nextToken()); // 컨베이어벨트 길이
        int K = Integer.parseInt(stk.nextToken()); // 내구도 0인 칸이 K개 되면 종료
        stk = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<2*N; i++){
            int x = Integer.parseInt(stk.nextToken());
            upperbeltList.add(new Robot(x, false));
        }
        for(int i=0; i<N; i++){
            Robot temp = upperbeltList.get(upperbeltList.size()-1);
            upperbeltList.remove(upperbeltList.size()-1);
            lowerbelt.offer(temp);
        }//큐로 N개 옮기기

        int countRepeat = 1;
        while(true){
            if(upperbeltList.get(N-1).R == true){
                upperbeltList.get(N-1).R = false;
            } //내려주기

            Robot temp = upperbeltList.get(upperbeltList.size()-1);
            lowerbelt.offer(temp);
            upperbeltList.remove(upperbeltList.size()-1);
            Robot temp2 = lowerbelt.poll();
            upperbeltList.add(0, temp2);
            //한칸씩 벨트 이동

            if(upperbeltList.get(N-1).R == true){
                upperbeltList.get(N-1).R = false;
            } //내려주기

            for(int i=N-2; i>=0; i--){
                if(upperbeltList.get(i).R == true && upperbeltList.get(i+1).A > 0 && upperbeltList.get(i+1).R == false){
                    upperbeltList.get(i).R = false;
                    upperbeltList.get(i+1).A-=1;
                    upperbeltList.get(i+1).R = true;
                }
            } //로봇이동
            if(upperbeltList.get(0).R == false && upperbeltList.get(0).A > 0) {
                upperbeltList.get(0).R = true;
                upperbeltList.get(0).A -= 1;
            } //올라가는 칸 비었으면 올려주기
            int countZero = 0;
            for(int i=0; i<N; i++){
                if(upperbeltList.get(i).A == 0) {
                    countZero++;
                }
                Robot temp3 = lowerbelt.poll();
                if(temp3.A == 0) {
                    countZero++;
                }
                lowerbelt.offer(temp3);
            }
            if(countZero >= K) { //내구도 0인 칸이 K개 이상일 때 브레이크
                break;
            }else{
                countRepeat++; //K개 미만이면 반복
            }
        }
        System.out.println(countRepeat);
    }
}
