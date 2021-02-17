package day0217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 1. map[N+1][M] 배열에 N*M만큼 입력 받고 N+1행은 0으로 채우기, ArrayList에 적의 위치 저장하기 OK
 * 2. 궁수를 세울 수 있는 조합(MC3)메소드 만들기 OK
 * 3. 궁수의 조합이 하나 만들어졌을 때, ArrayList의 적과 궁수A, B, C의 위치를 비교하기
 * 3-1. 먼저 적과 궁수의 위치가 D보다 작거나 같은지 확인
 * 3-2. 적과 궁수의 거리와 기존에 선택된 적(temp)과의 거리를 비교하여 더 작은 거리를 temp에 넣기
 * 3-3. 해당 적의 위치를 (Ax, Ay), (Bx, By), (Cx, Cy)로 저장하기
 * 3-4. 두 적과의 거리가 동일하다면 Ay, By, Cy가 더 작은 적으로 선택하여 저장하기
 * 4. 최종으로 선택된 적의 위치에 값을 0으로 갱신하기
 * 4-1. 다른 궁수끼리 같은 적을 겨냥할 수 있으므로, (Ax==Bx && Ay==By) || (Cx==Ax && Cy==Ay) 체크 (그 아래 B궁수도 체크)
 * 4-2. 다른 궁수끼리 모두 다른 적을 겨냥하면 count+=3, 같은 적을 겨냥한다면 count에서 제외하고 count 추가
 * 5. 턴이 끝나면 모든 적들의 x값을 +1 해주는데, N-1인덱스의 값은 모두 0으로 바꿔주고(성과 가장 인접한 행), N-1인덱스 이하까지만 +1해주기
 * 6. map[N][M]을 탐색해서 1인 값이 존재하지 않을 때까지 위 과정 반복
 * */
public class Main_BOJ_17135_캐슬디펜스 {
	static int N;
	static int M;
	static int D;
	static int[] res = new int[3];
	static ArrayList<int[]> enemy;
//	static int[] Marr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		D = Integer.parseInt(stk.nextToken());
		int[][]map = new int[N+1][M];
		enemy = new ArrayList<>();
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if(map[i][j] == 1) enemy.add(new int[] {i, j});
			}
		}//입력
//		Marr = new int[M];
//		for(int i=0; i<M; i++) {
//			Marr[i] = i;
//		}
	}
	
	static void select(int n, int k, int[]res) {
		if(k==3) {
			distance(0);
			distance(1);
			distance(2);
			return;
		}
		if(n==M) return;
//		res[k] = Marr[n];
		res[k] = n;
		select(n+1, k+1, res);
		select(n+1, k, res);
	}
	
	static void distance(int num) {
		for(int i=0; i<enemy.size(); i++) {
			
		}
	}
}
