package com.algo0128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlusCycle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int str = Integer.parseInt(s);
		int m = str;
		int a;
		int b;
		int c;
		int k;
		int d;
		int cnt=0;
		
		while(true) {
			a = str/10;
			b = str%10;
			c = a+b;
			k = c%10;
			d = b*10+k;
			cnt+=1;
			str = d;
			if(m == d) {
				break;
			}
		}
		System.out.println(cnt);
	}
}
