package com.ustc.zwxu.offer;

/*
 * 剑指offer 斐波那契数列
 */
public class Demo09 {
	private static int fib(int n)
	{
		if(n==1 || n==2)
		{
			return n;
		}
		return fib(n-1)+fib(n-2);
		
	}
	
	private static int fib2(int n)
	{
		if(n==1 || n==2)
		{
			return n;
		}
		int a=1;
		int b=2;
		int c=1;
		for(int i=3;i<=n;i++)
		{
			c=a+b;
			a=b;
			b=c;
		}
		return c;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = fib(9);
		int b = fib2(9);
		System.out.println(a);
		System.out.print(b);
	}

}
