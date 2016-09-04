package com.ustc.zwxu.arithmetic;



public class BubbleSortDemo {

	private void bubblesort(int a[]){
		int i,j;
		int temp;
		boolean flag;

		for(i=0;i<a.length;i++)
		{
			flag=false;
			for(j=0;j<a.length-i-1;j++)
			{
		
				//冒泡排序  最好情况为O(n)
				if(a[j] > a[j+1])
				{
					temp=a[j+1];
				    a[j+1]=a[j];
				    a[j]=temp;
				    flag=true;
				}
					
			}
			if(flag==false)
				return;
			
			
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
