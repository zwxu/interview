package com.ustc.zwxu.interview;

import java.math.BigInteger;
import java.util.Scanner;


public class WangYiDemo06 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(solve1(n));

	}



	public static BigInteger solve1(int n) {
		if (n == 1) return BigInteger.ONE;
		if (n % 2 == 1) return solve1(n-1).add(BigInteger.valueOf(n));  
		else	return solve1(n/2).add(BigInteger.valueOf(n).multiply(BigInteger.valueOf(n)).divide(BigInteger.valueOf(4))); 
	}
}
