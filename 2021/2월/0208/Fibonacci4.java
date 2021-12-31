package com.victoria;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.function.BiFunction;

public class Fibonacci4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //BigInteger bigInteger = new BigInteger(n);
//        BigInteger bigInteger = fibonacci(n);
//        System.out.println(bigInteger);
        BigInteger array[] = new BigInteger[n+2];
        array[0] = BigInteger.ZERO;
        array[1] = BigInteger.ONE;
        for(int i=2; i<=n; i++){
            array[i] = array[i-1].add(array[i-2]);
        }
        System.out.println(array[n]);
    }

//    static BigInteger fibonacci(int N){
//        BigInteger bigOne = new BigInteger("1");
//        if(N==1){
//            return bigOne;
//        }else if(N==2){
//            return bigOne;
//        }
//        else{
//            return fibonacci(N-1).add(fibonacci(N-2));
//        }
//    }
}
