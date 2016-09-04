package com.ustc.zwxu.arithmetic;


public class CopyOfDynamic0_1_2 {
	private int max(int a,int b)
	{
		if(a>=b)
		{
			return a;
		}
		else
		{
			return b;
		}
	}
	public int backPackII(int m, int[] A, int V[]) {
        int n = A.length;
        int c[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++)
        	c[i][0]=0;
        for(int j=0;j<m+1;j++)
        	c[0][m]=0;
        for(int i=1;i<n+1;i++)
        {
        	 for(int j=1;j<m+1;j++)
        	 {
        		 if(A[i-1]<=j)
        		 {
        			 c[i][j]=max(c[i-1][j],c[i-1][j-A[i-1]]+V[i-1]);
        		 }
        		 else
        		 {
        			 c[i][j]=c[i-1][j];
        		 }
        	 }
        }
		return c[n][m];
    }
	
	public static void main(String[] args){
	    	int[] w={2,3,5,7};
	    	int[] p={1,5,2,4};

	    	CopyOfDynamic0_1_2 c =new CopyOfDynamic0_1_2();
	    	int value = c.backPackII(10, w, p);
	    	System.out.println("0-1背包的最大权值是："+value); 	
	    }  
	}  
