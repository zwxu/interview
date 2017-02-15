package com.ustc.zwxu.arithmetic;


//移动和比较次数都是n2
public class BubbleSortDemo {

	private void bubblesort(int a[]){
		int i,j;
		int temp;
		boolean flag;

		for(i=0;i<a.length;i++)
		{
			flag=false;
			for(j=0;j<a.length-i-1;j++)
			//for(j=i+1;j<a.length;j++)
			{
		
				//冒泡排序  最好情况时只需要比较n次O(n)
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
       int[] a = {1,9,6,4,7};
   
		BubbleSortDemo d= new BubbleSortDemo();
		d.bubblesort(a);
		for(int i:a)
        {
        	System.out.print(i+"--");
        }
}
}
