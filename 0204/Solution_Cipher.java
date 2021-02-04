package day0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_Cipher {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = 10;
		
		for(int tc = 1; tc<=10; tc++) {
			int testCaseNum = Integer.parseInt(br.readLine());
			
			String numbers = br.readLine();
			StringTokenizer stk = new StringTokenizer(numbers, " ");
			int num[] = new int[8];
			
			LinkedList<Integer> queue = new LinkedList<Integer>(); //큐 생성
			
			for(int i=0; i<8; i++) {
				num[i] = Integer.parseInt(stk.nextToken());
				queue.offer(num[i]);
			} //숫자 입력 받아서 큐에 집어 넣기
			
			int flag = 0; //for문 종료 플래그
			int temp = 0; //큐에 넣기 전에 값을 빼고, 확인하는 변수
			
			while(true) {
				
				for(int j=1; j<=5; j++) { //한 사이클이 5번이기 때문에 5번 반복 for문
					
					temp = queue.poll(); //큐의 front 값을 빼서 temp에 저장
					temp -= j; //temp에서 j 빼주기
					if(temp <= 0) { //temp가 0과 같거나 0보다 작아지면 종료 플래그 날리기
						temp = 0; //temp를 0으로 바꿔주고
						queue.add(temp); //큐에 마지막으로 집어넣기
						flag = 1; //종료 플래그 날리기
						break;
					}else {
						queue.add(temp); //temp가 0보다 크다면 while, for문 반복
					}
				}
				
				if(flag == 1) { //flag가 1이면 while문 종료
					break;
				}
				
			}
			
			System.out.print("#"+testCaseNum+" ");
			
			for(int i=0; i<8; i++) {
				num[i] = queue.poll();
				System.out.print(num[i]+" ");
			}
			
			System.out.println();
		}
		
	}
}
