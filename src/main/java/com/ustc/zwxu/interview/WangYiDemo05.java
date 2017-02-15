package com.ustc.zwxu.interview;

import java.util.Scanner;


public class WangYiDemo05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		//System.out.println(rev(100));
		System.out.println(rev(rev(x)+rev(y)));
	}
	
	
	
	private static int rev(int n)
	{
		int t=0;
		while(n > 0)
		{
			t=t*10+n%10;
			n=n/10;
		}
		return t;
	}
}