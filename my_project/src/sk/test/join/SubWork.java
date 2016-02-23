package sk.test.join;

import java.util.ArrayList;
import java.util.List;

public class SubWork implements ShareSpace{

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
			//线程等待直到被唤醒
			Thread.currentThread().wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(Integer res:result)
		{
			System.out.println(Thread.currentThread().getName()+"result");
			System.out.println(res+" | ");
		}
	}

}
