package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int N = Integer.parseInt(n);
        int size = N;
        String str;

        for(int i=0; i<size; i++){
            str = br.readLine();
            char[] word = new char[str.length()];
            for(int j=0; j<str.length(); j++){
                word[j] = str.charAt(j);
            }

            int flag = 1;

            for(int a=0; a<word.length; a++){
                int check = a+1;
                while (true) {
                    if(check >= word.length){
                        break;
                    }else{
                        if(word[a] != word[check]){
                            break;
                        }else{
                            check+=1;
                        }
                    }
                }
                for(int b=check+1; b< word.length; b++){
                    if(word[a] == word[b]){
                        flag = 0;
                        break;
                    }
                }
                if(flag == 0){
                    N-=1;
                    break;
                }
            }
        }
        System.out.println(N);
    }
}
