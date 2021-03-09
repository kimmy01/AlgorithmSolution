package com.algo0309;
import java.util.*;
import java.io.*;
public class Main_BOJ_8972_미친아두이노 {
    static int jongsooR, jongsooC, R, C;
    static Queue<int[]> madAduino;
    //인덱스 1부터 탐색, 좌하, 하, 우하, 좌, 제자리, 우, 좌상, 상, 우상
    static int[] dr = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dc = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        madAduino = new LinkedList<>();
        jongsooR = 0;
        jongsooC = 0;

        for(int i=0; i<R; i++){
            String temp = br.readLine();
            for(int j=0; j<C; j++){
                char a = temp.charAt(j);
                if(a == 'R'){
                    madAduino.add(new int[]{i, j});
                }else if(a == 'I'){
                    jongsooR = i;
                    jongsooC = j;
                }
            }
        }//map 탐색 끝
        int flag = 0;
        String command = br.readLine();
        for(int i=0; i<command.length(); i++){
            int dir = command.charAt(i)-48;
            //종수움직임
            jongsooMove(dir);
            //미친아두이노랑 겹치면 종료하고 출력
            if(!checkMadAduino()){
                System.out.println("kraj "+(i+1));
                flag = 1;
                break;
            }
            //미친아두이노움직임
            madAduinoMove();
            //종수랑 겹치면 종료하고 출력
            if(!checkMadAduino()){
                System.out.println("kraj "+(i+1));
                flag = 1;
                break;
            }
            //미친아두이노끼리 겹치는 지 체크
            locCheck();
        }
        if(flag == 0){
            char[][] map = new char[R][C];
            map[jongsooR][jongsooC] = 'I';
            while(!madAduino.isEmpty()){
                int[] tmp = madAduino.poll();
                map[tmp[0]][tmp[1]] = 'R';
            }

            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j] != 'R' && map[i][j] != 'C'){
                        System.out.print('.');
                    }else{
                        System.out.print(map[i][j]);
                    }
                }
                System.out.println();
            }
        }

    }
    static void jongsooMove(int dir){
        jongsooR+=dr[dir];
        jongsooC+=dc[dir];
        return;
    }
    static boolean checkMadAduino(){
        for(int i=0; i<madAduino.size(); i++){
            int[] tempMad = madAduino.poll();
            int madR = tempMad[0];
            int madC = tempMad[1];
            if(jongsooR == madR && jongsooC == madC){
                return false;
            }
            madAduino.add(tempMad);
        }
        return true;
    }
    static void madAduinoMove(){
        for(int i=0; i<madAduino.size(); i++){
            int distance = Integer.MAX_VALUE;
            int[] tempMad = madAduino.poll();
            int madR = tempMad[0];
            int madC = tempMad[1];
            int tmpR = 0;
            int tmpC = 0;
            for(int j=1; j<=9; j++){
                int madNR = madR+dr[j];
                int madNC = madC+dc[j];
                if(0<=madNR && madNR<R && 0<=madNC && madNC<C){
                    int tmpdistance = Math.abs(jongsooR - madNR)+Math.abs(jongsooC - madNC);
                    if(distance > tmpdistance){
                        tmpR = madNR;
                        tmpC = madNC;
                    }
                }
            }
            madAduino.add(new int[] {tmpR, tmpC});
        }
    }
    static void locCheck(){
        int repeat = madAduino.size();
            for(int i=0; i<repeat; i++){
                int[] a = madAduino.poll();
                if(!madAduino.isEmpty()){
                    for(int j=0; i<repeat-1; j++) {
                        if (madAduino.contains(a)) {
                            for (int k = 0; k < repeat - 1; k++) {
                                int[] b = madAduino.poll();
                                if (b != a) {
                                    madAduino.add(b);
                                } else {
                                    repeat--;
                                }
                            }
                        } else {
                            madAduino.add(a);
                            continue;
                        }
                    }
                }else{
                    madAduino.add(a);
                }
        }
    }
}
