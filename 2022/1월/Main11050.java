package com.algo2022_01;

import java.util.*;

public class Main11050 {
    static int a, b;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        System.out.println(fact(a) / (fact(a-b)*fact(b)));
    }
    static int fact(int n) {
        if(n<=1) return 1;
        return n*fact(n-1);
    }
    static void input() throws Exception {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
    }
}
