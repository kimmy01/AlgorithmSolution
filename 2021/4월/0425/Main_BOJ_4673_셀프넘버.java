package com.algo0426;
public class Main_BOJ_4673_셀프넘버 {
    public static void main(String[] args) throws Exception {
        boolean[] checked = new boolean[10001];

        for(int i=1; i<=10000; i++){
            int num = i;
            int answer = i;
            if(i >= 10){
                while(true){
                    if(num < 10) break;
                    answer += num%10;
                    num/=10;
                }
                answer += num;
            }else{
                answer += i;
            }
            if(answer <= 10000){
                checked[answer] = true;
            }
        }

        for(int i=1; i<=10000; i++){
            if(!checked[i])
                System.out.println(i);
        }
    }
}