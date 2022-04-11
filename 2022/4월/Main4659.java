package com.algo2022_04;

import java.io.*;

public class Main4659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String s = br.readLine();
            if(s.equals("end"))
                break;
            boolean vowelFlag = false;
            boolean sameFlag = true;
            boolean continueFlag = true;
            boolean[] check = new boolean[s.length()];
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    vowelFlag = true;
                    check[i] = true;
                }else{
                    check[i] = false;
                }
                if(i != 0 && c == s.charAt(i-1)){
                    if(c == 'e' || c == 'o') continue;
                    sameFlag = false;
                    break;
                }
            }
            int cnt = 0;
            for(int i=0; i<s.length(); i++){
                if(i == 0) cnt++;
                else{
                    if(check[i] == check[i-1]) cnt++;
                    else cnt = 1;
                }
                if(cnt >= 3) continueFlag = false;
            }
            if(vowelFlag && sameFlag && continueFlag){
                sb.append("<"+s+"> is acceptable.").append("\n");
            }else{
                sb.append("<"+s+"> is not acceptable.").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
