package com.ustc.zwxu.arithmetic;



public class CopyOfGreedyPart {
	private void sort(int[] w,int[] p)
	{
		
	}
	
	private double pack(int m,int n,int[] w,int[] p)
	{
		double sum=0;
		for(int i=0;i<n;i++)
		{
			if(w[i]< m)
			{
				sum+=p[i];
				m-=w[i];
			}
			else
			{
				sum += (m/w[i])*(p[i]/w[i]);
				m -= w[i];
			}
		}
		return sum;
	}
	
	
	public static void main(String[] args){
		CopyOfGreedyPart c= new CopyOfGreedyPart();
		
		int[] w={10,20,20};
    	int[] p={60,100,90};


    	double value = c.pack(50, 3, w, p);
    	System.out.println("0-1背包的最大权值是："+value); 	
	}
}
