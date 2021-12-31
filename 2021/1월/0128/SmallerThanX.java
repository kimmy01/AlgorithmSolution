package com.algo0128;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SmallerThanX {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		StringTokenizer stk = new StringTokenizer(str);
		
		int N = Integer.parseInt(stk.nextToken());
		int X = Integer.parseInt(stk.nextToken());
		int []num = new int[N];
		int a = 0;
		
		String str2 = br.readLine();
		StringTokenizer stk2 = new StringTokenizer(str2);
		for(int i=0; i<N; i++) {
			int j = Integer.parseInt(stk2.nextToken());
			if(j < X) {
				num[a] = j;
				a++;
			}
		}
		
		for(int k=0; k<num.length; k++) {
			if(num[k]>0) {
				bw.write(String.valueOf(num[k]) + " ");
				bw.flush();
			}
			else {
				break;
			}
		}
	}
}
