package com.thread.test;

public class Test1 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			Resource.addCalc();
			super.run();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
	


