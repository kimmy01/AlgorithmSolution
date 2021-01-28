package com.algo0128;

public class Test {
	long sum(int[] a) {
		long ans = 0;
		int i = 0;
		int len = a.length;
		while(true) {
			ans += a[i];
			i++;
			if(i == len) {
				break;
			}
		}
		return ans;
	}	
}
