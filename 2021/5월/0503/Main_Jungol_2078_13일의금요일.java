package com.algo0502;
import java.io.*;
public class Main_Jungol_2078_13일의금요일 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] days = new int[7]; //1월 2화 3수 4목 5금 6토 0일
        int a = 13;
        for(int i=0; i<N; i++){
            int year = 1900+i;
            if((year%4 == 0 && year%100 != 0) || year%400 == 0){//윤년
                for(int j=1; j<=12; j++){
                    int tmp = a%7;
                    days[tmp]++;
                    if(j==4 || j==6 || j==9 || j==11){
                        a += 30;
                    }else if(j==2){
                        a += 29;
                    }else{
                        a += 31;
                    }
                }
            }else {
                for(int j=1; j<=12; j++){
                    int tmp = a%7;
                    days[tmp]++;
                    if(j==4 || j==6 || j==9 || j==11){
                        a += 30;
                    }else if(j==2){
                        a += 28;
                    }else{
                        a += 31;
                    }
                }
            }
        }
        for(int i=1; i<7; i++){
            System.out.print(days[i]+" ");
        }
        System.out.print(days[0]+" ");
    }
}
