package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quadrant {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s1 = bf.readLine();
		String s2 = bf.readLine();
		//StringTokenizer st = new StringTokenizer(s);
		int x = Integer.parseInt(s1);
		int y = Integer.parseInt(s2);
		
		if(x>0 && y>0) System.out.println(1);
		else if(x>0 && y<0) System.out.println(4);
		else if(x<0 && y>0) System.out.println(2);
		else System.out.println(3);
	}
}
