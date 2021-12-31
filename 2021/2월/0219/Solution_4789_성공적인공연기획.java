package com.algo0219;
import java.io.*;

public class Solution_4789_성공적인공연기획 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            String temp = br.readLine();
            int[] people = new int[temp.length()];
            for(int i=0; i<temp.length(); i++){
                people[i] = temp.charAt(i)-'0';
            }
            int clapper = 0;
            int hire = 0;
            for(int i=0; i<temp.length(); i++){
                if(clapper >= i) {clapper+=people[i];continue;}
                if(clapper < i) {
                    hire += i-clapper;
                    clapper+=i-clapper+people[i];
                }
            }
            System.out.println("#"+t+" "+hire);
        }
    }
}