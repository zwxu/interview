package com.ustc.zwxu.arithmetic.sort;

/**
 * 以增序为例
 * 每一次冒出一个最大的数
 */
public class BubbleSortDemo {
	//冒泡排序  最好情况时只需要比较n次O(n)
	public static void bubbleSort(int a[])
	{
		for(int i=0;i<a.length;i++)
		{
			boolean flag = true;//原始状态有序为true
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i] > a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
					flag=false;
				}
				
			}
			if(flag == true)
			{
				break;
			}
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {7,6,5,6,7};
		bubbleSort(a);
		for(int i:a)
		{
			System.out.print(i+">>");
		}
	}

}
