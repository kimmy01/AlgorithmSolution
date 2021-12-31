package com.algo0608;

import java.util.Arrays;

public class Programmers_K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int nth = commands[i][2]-1;
            int[] tmpArr = new int[end-start+1];
            int idx = 0;
            for(int j=start; j<=end; j++){
                tmpArr[idx] = array[j];
                idx++;
            }
            Arrays.sort(tmpArr);
            answer[i] = tmpArr[nth];
        }
    }
}
