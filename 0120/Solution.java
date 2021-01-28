package com.ssafy.ws02.step3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt(); //TestCase

		for(int tc=1; tc<=T; tc++) {
			int N = scan.nextInt();
			//배열 객체 생성 (입력한 데이터를 저장할 공간 확보)
			char[][]area = new char[N][N];
			
			//데이터 입력
			for(int i=0; i<N; i++) { //행인덱스 표현 //i<area.length
				for(int j=0; j<N; j++) { //열인덱스 표현 //j<area[i].length
					area[i][j] = scan.next().charAt(0); //"G".charAt(0) --> 'G'
				}
			}
			
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(area[i]));
//			}//배열에 잘 들어갔는지 확인
			
			
//				0	1	2	3			
//			0
//			1		*
//			2
//			3
			
			
			//빌딩체크
			int ans=0;
			for(int i=0; i<N; i++) { //행인덱스 표현 
				for(int j=0; j<N; j++) { //열인덱스 표현
					
					boolean isPark=false;
					int bCount = 0; //빌딩카운트
					if(area[i][j] == 'B') { //현구획이 빌딩이면
						
						//8방에 'G'가 있다면 빌딩은 2층
						if(i-1>=0 &&               area[i-1][j] == 'G') isPark=true;//상
						else if(i-1>=0 && j+1<N && area[i-1][j+1] == 'G') isPark=true;//우상
						else if(j+1<N &&           area[i][j+1] == 'G') isPark=true;//우
						else if(i+1<N && j+1<N &&  area[i+1][j+1] == 'G') isPark=true;//우하
						else if(i+1<N &&           area[i+1][j] == 'G') isPark=true;//하
						else if(i+1<N && j-1>0 &&  area[i+1][j-1] == 'G') isPark=true;//좌하
						else if(j-1>=0 &&          area[i][j-1] == 'G') isPark=true;//좌
						else if(i-1>0 &&           area[i-1][j-1] == 'G')isPark=true; //좌상
						
						if(!isPark) {//8방향 주위에 공원이 없다면
							//수직선과 수평선에 있는 B를 카운트
							for(int k=0; k<N; k++) {
								if(area[k][j]=='B') bCount++; //수직선(세로줄) 체크
								if(area[i][k]=='B') bCount++; //수평선(가로줄) 체크
							}
							bCount--; //가로 세로의 중복 제거
						}else {
							//주위에 공원이 한 개 이상 있다면 빌딩의 높이는 2
							bCount=2;
						}
						if(bCount > ans) ans=bCount; //최대값 갱신
					}//if
				}//for
			}//for
			System.out.println("#"+tc+" "+ans);
		}//TestCase
		scan.close();
	} //main
}//class end
