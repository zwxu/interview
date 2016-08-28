package com.ustc.zwxu.arithmetic;

import java.util.Scanner;

public class GreedyPart {
	static int N=3;//三种物品
	static int W=50;//50磅重
	public static Item[] sortPriceW(Item[] a){
		Item[] arr = a;
		int i,j;
		for(j=1;j<arr.length;j++){
			double key=arr[j].pricew;
			i=j-1;
			while(i>-1 && arr[i].pricew<key){
				arr[i+1].pricew=arr[i].pricew;
				i=i-1;
				}
			arr[i+1].pricew=key;
			}
		return arr;	
	}
	static double pack(Item[] item,int m)  //求解最大价值
	{
		double sum=0;
		for(int i=0;i<N;i++)
		{
			if(m<0) continue;
			int tmp=item[i].weight;
			if(tmp<m)//小于背包质量
			{
				sum +=item[i].price;
				m -= item[i].weight;
			}else{
				sum += (double)item[i].price * ((double)m/(double)item[i].weight);
				m -= item[i].weight;
			}
		}
		return sum;
	}
	public static void show(Item[] temp){
		for(int i=0;i<N;i++)
		{
		System.out.println("磅:"+temp[i].weight);	
		System.out.println("元:"+temp[i].price);	
		System.out.println("元/磅:"+temp[i].pricew);	
		}
	}
	public static void main(String[] args){
		/*Item item1=new Item(10,60,6);
		Item item2=new Item(20,100,5);
		Item item3=new Item(30,120,4);
		Item[] item={item1,item2,item3};*/
		Scanner data=new Scanner(System.in);
    	Item[] item= new Item[N]; 
    	for(int i=0;i<N;i++){
    		String s=data.nextLine();
    	String[] sa=s.split(" ");
    	int x=Integer.parseInt(sa[0]);
    	int y=Integer.parseInt(sa[1]);
    	int z=y/x;
    	Item m=new Item(x,y,z);
    	item[i]=m;
    	}
		System.out.println("背包所能装载的总重量是："+W);
		System.out.println("初始化背包信息");
		show(item);
		Item[] newItem=new Item[N];
		newItem=sortPriceW(item);
		System.out.println("排序后的背包信息");
		show(newItem);
		System.out.println("部分背包的最大权值是："+pack(newItem, W)); 	
	}
}
