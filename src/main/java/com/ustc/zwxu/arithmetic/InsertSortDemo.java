package com.ustc.zwxu.arithmetic;


//移动和比较次数都是n2
public class InsertSortDemo {
	
	private void insertsort(int a[]){
		int i,j,key;
		for(j=1;j<a.length;j++)
		{
			key=a[j];
			i=j-1;
			//数组越有序移动次数越少
			while(i>-1 && a[i]>key)
			{
				a[i+1]=a[i];
				i=i-1;
			}

			a[i+1]=key;
			
		}
	}
	public static void main(String[] args) {
       int[] a = {5,1,2,3,4};
   
		InsertSortDemo d= new InsertSortDemo();
		d.insertsort(a);
		for(int i:a)
        {
        	System.out.print(i+"--");
        }
}
}
