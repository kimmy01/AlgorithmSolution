package day0205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_squareRoom {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()); //테스트케이스 수 받기
		
		for(int i=0; i<tc; i++) 
		{
			
			int N = Integer.parseInt(br.readLine()); //N값 받기
			int[][] room = new int[N][N];
			for(int j=0; j<N; j++) 
			{
				String R = br.readLine();
				StringTokenizer stk = new StringTokenizer(R, " ");
				for(int k=0; k<N; k++) 
				{
					room[j][k] = Integer.parseInt(stk.nextToken());
				}
			}//방 숫자 받기
			
			int[] dx = {-1, 1, 0, 0}; //dx 상하좌우
			int[] dy = {0, 0, -1, 1}; //dy 상하좌우
			
			int rx; int ry; //현재 x좌표 y좌표
			int[][] count = new int[N][N]; //N개의 방 별로 이동 가능한 방 수 체크
			
			for(int j=0; j<N; j++)
			{
				for(int k=0; k<N; k++)
				{
					rx = j;
					ry = k;
					
					while(true) 
					{
							if(0<=rx+dx[0] && rx+dx[0]<N && 0<=ry+dy[0] && ry+dy[0]<N && room[rx][ry]+1 == room[rx+dx[0]][ry+dy[0]]) 
							{
									count[j][k] += 1;
									rx = rx+dx[0];
									ry = ry+dy[0];
							}
							else if(0<=rx+dx[1] && rx+dx[1]<N && 0<=ry+dy[1] && ry+dy[1]<N && room[rx][ry]+1 == room[rx+dx[1]][ry+dy[1]])
							{
									count[j][k] += 1;
									rx = rx+dx[1];
									ry = ry+dy[1];
							}
							else if(0<=rx+dx[2] && rx+dx[2]<N && 0<=ry+dy[2] && ry+dy[2]<N && room[rx][ry]+1 == room[rx+dx[2]][ry+dy[2]])
							{
									count[j][k] += 1;
									rx = rx+dx[2];
									ry = ry+dy[2];
							}
							else if(0<=rx+dx[3] && rx+dx[3]<N && 0<=ry+dy[3] && ry+dy[3]<N && room[rx][ry]+1 == room[rx+dx[3]][ry+dy[3]])
							{
									count[j][k] += 1;
									rx = rx+dx[3];
									ry = ry+dy[3];
							}
							else 
							{
								break;
							}
					}
					
				}
			}//방 순회하기
			
			int max = 0;
			int maxNum = N*N+1;
			
			for(int j=0; j<N; j++) 
			{
				for(int k=0; k<N; k++)
				{
					if(max < count[j][k]) {
						max = count[j][k];
						maxNum = room[j][k];
					}else if(max == count[j][k] && maxNum > room[j][k])
					{
						 maxNum = room[j][k];
						 max = count[j][k];
					}
				}
			}
			
			System.out.println("#"+(i+1)+" "+maxNum+" "+(max+1));
			
		}//테스트케이스 반복
		
	}
}
