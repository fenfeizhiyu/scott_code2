package com.thread.test;

public class TMain {

	public static void main(String[] args) {
	
		
		Thread th=new Thread(new Test1());
		Thread th2=new Thread(new Test1());
		
		th.start();
		th2.start();
		
	}
	

}
