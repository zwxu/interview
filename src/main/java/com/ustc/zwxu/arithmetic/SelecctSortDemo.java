package com.ustc.zwxu.arithmetic;


//移动次数为n，比较次数为n2
public class SelecctSortDemo {
	//最坏情况为O(n2)
	private void selectsort(int a[]){
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
       int[] a = {3,4,7,5,1};
   
		SelecctSortDemo d= new SelecctSortDemo();
		d.selectsort(a);
		for(int i:a)
        {
        	System.out.print(i+"--");
        }
}
}
