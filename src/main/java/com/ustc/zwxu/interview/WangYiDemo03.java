package com.ustc.zwxu.interview;

import java.util.Scanner;
import java.util.Arrays;
import java.util.TreeSet;

public class WangYiDemo03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int dp[] = new int[m+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[n] = 0;  // 到达起始位置步数为0步
		for (int i = n; i <= m; i++){
			if (dp[i] == Integer.MAX_VALUE) dp[i] = -1;
			else{
			TreeSet<Integer> list = bcd(i);
			while (!list.isEmpty()){
				int temp = list.pollFirst();
				if (i + temp <= m)
				dp[i+temp] = Math.min(dp[i+temp], dp[i]+1);
				}
			}
		}
		System.out.println(dp[m]);
	}
	/**
	 * 
	 * @author 慕一春
	 * @param num
	 * @return 一个数的最大公约数集list
	 */
	public static TreeSet<Integer> bcd(int num){
	TreeSet<Integer> list = new TreeSet<Integer>();
	 int len = (int) Math.sqrt(num);
		for (int i = 2; i <= len; i++){
			if (num % i == 0){
				list.add(i);
				list.add(num/i);
			}
		}
		return list;
	}
}