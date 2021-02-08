package day0208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_CipherText1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine()); //원문 암호문의 길이
			String a = br.readLine(); //원문 암호문 통째로
			StringTokenizer stk = new StringTokenizer(a, " ");
			ArrayList<Integer> numArray = new ArrayList<>(); //암호문 저장할 ArrayList
			for(int n=0; n<N; n++) {
				numArray.add(Integer.parseInt(stk.nextToken())); //원문 암호문 저장
			}
			int commandN = Integer.parseInt(br.readLine()); //명령어 개수
			String command = br.readLine(); //명령어 입력
			stk = new StringTokenizer(command, " ");
			for(int n=0; n<commandN; n++) {
				String I = stk.nextToken(); //I
				int x = Integer.parseInt(stk.nextToken()); //x (x위치)
				int y = Integer.parseInt(stk.nextToken()); //숫자 개수 y
				for(int s=0; s<y; s++) {
					numArray.add(x+s, Integer.parseInt(stk.nextToken())); //해당하는 위치에 바로 숫자 저장
				}
			}
			//출력부분
			bw.write("#"+String.valueOf(t)+" ");
			for(int n=0; n<10; n++) {
				bw.write(String.valueOf(numArray.get(n))+" ");
			}
			bw.newLine();
			bw.flush();
		}
	}
}
