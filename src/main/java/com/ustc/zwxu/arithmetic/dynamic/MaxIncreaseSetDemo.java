package com.ustc.zwxu.arithmetic.dynamic;

public class MaxIncreaseSetDemo {

	
	public static void list1(int[] arr)
	{
		int n =arr.length;
		int[] f=new int[n];
		f[0]=1;
		for(int i=1;i<n;i++)
		{
			f[i]=1;
			for(int j=0;j<i;j++)
			{
				if(arr[j] < arr[i] && f[j] > f[i]-1)
					f[i]=f[j]+1;
			}
		}
		System.out.println(f[n-1]);
	}

	public static void list(int[] arr)
	{
		int n = arr.length;
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
		}
		System.out.println(len);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array =new int[]{6,3,4,7,1,5,6};
		list(array);
		//list1(array);
		//System.out.print(lis(array));
	}

}
