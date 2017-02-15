package com.ustc.zwxu.interview.huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Demo08 {

	/**
	 * 利用给定的砝码可以称出的不同的重量数
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//华为笔试标准格式
		int n = scanner.nextInt();
		int[] weight = new int[n];
		int[] nums = new int[n];
		for(int i=0;i<n;i++)
		{
			weight[i]=scanner.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			nums[i]=scanner.nextInt();
		}
		System.out.println(fama(n,weight,nums));
		

	}

	private static int fama(int n, int[] weight, int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0;i<=nums[0];i++)
		{
			set.add(weight[0]*i);
		}
		
		for(int i=1;i<n;i++)
		{
			List<Integer> list = new ArrayList<Integer>(set);
			for(int j=1;j<=nums[i];j++)
			{
				for(int k = 0 ; k < list.size() ; k++)
				{
	                   set.add(list.get(k) + j * weight[i]); 
	            } 
			}
		}
		
		return set.size();
	}

}
