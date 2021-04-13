package com.algo0413;
import java.io.*;
import java.util.*;
public class Main_BOJ_2564_경비원 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); //가로
        int M = Integer.parseInt(st.nextToken()); //세로
        int S = Integer.parseInt(br.readLine());
        int[][] stores = new int[S][2];
        for(int i=0; i<S; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            if(a == 2){
                a = 3;
            }else if(a == 3){
                a = 2;
            }
            stores[i][0] = a;
            stores[i][1] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int dong1 = Integer.parseInt(st.nextToken());
        if(dong1 == 2){
            dong1 = 3;
        }else if(dong1 == 3){
            dong1 = 2;
        }
        int dong2 = Integer.parseInt(st.nextToken());

        //1북 2서 3남 4동

        int sum = 0;
        for(int i=0; i<S; i++){
            int a = Math.abs(dong1 - stores[i][0]);
            if(a == 2){ //반대편
                if(dong1 == 1 || dong1 == 3){
                    sum += M;
                    sum += Math.min(dong2+stores[i][1], (N-dong2)+(N-stores[i][1]));
                }else if(dong1 == 2 || dong2 == 4){
                    sum += N;
                    sum += Math.min(dong2+stores[i][1], (M-dong2)+(M-stores[i][1]));
                }
            }else if(a == 0){ //같은 편
                sum += Math.abs(dong2 - stores[i][1]);
            }else{ //인접
                if(dong1 == 1){
                    if(stores[i][0] == 2){
                        sum += dong2 + stores[i][1];
                    }else if(stores[i][0] == 4){
                        sum += N-dong2 + stores[i][1];
                    }
                }else if(dong1 == 2){
                    if(stores[i][0] == 1){
                        sum += dong2 + stores[i][1];
                    }else if(stores[i][0] == 3){
                        sum += M-dong2 + stores[i][1];
                    }
                }else if(dong1 == 3){
                    if(stores[i][0] == 2){
                        sum += dong2 + M-stores[i][1];
                    }else if(stores[i][0] == 4){
                        sum += N-dong2 + M-stores[i][1];
                    }
                }else if(dong1 == 4){
                    if(stores[i][0] == 1){
                        sum += dong2 + N-stores[i][1];
                    }else if(stores[i][0] == 3){
                        sum += M-dong2 + N-stores[i][1];
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
