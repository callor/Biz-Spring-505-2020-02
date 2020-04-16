package com.biz.sec;

public class Main_02 {

	public static void main(String[] args) {
		Test test = new Test();
		System.out.println(test.addr);
		sub(test);
		System.out.println(test.addr);
		
		int[] num = new int[5];
		sub(num);
		System.out.println(num[3]);
		
		
		
	}
	
	public static void sub(int[] num) {
		num[3] = 100;
	}
	
	public static void sub(Test t1) {
		t1.addr = "광주광역시";
	}
	
}


class Test {
	
	String name;
	String addr;
	String phone;
	
}
