package com.ustc.zwxu.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ALiDemo01 {
	
	private static void sort(int age[])
	{
		int array[]=new int[150];
	
		int n=age.length;
		int[] output=new int[n];
		for(int i=0;i<n;i++)
		{
			int num=age[i];
			array[num]++;
		}
		for(int i=0,j=0;i<100;i++)
		{
			int index=0;
			while(index<array[i])
			{
				age[j++]=i;
				index++;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age[]={90,11,33,47,45,21,23,25,25,32,35,36,40,40,45};
		sort(age);
		
		for(int i:age)
		{
			System.out.print(i+":");
		}
		
		
	}

}
