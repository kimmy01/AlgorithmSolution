package day0217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 치킨집의 위치(2)를 배열에 저장 OK
 * 치킨집 개수 Combination M 조합 구하기 OK
 * 각 조합 별로 배열 생성해서 그 때의 치킨 거리 구하기
 * 도시 전체의 치킨 거리 저장하고 비교해서 값 갱신하기
 * */

public class Main_BOJ_15686_치킨배달 {
	static int N;
	static int M;
	static int min = Integer.MAX_VALUE; //출력할 변수
	static int[][] res; //조합결과 저장
	static ArrayList<int[]> home;
	static ArrayList<int[]> chicken;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		res = new int[M][2];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				int a = Integer.parseInt(stk.nextToken());
				if(a == 2) {
					chicken.add(new int[] {i, j});
				}else if(a == 1) {
					home.add(new int[] {i, j});
				}
			}
		}//입력
		makeCombination(0, res, 0);
		System.out.println(min);
	}
	static void makeCombination(int n, int[][] res, int k) { //n은 치킨집 개수까지 증가, k는 M까지 증가
		if(k==M) {
			min = Math.min(chickenDistance(res), min); //도시의 최소 치킨거리 갱신
			return;
		}
		if(n==chicken.size()) return;
		res[k][0]=chicken.get(n)[0]; //치킨집x
		res[k][1]=chicken.get(n)[1]; //치킨집y
		makeCombination(n+1, res, k+1);
		makeCombination(n+1, res, k);
	}
	
	static int chickenDistance(int[][] res) {
		int cityChickenDistance = 0; //도시 전체 치킨 거리
		for(int i=0; i<home.size(); i++) {
			int minDis = Integer.MAX_VALUE; //한 집의 치킨 거리
			for(int j=0; j<res.length; j++) {
				minDis = Math.min(minDis, Math.abs(home.get(i)[0]-res[j][0])+Math.abs(home.get(i)[1]-res[j][1])); //현재 최소거리와 새로 구한 거리 비교하여 최소값 저장
			}
			cityChickenDistance += minDis; //갱신된 최소 거리를 도시 전체 치킨 거리에 추가
		}
		return cityChickenDistance;
	}
}
