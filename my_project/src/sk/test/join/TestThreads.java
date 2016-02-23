package sk.test.join;

public class TestThreads {

	private Thread[] thds;
	
	public TestThreads(int num)
	{
		thds=new Thread[num];
		for(int i=0;i<num;i++)
		{
			thds[i]=new Thread("test"+(i+1));
		}
	}
	
	public Thread[] getAllThreads()
	{
		return thds;
	}
	
	/**
	 * index>=1
	 * @param index
	 * @return
	 */
	public Thread getThread(int index)
	{
		if(index>=1&&index<=thds.length)
			return thds[index-1];
		else
			return null;
	}
}
