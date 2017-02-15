package cou.ustc.zwxu.thread;

class ThreadJoin implements Runnable
{
	Thread one,two;
	private static int sum;
	ThreadJoin(){
		one = new Thread(this);
		two = new Thread(this);
	}
	public void run() {
		if(Thread.currentThread() == one)
		{
			
			try{ 
				two.start();
				two.join();
			}
			catch(Exception e)
			{e.printStackTrace();}
			for(int i=5;i<=10;i++)
			{
				sum+=i;
			}
			System.out.println(sum);
		}
		else if(Thread.currentThread() == two)
		{
			for(int i=0;i<5;i++)
			{
				sum+=i;
			}
			System.out.println("two first: "+sum);
			/*try{ 
				
			}
			catch(Exception e)
			{e.printStackTrace();}*/
		}
		
	}
}

public class Demo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadJoin a = new ThreadJoin();
		a.one.start();
		Long l = 42l;
		Double d = 42.0;
		System.out.print(l.equals(d));
	}

}
