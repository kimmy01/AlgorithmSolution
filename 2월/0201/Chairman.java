package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chairman {

    static int array[];
    static int array2[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        int T = Integer.parseInt(t);
        for(int i = 0; i<T; i++){
            String k =br.readLine();
            int K = Integer.parseInt(k);
            String n = br.readLine();
            int N = Integer.parseInt(n);

            array = new int[N];
            for(int j = 0; j<N; j++){
                array[j] = j+1;
            }

            function(K, N);

        }
    }
    static void function(int k, int n){
        array2 = new int[n];
        array2[0] = 1;
        for(int i=1; i<n; i++){
            array2[i] = array2[i-1]+array[i];
//            System.out.print(array2[i]+" = "+array2[i-1]+" + " + array[i] + "\n");
            array[i] = array2[i];
        }

        if(k == 1){
            System.out.println(array2[n-1]);
            return;
        }

        function(k-1, n);
    }
}
