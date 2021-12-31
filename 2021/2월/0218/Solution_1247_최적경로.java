package day0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {
	static int min, N, officeX, officeY, homeX, homeY;
	static int[][] res;
	static int[][] client;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			client = new int[N][2];
			res = new int[N+2][2];
			visited = new boolean[N];
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			res[0][0] = Integer.parseInt(stk.nextToken());
			res[0][1]= Integer.parseInt(stk.nextToken());
			res[N+1][0] = Integer.parseInt(stk.nextToken());
			res[N+1][1] =  Integer.parseInt(stk.nextToken());
//			officeX = Integer.parseInt(stk.nextToken()); //큐 사용
//			officeY= Integer.parseInt(stk.nextToken());
//			homeX = Integer.parseInt(stk.nextToken());
//			homeY =  Integer.parseInt(stk.nextToken());
			for(int i=0; i<N; i++) {
				client[i][0] = Integer.parseInt(stk.nextToken());
				client[i][1] = Integer.parseInt(stk.nextToken());
			}
			Perm(0, res, visited);
			System.out.println("#"+t+" "+min);
		}
	}
	static void Perm(int n, int[][]res, boolean[]visited) {
		if(n==res.length-2) {
			distance();
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				res[n+1][0]=client[i][0];
				res[n+1][1]=client[i][1];
				Perm(n+1, res, visited);
				visited[i]=false;
			}
		}
	}
	static void distance() {
		int d = 0;
		for(int i=0; i<res.length-1; i++) {
			d += Math.abs(res[i][0]-res[i+1][0])+Math.abs(res[i][1]-res[i+1][1]);
		}
		min = Math.min(min, d);
			
//		Queue<int[]> queue = new LinkedList<>(); //큐 사용
//		queue.offer(new int[] {officeX, officeY});
//		for(int i=0; i<N; i++) {
//			queue.offer(new int[] {res[i][0], res[i][1]});
//		}
//		queue.offer(new int[] {homeX, homeY});
//		int[] a = queue.poll();
//		while(!queue.isEmpty()) {
//			int[] b = queue.poll();
//			d += Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
//			a = b;
//		}
//		min = Math.min(min, d);
	}
}
