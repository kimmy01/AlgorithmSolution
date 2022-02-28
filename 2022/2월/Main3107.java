package com.algo2022_02;

import java.io.*;

public class Main3107 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if(s.contains("0000")){
            s = s.replaceAll("0000", "0");
        }
        if(s.contains("::")){
            if(s.startsWith(":"))
                s = s.replace("::", "0000:");
            else if(s.endsWith(":"))
                s = s.replace("::", ":0000");
            else
                s = s.replace("::", ":0000:");
        } //처음에 바꾸기
        int colonCnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ':') colonCnt++;
        }
        while(colonCnt < 7){
            if(s.contains("0000:")) //1:0000:0001 => 1:0000:0000:0001
                s = s.replaceFirst("0000:", "0000:0000:");
            else if(s.contains("0000")) //1:0000:0000
                s = s.replaceFirst("0000", "0000:0000");
            colonCnt++;
        } //::
        if(s.endsWith(":")) s = s + "0000";
        String[] arr = s.split(":");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            while(arr[i].length() < 4){
                arr[i] = "0"+arr[i];
            }
            sb.append(arr[i]);
            if(i < arr.length - 1)
                sb.append(":");
        }
        System.out.println(sb.toString());
    }
}
