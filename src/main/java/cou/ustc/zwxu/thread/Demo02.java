package cou.ustc.zwxu.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

class Something
{
	public  static synchronized void syncA()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String time=sdf.format(new Date());
    	System.out.println(Thread.currentThread().getName()+" say A :"+"  execute time is "+time);
    	try{ Thread.sleep(1000);}
  	   catch(Exception e){e.printStackTrace();}	
	}
	public  synchronized void syncB()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String time=sdf.format(new Date());
    	System.out.println(Thread.currentThread().getName()+" say B :"+"  execute time is "+time);
    	try{ Thread.sleep(1000);}
  	   catch(Exception e){e.printStackTrace();}
	}
}

class MyThread extends Thread
{
	private Something sth;
	public MyThread(Something sth) {
		super();
		this.sth = sth;
	}
	public void run()
	{
		sth.syncA();
	}
}

class CopyMyThread extends Thread
{
	private Something sth;
	public CopyMyThread(Something sth) {
		super();
		this.sth = sth;
	}
	public void run()
	{
		sth.syncB();
	}
}
/*
 *一个以上线程是否同时执行 
 */
public class Demo02 {
	public static void main(String[] args) {
		Something s1= new Something();
		Something s2= new Something();
		MyThread m1= new MyThread(s1);
		MyThread m2= new MyThread(s2);
		
		m1.start();
		m2.start();
	}

}
