package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_원재의메모리복구하기_D3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int T = Integer.parseInt(str);
		char[] array;
		
		for(int i=0; i<T; i++) {
			int count = 0;
			str = br.readLine();
			array = new char[str.length()];
			array = str.toCharArray();
			
			if(array[0] == '1') {
				count++;
			}
			for(int j=1; j<array.length; j++) {
				if(array[j] != array[j-1]) {
					count++;
				}else {
					continue;
				}
			}
			bw.write("#"+ String.valueOf(i+1) +" "+count+"\n");
			bw.flush();
			//System.out.printf("#%d %d\n",i+1 ,count);
		}
	}
}
