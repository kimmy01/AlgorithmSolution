package com.algo0331;

import java.util.*;
import java.io.*;

public class Main_BOJ_1157_단어공부 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.toUpperCase();
        HashMap<Character, Integer> alphabets = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (alphabets.containsKey(key)) {
                int temp = alphabets.get(key) + 1;
                alphabets.put(key, temp);
                continue;
            }
            alphabets.put(key, 1);
        }
        int max = 0;
        char maximum = 'a';
        Iterator<Character> iterator = alphabets.keySet().iterator();
        while (iterator.hasNext()) {
            char key = iterator.next();
            int temp = alphabets.get(key);
            if (temp > max) {
                maximum = key;
                max = temp;
            }
        }
        int flag = 0;
        iterator = alphabets.keySet().iterator();
        while (iterator.hasNext()) {
            char key = iterator.next();
            int temp = alphabets.get(key);
            if (temp == max && key != maximum) {
                flag++;
            }
        }
        if (flag == 0) {
            System.out.println(maximum);
        } else {
            System.out.println('?');
        }
    }
}
