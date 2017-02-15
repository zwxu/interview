package com.ustc.zwxu.interview.huawei;

import java.util.Scanner;

public class Demo04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//华为笔试标准格式
		int n = scanner.nextInt();
		getResult(n);
		
		
		
	}
	
	public static void getResult(int n)
	{
		int number[][] = new int[n][n];
		number[0][0]=1;
		for(int i=1;i<n;i++)
		{
			number[i][0]=number[i-1][0]+(i-1)+1;
		}
		
		for(int j=1;j<n;j++)
		{
			for(int i=0;i<n-j;i++)
			{
				number[i][j]=number[i+1][j-1]+1;
			}
		}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-i;j++)
			{
				if(j<n-i-1)
					System.out.print(number[i][j]+" ");
				else
					System.out.print(number[i][j]);
			}
			System.out.println("");
		}
		
	}
}
