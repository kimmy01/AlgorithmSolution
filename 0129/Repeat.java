package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Repeat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String TC = br.readLine();
         int tc = Integer.parseInt(TC);


        for(int i=0; i<tc; i++){
            String str = br.readLine();
            StringTokenizer stk = new StringTokenizer(str);
            int R = Integer.parseInt(stk.nextToken());
            String S = stk.nextToken();

            for(int j=0; j<S.length(); j++){
                for(int r=0; r<R; r++){
                    System.out.print(S.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
