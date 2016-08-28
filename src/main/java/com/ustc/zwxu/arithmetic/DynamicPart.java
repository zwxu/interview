package com.ustc.zwxu.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DynamicPart {
	static int N=6;
	static int W=5;//50磅重
	static int[][] value=new int[W+1][N+1];
	public static void init(){
		for(int i=0;i<=W;i++)
			Arrays.fill(value[i], -1);
		/*weight[0]=1;price[0]=6/1;
		weight[1]=1;price[1]=6/1;
		weight[2]=1;price[2]=12/2;
		weight[3]=1;price[3]=12/2;
		weight[4]=1;price[4]=30/3;
		weight[5]=1;price[5]=30/3;*/
	}
	public static int pack(int m, int n, Item[] item, int[][] v)
	{ 
	    if (n < 0) 
	    { 
	        return 0; 
	    } 
	    if (m <item[n].weight) //如果第i个物品的重量大于背包的容量
	    { 
	        if (m >= 0) 
	        { 
	            if (v[m][n] == -1) 
	           { 
	                v[m][n] = pack(m, n-1,item,v); 
					//则装人前i个物品得到的最大价值和装入前i-1个物品得到的最大价是相同的
	                return v[m][n]; 
	            } 
	        } 
	        return 0; 
	    } 
	    int a = pack(m-item[n].weight,n-1,item,v) + item[n].price; 
		//装入item1，装入item2，装入item3，递归出最终结果
	    int b = pack(m,n-1,item,v); 
		//如果把第i个物品没有装入背包
	    v[m][n] = a>b?a:b; 
	    return v[m][n]; 
	}
	public static void show(Item[] temp){
		for(int i=0;i<N;i++)
		{
		System.out.println("磅:"+temp[i].weight);	
		System.out.println("元:"+temp[i].price);	
		}
	}
	public static void main(String[] args) {  
	    	init();  
	    	Scanner data=new Scanner(System.in);
	    	Item[] item= new Item[N]; 
	    	for(int i=0;i<N;i++){
	    		String s=data.nextLine();
	    	String[] sa=s.split(" ");
	    	int x=Integer.parseInt(sa[0]);
	    	int y=Integer.parseInt(sa[1]);
	    	y=y/x;
	    	x=1;
	    	//1:6,1:6,2:12,2:12,3:30,3:30
	    	Item m=new Item(x,y);
	    	item[i]=m;
	    	}
	    	/*Item item1=new Item(1,6);
			Item item2=new Item(1,6);
			Item item3=new Item(1,6);
			Item item4=new Item(1,6);
			Item item5=new Item(1,10);
			Item item6=new Item(1,10);*/
	    	System.out.println("背包所能装载的总重量是："+W);
	    	show(item);
	    	System.out.println("部分背包的最大权值是："+pack(W, N-1, item, value)); 	
	    }  
	}  
