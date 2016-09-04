package com.ustc.zwxu.arithmetic;



public class BubbleSortDemo {

	private void bubblesort(int a[]){
		int i,j;
		int temp;
		int min;
		for(i=0;i<a.length;i++)
		{
			min = i;
			for(j=i+1;j<a.length;j++)
			{
				if(a[min] > a[j])
				{
					min=j;
				}
				//冒泡排序
				/*if(a[i] > a[j])
				{
					temp=a[i];
				    a[i]=a[j];
				    a[j]=temp;
				}*/
					
			}
			if(min !=i)
			{
				temp=a[i];
			    a[i]=a[min];
			    a[min]=temp;
			}
		}
		
		
	}
	public static void main(String[] args) {
       int[] a = {1,3,6,4,7};
   
		BubbleSortDemo d= new BubbleSortDemo();
		d.bubblesort(a);
		for(int i:a)
        {
        	System.out.print(i+"--");
        }
}
}
