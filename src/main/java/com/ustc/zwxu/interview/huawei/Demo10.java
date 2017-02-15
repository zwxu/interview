/*package com.ustc.zwxu.interview.huawei;

import java.util.Scanner;

public class Demo10 {

	*//**
	 * 多线程
	 *//*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//华为笔试标准格式
		int n = scanner.nextInt();
		MyThread o1 = new MyThread('A',n);
		o1.start();
		MyThread o2 = new MyThread('B');
		o2.start();
		MyThread o3 = new MyThread('C');
		o3.start();
		MyThread o4 = new MyThread('D');
		o4.start();
		
		
		
	}

}

class MyThread extends Thread
{
	public char c;
	public static int n;
	public static Object lock = new Object();
	public static char start = 'A';
	public MyThread(char c) {
		super();
		this.c = c;
	}
	public MyThread(char c, int n) {
		super();
		this.c = c;
		this.n = n;
	}
	
	public void run()
	{
		for(int i=0;i<n;i++)
		{
			print();
		}
	}
	
	public void print()
	{
		while(start != c)
		{
			
		}
		
		synchronized(lock)
		{
			System.out.print(c);
			start += 1;
			if(start == 'E')
			{
				start= 'A';
			}
		}
	}
}


	

*/