package com.ustc.zwxu.arithmetic.dynamic;

import java.util.Scanner;

import com.ustc.zwxu.interview.Main;

public class HeChangDuiDemo {

	/**
	 * 本题参考最长递增子序列
	 */
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);        
		int N=scanner.nextInt();       
		int[] height=new int[N];        
		for (int i = 0; i < N; i++) 
		{            
			height[i]=scanner.nextInt();       
		}        
       
		int[] arrayLenUp= list(height);  
		int[] arrayLenDown= list(reverse(height));
		int max=2;
		int temp;
		for (int i = 0; i < N; i++) { //对应求和找到最大的那个           
			temp=arrayLenUp[i]+arrayLenDown[N-1-i];           
			if (temp>max) 
			{                
				max=temp;            
			}        
		}     
		System.out.println(N-max+1);
	}
	
	public static int[] reverse(int[] arrayIn){ ////获取最长递减子序列并把它们保存在数组arrayLen中        
		int[] arrayReverse=new int[arrayIn.length];               
		for (int i = 0; i < arrayReverse.length; i++) 
		{       
				arrayReverse[i]=arrayIn[arrayIn.length-1-i];        
		}        
		 
		return arrayReverse;    
	}
	
	public static int[] list(int[] arr)
	{
		int n = arr.length;
		int[] arrLen = new int[n];
		
		int[] b =new int[n+1];
		b[0] = -10000;
		b[1]=arr[0];
		int len = 1;
		int p,r,m;
		for(int i=1;i<n;i++)
		{
			p=0;r=len;
			while(p<=r)
			{
				m=(p+r)/2;
				if(b[m] < arr[i])
					p =m+1;
				else
					r=m-1;
			}
			b[p]=arr[i];
			if(p>len) len=p;
			arrLen[i]=len;
		}
		return arrLen;
	}

}
