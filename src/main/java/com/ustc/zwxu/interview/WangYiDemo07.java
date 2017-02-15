package com.ustc.zwxu.interview;


import java.util.Scanner;


public class WangYiDemo07 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(solve1(n));

	}



	public static int solve1(int n) {
		if(n%8 == 0) return n/8;
		if(n == 6) return 1;
		int rloop = n/8;
		
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=rloop;i++)
		{
			int left = n-8*i;
			if(left%6 == 0)
			{
				min = Math.min(min, left/6+i);
			}
			
		}
		
		if(min != Integer.MAX_VALUE)
		{
			return min;
		}
		
		return -1;
	}
}
