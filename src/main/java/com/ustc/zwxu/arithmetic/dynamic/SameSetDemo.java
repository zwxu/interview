package com.ustc.zwxu.arithmetic.dynamic;

public class SameSetDemo {

	/**
	 * 最长公共子序列
	 */
	public static void main(String[] args) {
		String[] x={"","A","B","C","B","D","A","B"};
		String[] y={"","B","D","C","A","B","A"};
		int[][] b = findSameSet(x,y);
		display(b,x,x.length-1,y.length-1);
	}
	//从右下角往上找字符串相同的位置
	public static void display(int[][] set,String[] str,int x,int y)
	{
		if(x == 0 || y == 0)
		{
			return;
		}
		if(set[x][y] == 1)
		{
			display(set,str,x-1,y-1);
			System.out.print(str[x]+" ");
		}
		else if(set[x][y] == 0)
		{
			display(set,str,x-1,y);

		}
		else
		{
			display(set,str,x,y-1);

		}
	}
	
	
	public static int[][] findSameSet(String[] str1,String[] str2)
	{
		int x = str1.length;
		int y = str2.length;
		int[][] c = new int[x][y];
		int[][] b = new int[x][y];//记录出现相同字符串的位置
		for(int i=1;i<x;i++)
		{
			for(int j=1;j<y;j++)
			{
				if(str1[i] == str2[j])
				{
					c[i][j]=c[i-1][j-1]+1;
					b[i][j]=1;
				}
				else if(c[i-1][j] > c[i][j-1])
				{
					c[i][j]=c[i-1][j];
					b[i][j]=0;
				}
				else
				{
					c[i][j]=c[i][j-1];
					b[i][j]=-1;
				}
			}
		}
		return b;
	}

}
