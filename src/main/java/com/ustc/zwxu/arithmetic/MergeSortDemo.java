package com.ustc.zwxu.arithmetic;

public class MergeSortDemo {
	//两个数组合并为一个数组
	private void merge(int a[],int start,int mid,int end)
	{
		int n1 = mid-start+1;
		int n2 = end-mid;
		int left[] = new int[n1];
		int right[] = new int[n2] ;
		int i,j,k;
		//初始化左数组
		for(i=0;i<n1;i++)
			left[i]=a[start+i];
		//初始化右数组
		for(j=0;j<n2;j++)
			right[j]=a[mid+1+j];
		i=j=0;
		k=start;
		while(i< n1 && j<n2)
		{
			if(left[i] < right[j])
				a[k++]=left[i++];
			else
				a[k++]=right[j++];
		}
		//如果左数组长度大于右数组
		while(i<n1)
			a[k++]=left[i++];
		//如果右数组长度大于左数组
		while(j<n2)
			a[k++]=right[j++];
			
		
		
	}
	private void merge_sort(int a[],int start,int end)
	{
		int mid;
		if(start < end)
		{
			mid = (start+end)/2;
			merge_sort(a,start,mid);
			merge_sort(a,mid+1,end);
			merge(a,start,mid,end);
		}
		
	}
	public static void main(String[] args) {
        MergeSortDemo d= new MergeSortDemo();
        int a[] ={5,2,4,7,1,3,5,9,1,0};
        d.merge_sort(a, 0, a.length-1);
        for(int i:a)
        {
        	System.out.print(i+"--");
        }
		
		
}
}
