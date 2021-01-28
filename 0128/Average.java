package com.algo0128;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Average {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int N = Integer.parseInt(str);
		int[] score = new int[N];
		double sum = 0;
		int M = 0;
		double temp = 0;
		
		str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		for(int i=0; i<N; i++) {	
			score[i]  = Integer.parseInt(stk.nextToken());
			if(score[i]>M) {
				M = score[i];
			}
		}
		for(int j=0; j<N; j++) {
			sum += (double)score[j]/M*100;
		}
		double avg = (double)sum/N;
		System.out.printf("%.2f", avg);
	}
}
