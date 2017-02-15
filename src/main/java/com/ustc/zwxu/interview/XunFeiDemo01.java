package com.ustc.zwxu.interview;

public class XunFeiDemo01 {
	public static int Fibonacci(int n) {
		if(n<=0)
			return 0;
		if(n==1)
			return 1;
		int a=0;
		int b=1;
		int res=0;
		while(n>1)
		{
			res=a+b;
			a=b;
			b=res;
			n--;
		}
		return res;

    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(Fibonacci(2));
	}

}
