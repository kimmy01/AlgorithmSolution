package com.algo0330;
import java.io.*;
public class Main_BOJ_12871_무한문자열 {
    static int gcd, lcm;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        String repeatedS = s;
        String repeatedT = t;
        gcd = 0;
        lcm = 0;
        if(s.length() != t.length()){
            GCD(s.length(), t.length());
            LCM(s.length(), t.length());
            int repeatLength = lcm;
            while(repeatedS.length() != repeatLength) repeatedS = repeatedS.concat(s);
            while(repeatedT.length() != repeatLength) repeatedT = repeatedT.concat(t);
        }
        if(repeatedS.equals(repeatedT)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static void GCD(int A, int B){
        if(A%B == 0){
            gcd = B;
        }else GCD(B, A % B);
    }
    static void LCM(int A, int B){
        lcm = A*B/gcd;
    }
}
