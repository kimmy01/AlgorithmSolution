package com.algo2022_02;

import java.io.*;

public class Main16472 {
    static int N, alphabetCount, len;
    static int[] checked = new int[27];
    static char[] lettering;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        int left = 0;
        int right = 0;
        while(right < lettering.length){
            if(left == right){ //두 포인터 위치 같으면 (시작)
                checked[lettering[left] - 'a']++;
                alphabetCount++;
            }
            if(right+1 < lettering.length){ //다음칸 있으면
                right++;
                if(checked[lettering[right]-'a'] > 0){ //이미 체크된 알파벳
                    checked[lettering[right]-'a']++;
                }else{ //새 알파벳
                    if(alphabetCount < N){
                        alphabetCount++;
                    }else{
                        while(true){
                            --checked[lettering[left]-'a'];
                            if(checked[lettering[left]-'a'] == 0) {
                                left++;
                                break;
                            }
                            left++;
                        }
                    }
                    checked[lettering[right]-'a']++;
                }
            }else{
                break;
            }
            len = Math.max(len, right-left+1);
        }
        System.out.println(len);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lettering = br.readLine().toCharArray();
        alphabetCount = 0;
        len = 0;
    }
}
