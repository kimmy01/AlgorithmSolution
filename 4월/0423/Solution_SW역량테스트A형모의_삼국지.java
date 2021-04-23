package com.algo0423;
import java.util.*;
import java.io.*;
public class Solution_SW역량테스트A형모의_삼국지 {
    static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] nations;
    static int[][] soldiers;
    static int[][] plusSoldiers;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
        for(int t=1; t<=T; t++){
            N = stoi(br.readLine());
            nations = new int[N][N];
            soldiers = new int[N][N];
            plusSoldiers = new int[N][N];
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<N; j++){
                    nations[i][j] = stoi(st.nextToken());
                }
            }
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<N; j++){
                    soldiers[i][j] = stoi(st.nextToken());
                }
            }
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<N; j++){
                    plusSoldiers[i][j] = stoi(st.nextToken());
                }
            }

            while(true){
                if(check()) break;
                for(int i=1; i<=3; i++){
                    if(!checkNation(i)) continue;
//                    System.out.println("#"+i+"번 국가");
                    attack(i);
//                    print(soldiers);
                    support(i);
//                    print(soldiers);
                    plus();
//                    print(soldiers);
//                    print(nations);
                }
            }
            int answer = calc();
            System.out.println("#"+t+" "+answer);
        }
    }
    static void attack(int num){
        int[][] attackCount= new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int hap = 0;
                if(nations[i][j] != num && nations[i][j] != 0){
                    for(int k=0; k<4; k++){
                        int nr = i+dr[k];
                        int nc = j+dc[k];
                        if(inRange(nr, nc) && nations[nr][nc]==num){
                            hap+=soldiers[nr][nc];
                        }
                    }
                    if(hap > soldiers[i][j]*5){
                        int tmp = 0;
                        for(int k=0; k<4; k++){
                            int nr = i+dr[k];
                            int nc = j+dc[k];
                            if(inRange(nr, nc) && nations[nr][nc]==num){
                                tmp += soldiers[nr][nc]/4;
                                attackCount[nr][nc]++;
                            }
                        }
                        soldiers[i][j] = tmp - soldiers[i][j];
                        attackCount[i][j] = -1;
                    }
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(attackCount[i][j] > 0){
                    soldiers[i][j] -= (soldiers[i][j]/4)*attackCount[i][j];
                }
                if(attackCount[i][j] == -1){
                    nations[i][j] = num;
                }
            }
        }
    }
    static void support(int num){
        int[][] supported = new int[N][N];
        int[][] supporting = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(nations[i][j] == num){
                    int flag = 0;
                    for(int k=0; k<4; k++){
                        int nr = i+dr[k];
                        int nc = j+dc[k];
                        if(inRange(nr, nc) && nations[nr][nc] != num){
                            if(nations[nr][nc] == 0) continue;
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 1){
                        for(int k=0; k<4; k++){
                            int nr = i+dr[k];
                            int nc = j+dc[k];
                            if(inRange(nr, nc) && nations[nr][nc] == num && soldiers[i][j] > soldiers[nr][nc]*5){
                                supporting[i][j]++;
                                supported[nr][nc] += soldiers[i][j]/5;
                            }
                        }
                    }else{
                        for(int k=0; k<4; k++){
                            int nr = i+dr[k];
                            int nc = j+dc[k];
                            if(inRange(nr, nc) && nations[nr][nc] == num){
                                supporting[i][j]++;
                                supported[nr][nc] += soldiers[i][j]/5;
                            }
                        }
                    }
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(supporting[i][j] > 0){ //지원 해줬으면
                    soldiers[i][j] -= (soldiers[i][j]/5)*supporting[i][j];
                }
                if(supported[i][j] > 0){ //지원 받았으면
                    soldiers[i][j] += supported[i][j];
                }
            }
        }
    }
    static void plus(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(nations[i][j] != 0){
                    soldiers[i][j] += plusSoldiers[i][j];
                }
            }
        }
    }
    static boolean check(){
        int index = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(index == 0){
                    if(nations[i][j] != 0){
                        index = nations[i][j];
                    }
                    continue;
                }
                if(nations[i][j] != 0 && index != nations[i][j]) return false;
            }
        }
        return true;
    }
    static boolean checkNation(int num){
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(nations[i][j] == num) cnt++;
            }
        }
        if(cnt > 0) return true;
        return false;
    }
    static int calc(){
        int sum = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sum += soldiers[i][j];
            }
        }
        return sum;
    }
    static void print(int[][] map){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<N && 0<=nc && nc<N) return true;
        return false;
    }
    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
