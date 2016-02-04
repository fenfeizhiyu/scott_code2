package com.thread.test;

public class Resource {

	private volatile static int calc=0;
	
	
	public static void addCalc()
	{
		calc++;
		System.out.println(Thread.currentThread().getName()+"add:"+calc);
	}
	
	public static void delCala()
	{
		calc--;
		System.out.println(Thread.currentThread().getName()+"del:"+calc);
	}
}
