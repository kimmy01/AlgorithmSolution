package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alphabet2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] array = new int[26];
        char[] s = new char[S.length()];
        int ascii = 0;
        for(int i = 0; i<S.length(); i++){
            s[i] = S.charAt(i);
        }

        for(int i = 0; i<26; i++){
            array[i] = -1;
        }

        for(int i=0; i<s.length; i++){
            ascii = (int)s[i]-97;
            if(array[ascii] == -1){
                array[ascii] = i;
            }
        }

        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}
