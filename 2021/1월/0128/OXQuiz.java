package com.algo0128;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class OXQuiz {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int N = Integer.parseInt(str);
		
		

		for(int i=0; i<N; i++) {	
			int score = 0;
			int temp = 0;
			
			str = br.readLine();
			int size = str.length();
			char[] array = new char[size];
			
			
			for(int j=0; j<size; j++) {
				StringTokenizer stk = new StringTokenizer(str);
				array[j] = stk.nextToken().charAt(j);
				if(array[j] == 'X') {
					temp = 0;
				}else if(array[j] == 'O'){
					temp+=1;
					score+=temp;
				}
			}
			System.out.println(score);
		}
	}
}
