package com.algo0226;
import java.io.*;
import java.util.*;
public class Main_BOJ_2527_직사각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<4; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int x1 = stoi(stk.nextToken());
            int y1 = stoi(stk.nextToken());
            int x2 = stoi(stk.nextToken());
            int y2 = stoi(stk.nextToken());
            //////////////////////////////1번사각형
            int x3 = stoi(stk.nextToken());
            int y3 = stoi(stk.nextToken());
            int x4 = stoi(stk.nextToken());
            int y4 = stoi(stk.nextToken());
            //////////////////////////////2번사각형
            if((x2==x3&&y2==y3) || (x1==x4&&y2==y3) || (x2==x3&&y1==y4) || (x1==x4&&y1==y4)){
                System.out.println("c");
            }else if((x2==x3&&y2!=y3) || (x1==x4&&y2!=y3) || (x2!=x3&&y1==y4) || (x1!=x4&&y1==y4)){
                System.out.println("b");
            }else if(x2<x3 || x4<x1 || y2<y3 || y4<y1){
                System.out.println("d");
            }else{
                System.out.println("a");
            }
        }
    }
    static int stoi(String s){
        return Integer.parseInt(s);
    }
}