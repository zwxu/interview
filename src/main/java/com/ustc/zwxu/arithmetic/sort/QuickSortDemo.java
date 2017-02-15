package com.ustc.zwxu.arithmetic.sort;

/**
 * 以增序为例
 * 找一个中间位置，左边比它小，右边比它大
 */
public class QuickSortDemo {

	public static void quickSort(int a[],int p,int r)
	{
		if(p<r){
			int q=partition(a,p,r);
			quickSort(a,p,q-1);
			quickSort(a,q+1,r);
		}	

		
	}
	
	private static int partition(int[] a, int p, int r) {
		int rear=a[r];
		int pos=p-1;
		for(int i=p;i<=r;i++)
		{
			
			if(a[i] < rear)
			{
				pos++;
				//保证0~n-1  一半小于一半大于
				int temp=a[i];
				a[i]=a[pos];
				a[pos]=temp;
			}
		}
		int temp=a[r];
		a[r]=a[pos+1];
		a[pos+1]=temp;
		return pos+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,3,4,7,1,5};
		quickSort(a,0,a.length-1);
		for(int i:a)
		{
			System.out.print(i+">>");
		}
	}

}
