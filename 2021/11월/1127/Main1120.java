package com.algo11;

import java.util.*;
import java.io.*;

public class Main1120 {
    static String A, B;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    private static void func() {
        int result = A.length();

        for(int i=0; i<B.length() - A.length()+1; i++){
            int tmp = 0;
            for(int j=0; j<A.length(); j++){
                if(A.charAt(j) != B.charAt(j+i)){
                    tmp++;
                }
            }
            if(result > tmp){
                result = tmp;
            }
        }
        System.out.println(result);
    }
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = st.nextToken();
        B = st.nextToken();
    }
}
