package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alarm {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		

		if(minute < 45) {
			if(hour == 0) {
				hour = 23;
				minute += 15;
			}else {
				hour -= 1;
				minute += 15;
			}
		}else {
			minute -= 45;
		}
		
		System.out.printf("%d %d", hour, minute);
	}
}
