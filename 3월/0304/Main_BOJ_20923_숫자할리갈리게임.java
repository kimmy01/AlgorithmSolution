package com.algo0304;
import java.nio.Buffer;
import java.util.*;
import java.io.*;
public class Main_BOJ_20923_숫자할리갈리게임 {
    static int dodoflag, suyeonflag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        Deque<Integer> dodoDeck = new LinkedList<>();
        Deque<Integer> suyeonDeck = new LinkedList<>();

        Deque<Integer> dodoGround = new LinkedList<>();
        Deque<Integer> suyeonGround = new LinkedList<>();

        for(int i=0; i<N; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            dodoDeck.add(Integer.parseInt(stk.nextToken()));
            suyeonDeck.add(Integer.parseInt(stk.nextToken()));
        }
        int count = 0;
        dodoflag = 0;
        suyeonflag = 0;
            while(true){
                dodoGround.add(dodoDeck.pollLast());
                emptycheck(dodoDeck, suyeonDeck);
                if(dodoflag == 1 || suyeonflag == 1){
                    break;
                }
                if(dodoBell(dodoGround, suyeonGround)){//도도가 종 치면
                    while(!suyeonGround.isEmpty()){
                        dodoDeck.addFirst(suyeonGround.poll());
                    }
                    while(!dodoGround.isEmpty()){
                        dodoDeck.addFirst(dodoGround.poll());
                    }
                    count++;
                }else if(suyeonBell(dodoGround, suyeonGround)){//수연이 종 치면
                    while(!dodoGround.isEmpty()){
                        suyeonDeck.addFirst(dodoGround.poll());
                    }
                    while(!suyeonGround.isEmpty()){
                        suyeonDeck.addFirst(suyeonGround.poll());
                    }
                    count++;
                }else{
                    count++;
                }
                if(count==M){
                    break;
                }
                suyeonGround.add(suyeonDeck.pollLast());
                emptycheck(dodoDeck, suyeonDeck);
                if(dodoflag == 1 || suyeonflag == 1){
                    break;
                }
                if(dodoBell(dodoGround, suyeonGround)){//도도가 종 치면
                    while(!suyeonGround.isEmpty()){
                        dodoDeck.addFirst(suyeonGround.poll());
                    }
                    while(!dodoGround.isEmpty()){
                        dodoDeck.addFirst(dodoGround.poll());
                    }
                    count++;
                }else if(suyeonBell(dodoGround, suyeonGround)){//수연이 종 치면
                    while(!dodoGround.isEmpty()){
                        suyeonDeck.addFirst(dodoGround.poll());
                    }
                    while(!suyeonGround.isEmpty()){
                        suyeonDeck.addFirst(suyeonGround.poll());
                    }
                    count++;
                }else{
                    count++;
                }
                if(count==M){
                    break;
                }
            }

        int dodocards = dodoDeck.size();
        int suyeoncards = suyeonDeck.size();

        if((dodocards > suyeoncards) || suyeonflag==1){
            System.out.println("do");
        }else if((dodocards < suyeoncards) || dodoflag==1){
            System.out.println("su");
        }else if(dodocards == suyeoncards){
            System.out.println("dosu");
        }

    }
    static boolean dodoBell(Deque<Integer> dodo, Deque<Integer> suyeon){
        if(!dodo.isEmpty()){
            if(dodo.peekLast() == 5)return true;
        }
        if(!suyeon.isEmpty()){
            if(suyeon.peekLast() == 5)return true;
        }
        return false;
    }

    static boolean suyeonBell(Deque<Integer> dodo, Deque<Integer> suyeon){
        if(!dodo.isEmpty() && !suyeon.isEmpty()){
            if(dodo.peekLast()+suyeon.peekLast() == 5){
                return true;
            }
        }
        return false;
    }
    static void emptycheck(Deque<Integer> dodo, Deque<Integer> suyeon){
        if(dodo.isEmpty()){
            dodoflag = 1;
        }
        if(suyeon.isEmpty()){
            suyeonflag = 1;
        }
    }
}
