package com.algo2022_01;

import java.util.StringTokenizer;

public class NTS_LiveCoding {
    public static void main(String[] args) {
        String test1 = "this_is_long_variable_name";
        String answer = changeConvention2(test1);
        System.out.println(answer);
        answer = changeConvention2(answer);
        System.out.println(answer);
    }
    public static String changeConvention(String input){ //초기 작성 로직
        StringTokenizer st = new StringTokenizer(input, "_");
        int tokenSize = st.countTokens();
        StringBuilder sb = new StringBuilder();
        if(tokenSize > 2){ //스네이크 => 카멜
            sb.append(st.nextToken());
            while(st.hasMoreTokens()){
                char[] chars = st.nextToken().toCharArray();
                chars[0] = Character.toUpperCase(chars[0]);
                for(char c : chars){
                    sb.append(c);
                }
            }
        }else{ //카멜 => 스네이크
            char[] chars = input.toCharArray();
            for(char c : chars){
                if(Character.isUpperCase(c)){
                    sb.append("_");
                    sb.append(Character.toLowerCase(c));
                }else{
                    sb.append(c);
                }
            }
        }
        String result = sb.toString();
        return result;
    }
    public static String changeConvention2(String input){ //개선한 로직
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx < chars.length){
            char c = chars[idx];
            if(Character.isUpperCase(c)){
                sb.append('_');
                sb.append(Character.toLowerCase(c));
            }else if(c == '_'){
                idx++;
                sb.append(Character.toUpperCase(chars[idx]));
            }else{
                sb.append(c);
            }
            idx++;
        }
        String result = sb.toString();
        return result;
    }
}
