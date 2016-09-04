package com.ustc.zwxu.arithmetic;

import java.util.Random;

public class QuickSortDemo {
	private int partition(int[] a,int p,int r){
		int i=p-1;
		int x=a[r];
		int temp;
		for(int j=p;j<r;j++){
			if(a[j] <=x)
			{
				i=i+1;
				temp=a[j];
				a[j]=a[i];
				a[i]=temp;
			}		
		}
		temp=a[r];
		a[r]=a[i+1];
		a[i+1]=temp;
		return i+1;
		
	}
	private void quicksort(int a[],int p,int r){
		if(p<r){
			//以此数划分为两个数组,此时越有序，划分效果月差，复杂度为O(n2)
			int q=partition(a,p,r);
			quicksort(a,p,q-1);
			quicksort(a,q+1,r);
		}	
	}
	public static void main(String[] args) {
       int[] a = {1,3,6,4,7};
   
		QuickSortDemo d= new QuickSortDemo();
		d.quicksort(a,0,a.length-1);
		for(int i:a)
        {
        	System.out.print(i+"--");
        }
}
}
