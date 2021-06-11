package com.algo0611;

import java.util.HashMap;

public class Solution_다단계칫솔 {
    static String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
    static String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
    //static String[] seller = {"young", "john", "tod", "emily", "mary"};
    static String[] seller = {"sam", "emily", "jaimie", "edward"};
    //static int[] amount = {12, 4, 2, 5, 10};
    static int[] amount = {2, 3, 5, 4};
    static HashMap<String, Integer> memberNum = new HashMap<>();
    static int[] result;
    //result = {360, 958, 108, 0, 450, 18, 180, 1080}
    //result = {0, 110, 378, 180, 270, 450, 0, 0}
    public static void main(String[] args) {
        result = new int[enroll.length];
        for(int i=0; i<enroll.length; i++){
            memberNum.put(enroll[i], i);
        }
        for(int i=0; i<seller.length; i++){
            DFS(seller[i], amount[i]*100);
        }
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
    static void DFS(String member, int profit){
        if((int)(profit*0.1) < 1){ //내 이익의 10%가 1보다 작을 때
            result[memberNum.get(member)] += profit;
            return;
        }else{ //내 이익을 나눠줘야 할 때
            result[memberNum.get(member)] += profit - (int)(profit*0.1);
            if(referral[memberNum.get(member)].equals("-")){ //만약 나의 추천인이 없을 때
                return;
            }else{ //나의 추천인이 있을 때
                DFS(referral[memberNum.get(member)], (int)(profit*0.1));
            }
        }
    }
}
