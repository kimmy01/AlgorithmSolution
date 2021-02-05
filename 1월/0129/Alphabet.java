package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alphabet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] array = new int[26];
        char[] s = new char[S.length()];
        for(int i = 0; i<S.length(); i++){
            s[i] = S.charAt(i);
        }

        for(int i = 0; i<26; i++){
            array[i] = -1;
        }

        for(int i=0; i<s.length; i++){
            for(int j=0; j<26; j++){
                if(j+97 == (int)s[i]){
                    if(array[j] == -1){
                        array[j] = i;
                        break;
                    }
                }
            }
        }

        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}
