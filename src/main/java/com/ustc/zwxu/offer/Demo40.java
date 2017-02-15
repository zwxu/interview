package com.ustc.zwxu.offer;

import java.util.HashMap;
import java.util.Map;

/*
 * 剑指offer 数组中只出现一次的数字
 */
public class Demo40 {
	
	static void waitForSignal() 
	{
	    Object obj = new Object();
	    synchronized(Thread.currentThread())
	    {
	        try {
				obj.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        obj.notify();
	    }
	}
	
	public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
	       if(array==null ||array.length<2)
	           return ;
	       int temp = 0;
	       for(int i=0;i<array.length;i++)
	           temp ^= array[i];
	        
	       int indexOf1 = findFirstBitIs(temp);//移动的位数
	       for(int i=0;i<array.length;i++){
	           if(isBit(array[i], indexOf1))//满足移动的位数 --一个数组
	               num1[0]^=array[i];
	           else//不满足移动的位数--一个数组
	               num2[0]^=array[i];
	       }
	       System.out.println(num1[0]);
	       System.out.print(num2[0]);
	   }
	   public static int findFirstBitIs(int num){
	       int indexBit = 0;
	       while(((num & 1)==0) && (indexBit)<8*4){
	           num = num >> 1;
	           ++indexBit;
	       }
	       return indexBit;
	   }
	   public static boolean isBit(int num,int indexBit){
	       num = num >> indexBit;
	       return (num & 1) == 1;
	   }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]={2,4,3,6,3,2,5,5};
		int num1[]=new int[1];
		int num2[]=new int[1];
		FindNumsAppearOnce(array,num1,num2);
		waitForSignal();
		
	}

}
