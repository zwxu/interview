package com.ustc.zwxu.arithmetic.sort;

/**
 * 以增序为例
 * 以最后一个数为基准，依次和0~n-1的比大小
 */
public class InsertSortDemo {

	public static void insertSort(int a[])
	{

		for(int i=1;i<a.length;i++)
		{
			int rear = a[i];
			int j=i-1;
			while(rear < a[j] && j>-1)
			{
				//往后移动	,且自减
				a[j+1]=a[j];
				j--;
			}
		
			//以最后一个数为基准，并0~n-1中比它小的数,交换位置
			a[j+1]=rear;
	
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,4,7,5,1};
		insertSort(a);
		for(int i:a)
		{
			System.out.print(i+">>");
		}
	}

}
