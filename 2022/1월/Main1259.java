package com.algo2022_01;

import java.util.*;

public class Main1259 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while(true){
            String tmp = sc.nextLine();
            if(Integer.parseInt(tmp) == 0) break;
            boolean flag = func(tmp);
            if(flag){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
    static boolean func(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
