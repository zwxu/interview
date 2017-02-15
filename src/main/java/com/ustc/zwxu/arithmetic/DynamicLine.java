package com.ustc.zwxu.arithmetic;

public class DynamicLine {
	private int line1[];
	private int line2[];
	private int f;
	private int ln;
	
	public DynamicLine(int n)
	{
		line1 = new int[n];
		line2 = new int[n];		
	}
	
	private  int fastway(int a[][],int t[][],int e1,int e2,int x1,int x2,int n)
	{
		int f1[] = new int[n];
		int f2[] = new int[n];
		f1[0]=e1+a[0][0];
		f2[0]=e2+a[1][0];
		for(int j=1;j<n;j++)
		{
			//a 装配站
			if(f1[j-1]+a[0][j] <=f2[j-1]+t[1][j-1]+a[0][j])
			{
				f1[j]=f1[j-1]+a[0][j];
				line1[j]=1;
			}
			else
			{
				f1[j]=f2[j-1]+t[1][j-1]+a[0][j];
				line1[j]=2;
			}
			if(f2[j-1]+a[1][j] <=f1[j-1]+t[0][j-1]+a[1][j])
			{
				f2[j]=f2[j-1]+a[1][j];
				line2[j]=2;
			}
			else
			{
				f2[j]=f1[j-1]+t[0][j-1]+a[1][j];
				line2[j]=1;
			}
		}
		if(f1[n-1] + x1 <= f2[n-1] + x2)  
	    {  
	        f = f1[n-1] + x1;  
	        ln = 1;  
	    }  
	    else  
	    {  
	        f = f2[n-1] + x2;  
	        ln = 2;  
	    }  
		return f;
	}
	
	private void print(int n)
	{
		int i= ln;  
		//出去的那一站
		System.out.println("line:"+i+",station："+(n-1));
	    for(int j=n-1; j>=1; --j)  
	    {  
	        if(i == 1)  
	            i = line1[j];  
	        else  
	            i = line2[j];  
	        System.out.println("line:"+i+",station："+(j-1));
	    }  
	}
	
	public static void main(String[] args) { 
		int a[][]={{7,9,3,4,8,4},{8,5,6,4,5,7}};
		int t[][]={{2,3,1,3,4},{2,1,2,2,1}};
		int e1=2;
		int e2=4;
		int x1=3;
		int x2=2;
		int n=6;
		DynamicLine dl = new DynamicLine(n);
		int f =dl.fastway(a, t, e1, e2, x1, x2, n);
		dl.print(n);
		System.out.println("short distance:"+f);

	    }  
	}  
