package com.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FastPlus {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String N = bf.readLine();
		int tc = Integer.parseInt(N);
		//System.out.println(tc);
		
		String[] str = new String[tc];
		for(int i=0; i<tc; i++) {
			str[i] = bf.readLine();
			StringTokenizer st = new StringTokenizer(str[i]);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(String.valueOf(a+b));
			bw.write("\n");
			
		}bw.close();
	}
}
