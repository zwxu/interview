package com.ustc.zwxu.arithmetic;

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic0_1 {
	static int N=3;//三种物品
	static int W=50;//50磅重
	static int[][] value=new int[W+1][N+1];
	public static void init(){
		for(int i=0;i<=W;i++)
			Arrays.fill(value[i], -1);//将数组元素初始为-1
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
		//如果把第i个物品装入背包
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
	public static void main(String[] args){
	    	init();//初始化表格
	    	Item item1=new Item(10,60);
			Item item2=new Item(20,100);
			Item item3=new Item(30,120);
			Item[] item={item1,item2,item3};  
	    	/*Scanner data=new Scanner(System.in);
	    	Item[] item= new Item[N]; 
	    	for(int i=0;i<N;i++){
	    		String s=data.nextLine();
	    	String[] sa=s.split(" ");
	    	int x=Integer.parseInt(sa[0]);
	    	int y=Integer.parseInt(sa[1]);
	    	Item m=new Item(x,y);
	    	item[i]=m;
	    	}*/
	    	System.out.println("背包所能装载的总重量是："+W);
	    	show(item);
	    	System.out.println("0-1背包的最大权值是："+pack(W, N-1, item, value)); 	
	    }  
	}  
class Item {
	public int weight;
	public int price;
	public double pricew;
	public Item(int weight, int price, double pricew) {
		super();
		this.weight = weight;
		this.price = price;
		this.pricew = pricew;
	}
	public Item(int weight, int price) {
		super();
		this.weight = weight;
		this.price = price;
	}	
}