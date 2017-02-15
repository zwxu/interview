package com.ustc.zwxu.arithmetic.sort;

/**
 * 以增序为例
 * 先分两个数组，排序好后，合并两个数组
 */
public class MergeSortDemo {

	public static void mergeSort(int a[],int start,int end)
	{
		if(start<end){
			int mid = (start+end)/2;
			mergeSort(a,start,mid);
			mergeSort(a,mid+1,end);
			merge(a,start,mid,end);

		}	

		
	}
	
	private static void merge(int[] a, int start, int mid,int end) {
		int[] left = new int[mid-start+1];
		int[] right = new int[end-mid];
		
		for(int i=0;i<left.length;i++)
		{
			left[i]=a[start+i];
		}
		for(int j=0;j<right.length;j++)
		{
			right[j]=a[mid+1+j];
		}
		int i,j,k;
		i=j=0;
		k=start;
		while(i < left.length && j< right.length)
		{
			if(left[i] < right[j])
			{
				a[k++]=left[i++];
			}
			else
			{
				a[k++]=right[j++];
			}
		}
		
		while(i<left.length)
			a[k++]=left[i++];
		while(j<right.length)
			a[k++]=right[j++];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,3,4,7,1,5};
		mergeSort(a,0,a.length-1);
		for(int i:a)
		{
			System.out.print(i+">>");
		}
	}

}
