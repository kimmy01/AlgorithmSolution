package day0202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_Flatten {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] array = new int[100];
		
		String str;
		StringTokenizer stk; 
		
		for(int repeat=1; repeat<=10; repeat++) {
			String num = br.readLine(); //덤프횟수
			int Num = Integer.parseInt(num);
			str = br.readLine();
			stk = new StringTokenizer(str);
			for(int i=0; i<100; i++) {
				array[i] = Integer.parseInt(stk.nextToken());
			}//입력 받기

			Arrays.sort(array);
			for(int k=0; k<Num; k++) {
				//최대값-최소값의 차이가 1이나 0일 때 종료하기
				if(array[99] - array[0] <=1) {
					System.out.println("#"+repeat+" "+(array[99]-array[0]));
					break;
					
				}else {
					//최대값은 -1, 최소값은 +1
					array[99] -= 1;;
					array[0] += 1;
					Arrays.sort(array);
				}
			}//덤프 종료
			int answer = array[99]-array[0];
			System.out.println("#"+repeat+" "+answer);		
		}//테케 반복
		
	}
}
