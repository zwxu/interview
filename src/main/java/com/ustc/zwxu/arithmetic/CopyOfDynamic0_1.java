package com.ustc.zwxu.arithmetic;


public class CopyOfDynamic0_1 {
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
	public int pack(int m, int n, int[] w ,int[] p)
	{ 
		int v[][]= new int[n+1][m+1];  
        for(int i = 0;i<n+1;i++)  
            v[i][0]=0;  
        for(int j = 0;j<m+1;j++)  
            v[0][j]=0;  
        //  
        for(int i = 1;i<n+1;i++){  
            for(int j = 1;j<m+1;j++){  
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：  
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值  
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值  
                if(w[i-1]<=j){  
                        v[i][j] = max(v[i-1][j],v[i-1][j-w[i-1]]+p[i-1]);  
                }else  
                    v[i][j] = v[i-1][j];  
            }  
        }  
	    return v[n][m]; 
	}
	
	public static void main(String[] args){
	    	int[] w={10,20,30};
	    	int[] p={60,100,120};

	    	CopyOfDynamic0_1 c =new CopyOfDynamic0_1();
	    	int value = c.pack(50, 3, w, p);
	    	System.out.println("0-1背包的最大权值是："+value); 	
	    }  
	}  
