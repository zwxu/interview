package com.ustc.zwxu.interview;

import java.util.Scanner;

public class HuaweiDemo02 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int inputDec = in.nextInt();
		int inputNum = in.nextInt();
		int sum=0;
		int temp=0;
		int count=1;
		while(count<=inputNum)
		{
			temp=temp+inputDec;
			sum=sum+temp;
			inputDec=inputDec*10;
			count++;
		}

		System.out.print("sum is--->"+sum);
	}

}
