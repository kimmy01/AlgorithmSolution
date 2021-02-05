package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main_BJ_17478_재귀함수가뭔가요 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int T = Integer.parseInt(str);
		function(T);

	}

	static int count = 0;
	static String underBar = "";

	public static void function(int num) {

		ArrayList<String> array = new ArrayList();

		array.add("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		array.add("\"재귀함수가 뭔가요?\"\n");
		array.add("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		array.add("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		array.add("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		array.add("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
		array.add("라고 답변하였지.\n");

		if (count == 0) {
			System.out.print(array.get(0));
			for (int j = 1; j < array.size() - 2; j++) {
				System.out.print(array.get(j));
			}
		} else {
			for (int j = 1; j < array.size() - 2; j++) {
				System.out.print(underBar);
				System.out.print(array.get(j));
			}
		}

		if (num == 1) {
			underBar += "____";
			System.out.print(underBar);
			System.out.print(array.get(1));
			System.out.print(underBar);
			System.out.print(array.get(5));
			System.out.print(underBar);
			System.out.print(array.get(6));

			for (int i = count; i >= 0; i--) {
				underBar = underBar.substring(0, underBar.length() - 4);
				System.out.print(underBar);
				System.out.print(array.get(6));
			}
			return;
		}
		count++;
		underBar += "____";
		function(num - 1);
	}
}
