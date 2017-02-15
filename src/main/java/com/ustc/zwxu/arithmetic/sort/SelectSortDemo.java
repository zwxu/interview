package com.ustc.zwxu.arithmetic.sort;

/**
 * 以增序为例
 * 每一次选出一个最小的
 */
public class SelectSortDemo {

	public static void selectSort(int a[])
	{
		for(int i=0;i<a.length;i++)
		{
			int min = i;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[min] > a[j])
				{
					int temp=a[min];
					a[min]=a[j];
					a[j]=temp;
				}
				
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,4,7,5,1};
		selectSort(a);
		for(int i:a)
		{
			System.out.print(i+">>");
		}
	}

}
