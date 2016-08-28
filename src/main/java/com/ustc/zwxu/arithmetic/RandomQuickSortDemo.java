package com.ustc.zwxu.arithmetic;
public class RandomQuickSortDemo {
	public static int randomedPartition(int[] a,int p,int r){
		int ram= (int)(Math.random()*(r - p + 1)) + p;//取随机主元
		int k;
		k=a[ram];
		a[ram]=a[r];
		a[r]=k;
		return partition(a,p,r);	
	}
	public static int partition(int[] a,int p,int r){
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
	public static void quicksort(int a[],int p,int r){
		if(p<r){
			int q=randomedPartition(a,p,r);//1
			quicksort(a,p,q-1);//递归的时候把方法调用存在堆栈里
			quicksort(a,q+1,r);
		}	
	}
	public static void main(String[] args) {
		int[] a = new int[100000];
        for (int i = 0; i < 100000; i++) {
            a[i] = (int)(Math.random()*500);
        }
		long start=System.currentTimeMillis();
		quicksort(a,0,a.length-1);
		long end=System.currentTimeMillis();
		for(int i=0;i<a.length;i++){
			if(i%100==0)
			{
				System.out.println(" ");
			}
			System.out.print(a[i]+" ");
		}
		System.out.println("");
		System.out.print("total time:"+(end-start)+"ms");	
	}
}
