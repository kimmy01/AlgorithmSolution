package com.algo0128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BetterThanAvg {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int C = Integer.parseInt(str);
		
		for(int i = 0; i < C; i++) {
			int score = 0;
			double avg = 0;
			int cnt = 0;
			double ratio = 0;
			str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str);
			int N = Integer.parseInt(stk.nextToken());
			int[] array = new int[N];
			
			for(int j=0; j<N; j++) {
				array[j] = Integer.parseInt(stk.nextToken());
				score += array[j];
			}
			avg = (double)score/N;
			
			for(int k=0; k<N; k++) {
				if(array[k]>avg) {
					cnt++;
				}
			}
			ratio = (double)cnt/N*100;
			System.out.printf("%.3f",ratio);
			System.out.println("%");
		}//TC
	}
}
