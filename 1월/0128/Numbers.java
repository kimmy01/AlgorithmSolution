package com.algo0128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numbers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		String C = br.readLine();
		
		int a = Integer.parseInt(A);
		int b = Integer.parseInt(B);
		int c = Integer.parseInt(C);
		
		String mul = Integer.toString(a*b*c);
		char[] array = new char[mul.length()];
		
		int [] answer = new int[10];
		
		for(int i=0; i<mul.length(); i++) {
			array[i] = mul.charAt(i);
			switch(array[i]) {
			case '0': answer[0]+=1;break;
			case '1': answer[1]+=1;break;
			case '2': answer[2]+=1;break;
			case '3': answer[3]+=1;break;
			case '4': answer[4]+=1;break;
			case '5': answer[5]+=1;break;
			case '6': answer[6]+=1;break;
			case '7': answer[7]+=1;break;
			case '8': answer[8]+=1;break;
			case '9': answer[9]+=1;break;
			}
		}
		for(int j=0; j<10; j++) {
			System.out.println(answer[j]);
		}
	}
}
