package com.biz.bbs;

public class Main3 {
	public static void main(String[] args) {
		
		int sum = add(100);
		System.out.println(sum);
		
	}
	
	public static int add(int num) {
		if(num < 1) return 0;
		return num + add(num-1);
	}
}
