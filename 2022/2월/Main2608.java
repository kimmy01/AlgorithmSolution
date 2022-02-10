package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main2608 {
    static String num1, num2;
    static HashMap<String, Integer> map1 = new HashMap<>();
    static HashMap<Integer, String> map2 = new HashMap<>();
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        int hap = convertStringToNum(num1) + convertStringToNum(num2);
        System.out.println(hap);
        System.out.println(convertNumToString(hap));
    }
    static String convertNumToString(int num) {
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        while(num >= 10){
            stack.push(num%10);
            num /= 10;
        }
        stack.push(num);

        while(!stack.isEmpty()){
            int unit = (int)Math.pow(10, stack.size()-1);
            int n = stack.pop();
            int tmp = n*unit;
            if(n == 4 || n == 5 || n == 9){
                sb.append(map2.get(tmp));
                continue;
            }else if(n > 5){
                sb.append(map2.get(5*unit));
                n -= 5;
            }
            for(int i=0; i<n; i++){
                sb.append(map2.get(unit));
            }
        }

        return sb.toString();
    }
    static int convertStringToNum(String s) {
        int num = 0;

        char[] tmp = s.toCharArray();
        for(int i=0; i<tmp.length; i++){
            if(i > 0){
                StringBuilder sb = new StringBuilder();
                sb.append(tmp[i-1]).append(tmp[i]);
                String a = sb.toString();
                if(a.equals("IV") || a.equals("IX") || a.equals("XL") || a.equals("XC") || a.equals("CD") || a.equals("CM")){
                    num -= map1.get(String.valueOf(tmp[i-1]));
                    num += map1.get(a);
                }else{
                    num += map1.get(String.valueOf(tmp[i]));
                }
                continue;
            }
            num += map1.get(String.valueOf(tmp[i]));
        }

        return num;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num1 = br.readLine();
        num2 = br.readLine();
        map1.put("I", 1);
        map1.put("V", 5);
        map1.put("X", 10);
        map1.put("L", 50);
        map1.put("C", 100);
        map1.put("D", 500);
        map1.put("M", 1000);
        map1.put("IV", 4);
        map1.put("IX", 9);
        map1.put("XL", 40);
        map1.put("XC", 90);
        map1.put("CD", 400);
        map1.put("CM", 900);
        map2.put(1, "I");
        map2.put(5, "V");
        map2.put(10, "X");
        map2.put(50, "L");
        map2.put(100, "C");
        map2.put(500, "D");
        map2.put(1000, "M");
        map2.put(4, "IV");
        map2.put(9, "IX");
        map2.put(40, "XL");
        map2.put(90, "XC");
        map2.put(400, "CD");
        map2.put(900, "CM");
    }
}
