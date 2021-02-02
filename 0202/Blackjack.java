package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Blackjack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        StringTokenizer stk = new StringTokenizer(line1);
        int cardCount = Integer.parseInt(stk.nextToken());
        int compare = Integer.parseInt(stk.nextToken());
        int[] cards = new int[cardCount]; //입력받은 카드
        int[] selected = new int[3]; //매번 선택되는 카드
        int[] answers = new int[3]; //답으로 출력하는 카드
        int hap; //중간에 카드 3장의 합 저장
        int difference = 3000000; //목표값 - 카드3장의 합
        int temp = difference; //제일 작은 difference 값 저장

        String cardNumber = br.readLine(); //카드 수 입력
        stk = new StringTokenizer(cardNumber);
        for(int i=0; i<cardCount; i++){
            cards[i] = Integer.parseInt(stk.nextToken());
        }//카드 배열에 집어넣기

        for(int i=0; i<cardCount; i++){ //첫번째 카드 뽑기
            for(int j=0; j<cardCount; j++){ //두번째 카드 뽑기
                for(int k=0; k<cardCount; k++){ //세번째 카드 뽑기

                    if(i!=j && i!=k && j!=k){ //카드 세 장이 모두 다를 때
                        selected[0] = cards[i]; //selected배열에 카드 집어넣기
                        selected[1] = cards[j];
                        selected[2] = cards[k];

                        hap = selected[0]+selected[1]+selected[2]; //카드 세장 합

                        difference = compare - hap; //목표값 - 카드 세장 합
                        if(difference >= 0 && difference <= temp){ //만약 카드 세장의 합이 0과 같거나 크고, 임시저장된 가장 작은 difference 값과 비교해서 작을 때
                            temp = difference; //임시저장값에 difference 넣음
                            answers[0] = selected[0]; //answer에 카드 값 넣음
                            answers[1] = selected[1];
                            answers[2] = selected[2];
                        }else{
                            continue;
                        }
                    }
                }
            }
        }
        hap = answers[0]+answers[1]+answers[2];
        System.out.println(hap);
    }
}
