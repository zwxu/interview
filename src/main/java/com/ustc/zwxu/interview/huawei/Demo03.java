package com.ustc.zwxu.interview.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Demo03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//华为笔试标准格式
		String input = scanner.nextLine();
		char[] c = input.toCharArray();
		Arrays.sort(c);
		System.out.print(c);
		
	}

}
