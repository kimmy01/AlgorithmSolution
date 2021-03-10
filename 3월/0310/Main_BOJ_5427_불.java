package com.algo0310;
import java.util.*;
import java.io.*;
public class Main_BOJ_5427_불 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            char[][] map = new char[w][h];
            boolean[][] visited = new boolean[w][h];
            Deque<int[]> fire = new LinkedList<>();
            int sanggeunR = 0;
            int sanggeunC = 0;

            for(int i=0; i<w; i++){
                String a = br.readLine();
                for(int j=0; j<h; j++){
                    map[i][j] = a.charAt(j);
                    if(map[i][j] == '@'){
                        sanggeunR = i;
                        sanggeunC = j;
                        visited[i][j] = true;
                    }else if(map[i][j] == '*'){
                        fire.add(new int[] {i, j});
                    }
                }
            }
            //상하좌우
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            int count = 0;
            int flag = 0;

            while(true){
                int find = 0;
                for(int i=0; i<4; i++){
                    //밖으로 탈출 가능할때
                    if(sanggeunR+dr[i] < 0 || sanggeunR+dr[i] >= w || sanggeunC+dc[i] < 0 || sanggeunC+dc[i] >= h){
                        System.out.println(count+1);
                        break;
                    }else{
                        //이동 가능할 때
                        if(map[sanggeunR+dr[i]][sanggeunC+dc[i]] == '#' || map[sanggeunR+dr[i]][sanggeunC+dc[i]] == '*'){
                            find++;
                        }
                    }
                }
                if(find == 4){
                    System.out.println("IMPOSSIBLE");
                    break;
                }else if(find == 0){
                    break;
                }

                //번지게 만들 불이 남아있을 때
                while(!fire.isEmpty()){
                    int[] curFire = fire.poll();
                    for(int i=0; i<4; i++){
                        int nextFireR = curFire[0]+dr[i];
                        int nextFireC = curFire[1]+dc[i];
                        //불이 map 내부에 있을 때
                        if(0<=nextFireR && nextFireR<w && 0<=nextFireC && nextFireC<h){
                            //다음 칸이 . 일 때
                            if(map[nextFireR][nextFireC] == '.'){
                                map[nextFireR][nextFireC] = '*';
                                fire.add(new int[]{nextFireR, nextFireC});
                            }//다음 칸이 @ 일 때 상근이가 이동 가능한지 파악
                            else if(map[nextFireR][nextFireC] == '@'){
                                flag = 0;
                                for(int j=0; j<4; j++){
                                    if(0<=sanggeunR+dr[j] && sanggeunR+dr[j]<w && 0<=sanggeunC+dc[j] && sanggeunC+dc[j]<h
                                            && map[sanggeunR+dr[j]][sanggeunC+dc[j]] == '.' && visited[sanggeunR+dr[j]][sanggeunC+dc[j]] == false){
                                        visited[sanggeunR+dr[j]][sanggeunC+dc[j]] = true;
                                        map[sanggeunR][sanggeunC] = '.';
                                        sanggeunR = sanggeunR+dr[j];
                                        sanggeunC = sanggeunC+dc[j];
                                        flag = 1;
                                        count++;
                                        break;
                                    }
                                }
                                //상근이가 이동했으면
                                if(flag == 1){
                                    map[nextFireR][nextFireC] = '*';
                                    fire.add(new int[]{nextFireR, nextFireC});
                                }//이동 못했으면
                                else{
                                    System.out.println("IMPOSSIBLE");
                                    flag = 2;
                                    break;
                                }
                            }
                        }
                    }
                }

                if(flag == 2) break;

                //상근이가 이동한 후
                if(flag == 1){
                    continue;
                }else{
                    //상근이가 이동하고, 불이 없을 때
                    int flag2 = 0;
                    for(int i=0; i<4; i++){
                        //밖으로 탈출 가능할때
                        if(sanggeunR+dr[i] < 0 || sanggeunR+dr[i] >= w || sanggeunC+dc[i] < 0 || sanggeunC+dc[i] >= h){
                            System.out.println(count+1);
                            flag2 = 1;
                            break;
                        }else{
                            //이동 가능할 때
                            if(map[sanggeunR+dr[i]][sanggeunC+dc[i]] == '.' && visited[sanggeunR+dr[i]][sanggeunC+dc[i]] == false){
                                visited[sanggeunR+dr[i]][sanggeunC+dc[i]] = true;
                                map[sanggeunR][sanggeunC] = '.';
                                sanggeunR = sanggeunR+dr[i];
                                sanggeunC = sanggeunC+dc[i];
                                flag2 = 2;
                                count++;
                                break;
                            }
                        }
                    }
                    if(flag2 == 1){
                        break;
                    }else if(flag2 == 2){
                        continue;
                    }else{
                        System.out.println("IMPOSSIBLE");
                        break;
                    }
                }
            }
        }
    }
}
