package sk.test.join;

public class MainWork implements ShareSpace{

	
	@Override
	public void run() {
	
		boolean f=true;
		while(f)
		{
			f=doCheck();
		}
	}

	private boolean doCheck()
	{
		if(sr.getTotal()>0)
			return true;
		else
			return false;
	}
	
	public void printResult(Thread[] thrs)
	{
		for(Thread t:thrs)
		{
			t.notify();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
