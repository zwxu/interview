package com.ustc.zwxu.interview;

import java.util.Scanner;


public class WangYiDemo02 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			int n = sc.nextInt();
			
			System.out.println(solve(n));
		}
		sc.close();
	}

	private static int solve(int n) {
		int count = 0;
		int number = (int) Math.sqrt(n);
		for(int i=0;i<=number;i++)
		{
			int temp = (int) Math.pow(i, 2);
			double another = Math.sqrt(n-temp);
			if(another % 1.0 ==0)
			{
				if(i==0 || another==0.0)
				{
					count=count+2;
				}
				else
				{
					count=count+4;
				}
			}
			


		}
		return count;
	}
	
	
	
}
