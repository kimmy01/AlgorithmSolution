package com.algo12;

import java.io.*;

public class Main2002 {
    static int N, cnt;
    static String[] DK;
    static String[] YS;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    private static void func() {
        for(int i=0; i<N; i++){
            String car = DK[i]; //a b / b a
            for(int j=0; j<N; j++){
                if(YS[j].equals(car)){ //차 번호 같으면 방문체크 후 break
                    visited[j] = true;
                    break;
                }
                if(visited[j]) continue; //차 번호 다른데 이미 방문했으면 continue
                cnt++;
                visited[j] = true; //차 번호 다르고 방문 안했으면 추가 후 방문체크
            }
        }
        System.out.println(cnt);
    }
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = 0;
        N = Integer.parseInt(br.readLine());
        DK = new String[N];
        YS = new String[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            DK[i] = br.readLine();
        }
        for(int i=0; i<N; i++){
            YS[i] = br.readLine();
        }
    }
}
