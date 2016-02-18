package sk.test.join;

import java.util.ArrayList;
import java.util.List;

public class SubWork implements WorkRunnable{

	List<Integer> result=new ArrayList<Integer>();
	@Override
	public void run() {
		List<Integer> resList=new ArrayList<Integer>();
		while(sc.isFlag())
		{
			result.add(sr.getTotal());
			sr.desc(1);
		}
		try {
			Thread.currentThread().wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Integer res:result)
		{
			System.out.println(Thread.currentThread().getName()+"result");
			System.out.println(res+" | ");
		}
	}

}
