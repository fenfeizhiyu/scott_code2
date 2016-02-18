package sk.test.join;

public class StaticResource {

	private static int total=100;
	
	
	
	public void  add(int n)
	{
		total=total+n;
	}
	
	
	public void desc(int n)
	{
		total=total-n;
	}
	
	public void reset(int num)
	{
		total=num;
	}
	
	public int getTotal()
	{
		return total;
	}
}
