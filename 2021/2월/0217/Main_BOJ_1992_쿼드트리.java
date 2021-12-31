package day0217;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1992_쿼드트리 {
	static int[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = input.charAt(j)-'0';
			}		
		}//입력
		quadtree(N, 0, 0);
		System.out.println(sb.toString());
	}
	static void quadtree(int n, int x, int y) {
		if(n==1) {
			sb.append(map[x][y]);
			return;
		}
		int a = map[x][y];
		boolean same = true;
		int flag = 0;
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(map[i][j] != a) {
					same = false;
					flag = 1;
					break;
				}
				if(flag == 1) break;
			}
		}
		if(same == true) {
			sb.append(a);
			return;
		}
		int half = n/2;
		sb.append("(");
		quadtree(half, x, y);
		quadtree(half, x, y+half);
		quadtree(half, x+half, y);
		quadtree(half, x+half, y+half);
		sb.append(")");
	}
}

/* 파라미터로 x좌표, y좌표, n받기 (제일 처음 main에서 호출했을 때는 0,0,N)
 * <기저조건>
 * n이 1이 되면(가장 작은 단위) 같이 넘어온 x,y좌표에 해당하는 값을 sb에 붙이기
 * 시작하는 값(a)에는 (0,0)의 값 넣어주기
 * a와 비교해서 같은 지 체크하는 boolean 변수
 * i가 x부터 x+n까지 순회, j가 y부터 y+n까지 순회
 * map[i][j]가 a와 같은지 비교 -> 다르면 boolean 변수에 false 넣고 for문 종료
 * for문 빠져나온 뒤, same이 true일 때, a를 sb에 붙이고 return
 * 재귀 돌리기 위한 half: 큰 map에서부터 작은 map으로 쪼개서 넘어가기 때문에 n/2을 넣음
 * 쿼드트리의 (0,0) -> (0,1) -> (1,0) -> (1,1)에 해당하도록 재귀 함수 돌리기
 * */