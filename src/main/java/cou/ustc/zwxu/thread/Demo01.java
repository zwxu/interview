package cou.ustc.zwxu.thread;

/*
 * 交替输出奇数和偶数
 */

public class Demo01 {

	private static Object lock = new Object();
	private static boolean flag =false;
	private static int i=1;
	public static void main(String[] args) {
		Thread b = new Thread(){
			public void run(){
				while(i<100)
				{
					synchronized(lock)
					{
						if(flag)
						{
							try{lock.wait();}
							catch(Exception e){e.printStackTrace();};
						}
						else
						{
							System.out.println("奇数："+i);
							i++;
							flag=true;
							lock.notify();
						}
					}
				}
			}
		};
		Thread a = new Thread(){
			public void run(){
				while(i<100)
				{
					synchronized(lock)
					{
						if(!flag)
						{
							try{lock.wait();}
							catch(Exception e){e.printStackTrace();};
						}
						else
						{
							System.out.println("偶数："+i);
							i++;
							flag=false;
							lock.notify();
						}
					}
				}
			}
		};
		a.start();
		b.start();
	}

}
