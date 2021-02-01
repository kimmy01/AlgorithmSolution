package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BJ_1244_스위치켜고끄기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String t = br.readLine(); //스위치 개수
		int T = Integer.parseInt(t);
		
		String sw = br.readLine(); //스위치 상태
		int[] array = new int[T+1];
		array[0] = 0;
		StringTokenizer stk = new StringTokenizer(sw, " ");
		for(int i=1; i<T+1; i++) {
			array[i] = Integer.parseInt(stk.nextToken());
		}
		
		String p = br.readLine(); //사람 명 수
		int P = Integer.parseInt(p);
		
		String num;
		int sex; //성별
		int swnum; //스위치번호
		
		
		for(int i=0; i<P; i++) {
			int plus = 1;
			num = br.readLine();
			stk = new StringTokenizer(num, " ");
			sex = Integer.parseInt(stk.nextToken());
			swnum = Integer.parseInt(stk.nextToken());
			
			if(sex == 1) {
				for(int j=1; j<=(T/swnum); j++) { //스위치개수/스위치번호 몫만큼 반복
					if(array[j*swnum] == 1) {
						array[j*swnum] = 0;
					}else {
						array[j*swnum] = 1;
					}
				}
			}//남자일때
			else{
				//해당 번호 먼저 바꿔주기
				if(array[swnum] == 1) {
					array[swnum] = 0;
				}else {
					array[swnum] = 1;
				}
				
				while(true) {
					if(swnum+plus <= T && swnum-plus >= 1) {
						if(array[swnum+plus] == array[swnum-plus]) {
							if(array[swnum+plus] == 1) {
								array[swnum+plus] = 0;
								array[swnum-plus] = 0;
							}else {
								array[swnum+plus] = 1;
								array[swnum-plus] = 1;
							}
							plus++;
						}else {
							break;
						}	
					}//0이상, 배열끝번호 이하인지 체크
					else {
						break;
					}
				}//while 종료
			}//여자일때
		}
	for(int j = 1; j<T+1; j++) {
		System.out.print(array[j]);
		if(j%20 == 0) {
			System.out.print("\n");
			}else {
				if(j!=T) {
					System.out.print(" ");
				}
			}
		
		}//출력
	}
}
